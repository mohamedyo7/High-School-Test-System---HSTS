package il.cshaifasweng.OCSFMediatorExample.client;
import il.cshaifasweng.OCSFMediatorExample.client.SimpleClient;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * JavaFX App
 */
public class SimpleChatClient extends Application {
/*    private ObservableList<Student> createSampleStudentData() {
        ObservableList<Student> students = FXCollections.observableArrayList();
        students.add(new Student("John Doe", 85));
        students.add(new Student("Jane Smith", 92));
        students.add(new Student("Michael Johnson", 78));
        students.add(new Student("Emily Williams", 95));
        students.add(new Student("Robert Brown", 88));
        students.add(new Student("Olivia Davis", 91));
        students.add(new Student("William Miller", 84));
        students.add(new Student("Sophia Wilson", 79));
        students.add(new Student("James Taylor", 87));
        students.add(new Student("Elizabeth Anderson", 90));
        return students;
    }*/
    private static Scene scene;
    private SimpleClient client;
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("server is listening");
    	EventBus.getDefault().register(this);
        System.out.println("server is listening2");
        SimpleClient client = SimpleClient.getClient();
        System.out.println("server is listening3");
    	client.openConnection();
        System.out.println("server is listening4");
        scene = new Scene(loadFXML("primary"), 600, 400);
        System.out.println("server is listening5");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        System.out.println("server is listening6");
        FXMLLoader fxmlLoader = new FXMLLoader(SimpleChatClient.class.getResource(fxml + ".fxml"));
        System.out.println("server is listening 7");
        return fxmlLoader.load();
    }
    
    

    @Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
    	EventBus.getDefault().unregister(this);
		super.stop();
	}


    @Subscribe
    public void onMessageEvent(MessageEvent message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.INFORMATION,
                    String.format("Message:\nId: %d\nData: %s\nTimestamp: %s\n",
                            message.getMessage().getId(),
                            message.getMessage().getMessage(),
                            message.getMessage().getTimeStamp().format(dtf))
            );
            alert.setTitle("new message");
            alert.setHeaderText("New Message:");
            alert.show();
        });
    }


	public static void main(String[] args) {
        launch();
    }

}