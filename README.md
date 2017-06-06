# AircraftTrafficManagemanetServiceProcess

To run the Project in eclipse, install Tomcat v9.0 and have JRE set to 1.8. 

Solution as following breakdown:
Src/airTrafficSystem
1) AirCraft.java is a data structure for AirCraft.
2) Implemented priority queue using linkedlist (AirCraftQueueNode.java and AirCraftQueueLinkedList.java)

Also implemented three endpoints:
1) http://localhost:8080/AirTrafficControlSystem/systemboot
This EndPoint initialize an Aircraft traffic management queue if it’s not already initialize and returns the queue.

2) http://localhost:8080/AirTrafficControlSystem/enqueue
This EndPoint will random will create a AirCraft and enqueue in the queue at a position defined by priority condition and return the queue with inserted node. 

3) http://localhost:8080/AirTrafficControlSystem/dequeue
This EndPoint remove the AirCraft from the queue and return dequeue AirCraft/Node.

Few Junits are also covered under the package Src/Junits. 
