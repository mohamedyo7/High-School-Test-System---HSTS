package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.client.ocsf.AbstractClient;
import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import org.greenrobot.eventbus.EventBus;

public class SimpleClient extends AbstractClient {

	private static SimpleClient client = null;
	public static int ID;
	public static boolean show=false;
	public static String Type;
	public static String cname;
	public static String name;
	private int client_id;

	private SimpleClient(String host, int port) {
		super(host, port);
	}

	@Override
	protected void handleMessageFromServer(Object msg) {
		Message message = (Message) msg;

		if (message.getMessage().equals("client added successfully")) {
		System.out.println("client2"+SimpleChatClient.client_id);
		} else if (message.getMessage().equals("i will give you the students")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the students2")) {
		ID = message.getId();
		Type=message.getLogin_name();
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will check id exist")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the student grades")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i created question")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the courses")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the courses2")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the student grades 2")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you students id")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you students id2")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will add note")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you exams questions")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will Show Answers")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will save data")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you exams scans")) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i changed the grade")) {
		EventBus.getDefault().post(new MessageEvent(message));
		}else if (message.getMessage().equals("exam is over done")) {
		EventBus.getDefault().post(new MessageEvent(message));
		}else if (message.getMessage().equals("extra time")) {EventBus.getDefault().post(new MessageEvent(message));
		}else if(message.getMessage().equals("i added the course")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("i will show questions")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("I Saved The Student Details")){
		ID= message.getId();
		System.out.println(ID);
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("I Saved The Mediator Details")){
		ID= message.getId();
		System.out.println(ID);
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("I Saved The Teacher Details")){
		ID= message.getId();
		System.out.println(ID);
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("course has been registered")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("i will give you the student data")){
		System.out.println(ID);
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("i will give you the teacher data")){
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("i will give you the mediator data")){
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("i will give you the teacher stats")){
		EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("I Will Show The Courses")) {
		EventBus.getDefault().post(new MessageEvent(message));

		} else if(message.getMessage().equals("i will show stats")) {
		EventBus.getDefault().post(new MessageEvent(message));
		}else if (message.getMessage().equals("i will give you the students")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the student grades")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will give you the exams")) {
		EventBus.getDefault().post(new MessageEvent(message));
		} else if (message.getMessage().equals("i will start exam")) {
			System.out.println("?");
		cname=message.getCourseName();
		System.out.println("??");
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
		else if(message.getMessage().equals("test") && message.getToid()==ID) {
			System.out.println(ID);
			System.out.println("Test1!!!");
			System.out.println(message.getToid());
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("wrong code or id")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}
		else if(message.getMessage().equals("i will show mediator requests")) {
			EventBus.getDefault().post(new MessageEvent(message));
		}else if(message.getMessage().equals("extra time accepted" )) {
			EventBus.getDefault().post(new MessageEvent(message));
		} else if(message.getMessage().equals("i will give you exams info")) {
		EventBus.getDefault().post(new MessageEvent(message));
	}
		else {
		//EventBus.getDefault().post(new MessageEvent(message));
		}

		}

	public static SimpleClient getClient() {
		if (client == null) {

			client = new SimpleClient("localhost", 3000);

		}
		return client;
	}

}