package airTrafficSystem;

public class DataWrapper {
	private String status;
	private String errorMessage;
	private Object cargo;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Object getCargo() {
		return cargo;
	}

	public void setCargo(Object cargo) {
		this.cargo = cargo;
	}
}
