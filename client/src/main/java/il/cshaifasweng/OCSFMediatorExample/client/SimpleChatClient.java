package il.cshaifasweng.OCSFMediatorExample.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * JavaFX App
 */
public class SimpleChatClient extends Application {

    private static Scene scene;
    private SimpleClient client;

    public static int client_id=0;

    @Override
    public void start(Stage stage) throws IOException {
        EventBus.getDefault().register(this);
        client = SimpleClient.getClient();
        client.openConnection();
        scene = new Scene(loadFXML("FirstPage"), 700, 742);
        stage.setScene(scene);
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SimpleChatClient.class.getResource(fxml + ".fxml"));
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
        if(SimpleClient.show) {
            SimpleClient.show=false;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
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
    }


    public static void main(String[] args) {


        launch();


}}