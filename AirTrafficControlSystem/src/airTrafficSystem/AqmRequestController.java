package airTrafficSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airTrafficSystem.AqmRequestProcessService.Functions;

/**
 * Servlet implementation class AqmRequestController
 */

@WebServlet(
		description = "Aqm request process",
		urlPatterns = {
				"/systemboot",
				"/enqueue",
				"/dequeue"
		})

public class AqmRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String SYSTEM_BOOT = "/systemboot";
	private final String ENQUEUE = "/enqueue";
	private final String DEQUEUE = "/dequeue";
	
	AqmRequestProcessService service = new AqmRequestProcessService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AqmRequestController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		route(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		route(request,response);
	}
	
	private void route(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String path = req.getServletPath();
	

		switch (path){
		case SYSTEM_BOOT:
			systemboot(req, resp);
			break;
		case ENQUEUE:
			enqueue(req, resp);
			break;
		case DEQUEUE:
			dequeue(req, resp);
			break;
			
		}
	}

	private void dequeue(HttpServletRequest req, HttpServletResponse resp){
		DataWrapper data = new DataWrapper();
		try{
			String node = service.dequeue();
			data.setCargo(node);
			data.setStatus("SUCCESS");
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(Functions.asJSON(data));
		}
		catch(IOException ex){
			createErrorData(data, "Dequeue process failed.");			
		}
		
	}

	private void enqueue(HttpServletRequest req, HttpServletResponse resp){
		DataWrapper data = new DataWrapper();
		try{
			String updatedQueue = service.enqueue();
			data.setCargo(updatedQueue);
			data.setStatus("SUCCESS");
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(Functions.asJSON(data));
		}
		catch(IOException ex){
			createErrorData(data, "Enqueue process failed.");
		}
	}

	private void createErrorData(DataWrapper data, String msg) {
		data.setCargo(null);
		data.setStatus("FAILED");
		data.setErrorMessage(msg);
	}

	private void systemboot(HttpServletRequest req, HttpServletResponse resp) {
		DataWrapper data = new DataWrapper();
		try{
			StringBuilder queue = service.init();
			data.setCargo(queue);
			data.setStatus("SUCCESS");
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(Functions.asJSON(data));
		}
		catch(IOException ex){
			createErrorData(data, "SystemBoot process failed.");
		}
	}

}
