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
     /*   Label label = new Label("Drop files here");
        label.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != label && event.getDragboard().hasFiles()) {
                    event.acceptTransferModes(TransferMode.COPY);
                }
                event.consume();
            }
        });

        label.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;

                if (db.hasFiles()) {
                    for (java.io.File file : db.getFiles()) {
                        // Handle the dropped file here
                        System.out.println("Dropped file: " + file.getAbsolutePath());
                    }
                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });*/

  /*      StackPane root = new StackPane();
        root.getChildren().add(label);
        Scene scene = new Scene(root, 400, 200);*/
        client = SimpleClient.getClient();
        client.setClient_id("asd");
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

    }

}