package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import org.greenrobot.eventbus.EventBus;

import il.cshaifasweng.OCSFMediatorExample.client.ocsf.AbstractClient;

public class SimpleClient extends AbstractClient {
	//public Exams examclient=new Exams();
	private static SimpleClient client = null;

	private SimpleClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		Message message = (Message) msg;

		if (message.getMessage().equals("client added successfully")) {
			//do nothing!!
		} else if (message.getMessage().equals("i will give you the students")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the student grades")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the exams")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will start exam")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}else if (message.getMessage().equals("i added the exam")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}else if (message.getMessage().equals("i created question")) {
			EventBus.getDefault().post(new MessageEvent(message));}
		else if (message.getMessage().equals("i will give you the courses")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the student grades 2")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}else if (message.getMessage().equals("i changed the grade")) {
			EventBus.getDefault().post(new MessageEvent(message));}
		else if(message.getMessage().equals("i added the course")) {
			EventBus.getDefault().post(new MessageEvent(message));}
		else if(message.getMessage().equals("i will show questions")) {
			EventBus.getDefault().post(new MessageEvent(message));}
		else if(message.getMessage().equals("i will show questions2")) {
			EventBus.getDefault().post(new MessageEvent(message));}
		else {System.out.println("else");
		}

	}

	public static SimpleClient getClient() {
		if (client == null) {

			client = new SimpleClient("localhost", 3000);
		}
		return client;
	}

}