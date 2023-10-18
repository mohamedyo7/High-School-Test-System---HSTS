package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ExtraTimeRequests {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Exams, String > courseName;

    @FXML
    private TableColumn<Exams, String > examID;

    @FXML
    private TextField reason;

    @FXML
    private TableView<Exams> requestsTable;

    @FXML
    private TableColumn<Exams, String> teacherID;

    @FXML
    private TableColumn<Exams, String > teacherName;

    @FXML
    void acceptRequest(ActionEvent event) {

    }

    @FXML
    void backB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("MediatorPage");
    }
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        requestsTable.getItems().clear();
        courseName.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        examID.setCellValueFactory(new PropertyValueFactory<>("id"));
        teacherName.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        teacherID.setCellValueFactory(new PropertyValueFactory<>("teacherID"));
       if(event.getMessage().getMessage().equals("i will show mediator requests")){
           List<Exams> exams = event.getMessage().getExams_list_from_server();
           for (Exams e : exams){
               if(e.isRequest()){
                   requestsTable.getItems().add(e);
               }
           }
           requestsTable.refresh();
       }

    }
    @FXML
    void ignoreReuest(ActionEvent event) {

    }
    void sendMessage(Message message) {

        try {
            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    void sendMessage(String messageBody) {
        try {
            Message message = new Message( messageBody);

            SimpleClient.getClient().sendToServer(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    void initialize() {
        EventBus.getDefault().register(this);
        sendMessage("show mediator requests");
        assert courseName != null : "fx:id=\"courseName\" was not injected: check your FXML file 'extraTimeRequests.fxml'.";
        assert examID != null : "fx:id=\"examID\" was not injected: check your FXML file 'extraTimeRequests.fxml'.";
        assert reason != null : "fx:id=\"reason\" was not injected: check your FXML file 'extraTimeRequests.fxml'.";
        assert requestsTable != null : "fx:id=\"requestsTable\" was not injected: check your FXML file 'extraTimeRequests.fxml'.";
        assert teacherID != null : "fx:id=\"teacherID\" was not injected: check your FXML file 'extraTimeRequests.fxml'.";
        assert teacherName != null : "fx:id=\"teacherName\" was not injected: check your FXML file 'extraTimeRequests.fxml'.";

    }

}
