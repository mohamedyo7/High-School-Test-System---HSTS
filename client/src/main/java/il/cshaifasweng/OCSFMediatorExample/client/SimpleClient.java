package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import org.greenrobot.eventbus.EventBus;

import il.cshaifasweng.OCSFMediatorExample.client.ocsf.AbstractClient;

public class SimpleClient extends AbstractClient {

	private static SimpleClient client = null;
	public static int ID;
	public  static int clientx;
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
		}
	 else if (message.getMessage().equals("i will give you the students2")) {
			ID= message.getId();
		EventBus.getDefault().post(new MessageEvent(message));
	}
		else if (message.getMessage().equals("i will check id exist")) {



			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if (message.getMessage().equals("i will give you the student grades")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if (message.getMessage().equals("i created question")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if (message.getMessage().equals("i will give you the courses")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if (message.getMessage().equals("i will give you the courses2")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if (message.getMessage().equals("i will give you the student grades 2")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}else if (message.getMessage().equals("i changed the grade")) {
			EventBus.getDefault().post(new MessageEvent(message));

		}
		else if(message.getMessage().equals("exam is over")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i added the course")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i will show questions")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("I Saved The Student Details")){
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("I Saved The Mediator Details")){
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("I Saved The Teacher Details")){
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if (message.getMessage().equals("course has been registered")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i will give you the student data")){
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i will give you the teacher data")){
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i will give you the mediator data")){
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i will give you the teacher stats")){
			EventBus.getDefault().post(new MessageEvent(message));
		}

		else if(message.getMessage().equals("I Will Show The Courses")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i will show stats")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
	 else if (message.getMessage().equals("i will give you the students")) {
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
		else if(message.getMessage().equals("the grade is")) {
		EventBus.getDefault().post(new MessageEvent(message));}
		else {
			EventBus.getDefault().post(new MessageEvent(message));
		}

	}

	public static SimpleClient getClient() {
		if (client == null) {

			client = new SimpleClient("localhost", 3000);
		}
		return client;
	}

}