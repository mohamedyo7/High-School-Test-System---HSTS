package il.cshaifasweng.OCSFMediatorExample.server;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.*;
import il.cshaifasweng.OCSFMediatorExample.entities.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//my imports

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;

import il.cshaifasweng.OCSFMediatorExample.server.ocsf.AbstractServer;
import il.cshaifasweng.OCSFMediatorExample.server.ocsf.ConnectionToClient;
//import javax.mail.Session;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleServer extends AbstractServer {
	private static Session session;
/*	private static List<Student> getStudents() throws Exception{
CriteriaBuilder builder = session.getCriteriaBuilder();
CriteriaQuery<Student> query = builder.createQuery(Student.class);
query.from(Student.class);
List<Student> data = session.createQuery(query).getResultList();
return data;

	}*/
	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		SimpleServer.session = session;
	}


	//private static SessionFactory getSessionFactory() throws HibernateException {
		//Configuration configuration = new Configuration();
		// Add ALL of your entities here. You can also try adding a whole package.
		//configuration.addAnnotatedClass(Student.class);
		// serviceRegistry = new StandardServiceRegistryBuilder()
		//		.applySettings(configuration.getProperties())
		//		.build();
		// configuration.buildSessionFactory(serviceRegistry);
	//}



	public SimpleServer(int port) {
		super(port);
		//SessionFactory sessionFactory = getSessionFactory();
		//session = sessionFactory.openSession();
		//session.beginTransaction();
		//generateStudents();
		//session.getTransaction().commit();
}
	private static ArrayList<SubscribedClient> SubscribersList = new ArrayList<>();


	public static void generateStudents(){
		Student student1 = new Student("Rai",100);
		Student student2 = new Student("Muhammad",-10);

	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		Message message = (Message) msg;
		String request = message.getMessage();
		try {
			//we got an empty message, so we will send back an error message with the error details.
			if (request.isBlank()){
				message.setMessage("Error! we got an empty message");
				client.sendToClient(message);
			}
			//we got a request to change submitters IDs with the updated IDs at the end of the string, so we save
			// the IDs at data field in Message entity and send back to all subscribed clients a request to update
			//their IDs text fields. An example of use of observer design pattern.
			//message format: "change submitters IDs: 123456789, 987654321"
			else if(request.startsWith("change submitters IDs:")){
				message.setData(request.substring(23));
				message.setMessage("update submitters IDs");
				sendToAllClients(message);
			}
			//we got a request to add a new client as a subscriber.
			else if (request.equals("add client")){
				SubscribedClient connection = new SubscribedClient(client);
				SubscribersList.add(connection);
				message.setMessage("client added successfully");
				client.sendToClient(message);
				sendToAllClients(message);

			}
			//we got a message from client requesting to echo Hello, so we will send back to client Hello world!
			else if(request.startsWith("st1")){
				message.setMessage("Hello World!and rai");
				client.sendToClient(message);
				sendToAllClients(message);
			}
			else if(request.startsWith("send Submitters IDs")){
				//add code here to send submitters IDs to client
				message.setMessage("Hello World! how are you");
				client.sendToClient(message);
				sendToAllClients(message);
			}
			else if (request.startsWith("send Submitters")){
				//add code here to send submitters names to client
			}
			else if (request.equals("what’s the time?")) {
				//add code here to send the time to client
			}
			else if (request.startsWith("multiply")) {
				//add code here to multiply 2 numbers received in the message and send result back to client
				//(use substring method as shown above)
				//message format: "multiply n*m"
			}
			else if(request.startsWith("change s1 grade")){


				}
			else{
				//add code here to send received message to all clients.
				//The string we received in the message is the message we will send back to all clients subscribed.
				//Example:
					// message received: "Good morning"
					// message sent: "Good morning"
				//see code for changing submitters IDs for help
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void sendToAllClients(Message message) {
		try {
			for (SubscribedClient SubscribedClient : SubscribersList) {
				SubscribedClient.getClient().sendToClient(message);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
