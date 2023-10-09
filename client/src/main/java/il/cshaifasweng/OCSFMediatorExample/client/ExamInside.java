package il.cshaifasweng.OCSFMediatorExample.client;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ExamInside {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox ans1;

    @FXML
    private CheckBox ans2;

    @FXML
    private CheckBox ans3;

    @FXML
    private CheckBox ans4;

    @FXML
    private Text question;
    Exams exam = new Exams();
    @FXML
    void ans1b(ActionEvent event) {

    }

    @FXML
    void ans2b(ActionEvent event) {

    }

    @FXML
    void ans3b(ActionEvent event) {

    }

    @FXML
    void ans4b(ActionEvent event) {

    }

    @FXML
    void backB(ActionEvent event) {

    }

    @FXML
    void doneB(ActionEvent event) {

    }

    @FXML
    void nextb(ActionEvent event) {

    }

    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you the exams")){
            List<Exams> exam=event.getMessage().getExams_list_from_server();
            Exams exams = null;

            for (int j=1;j<exam.size();j++){
                if(exam.get(j).getStat()){
                   List<Questions> ques=exam.get(j).getQuestions();
                   exams=exam.get(j);
                }}
            if(exams!=null){
                //start from here to set the exam and quesions
            }
            question.setText("hi how are you");
            }

            //start from here exam.question have problem


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
        sendMessage("show exams");
        assert ans1 != null : "fx:id=\"ans1\" was not injected: check your FXML file 'examInside.fxml'.";
        assert ans2 != null : "fx:id=\"ans2\" was not injected: check your FXML file 'examInside.fxml'.";
        assert ans3 != null : "fx:id=\"ans3\" was not injected: check your FXML file 'examInside.fxml'.";
        assert ans4 != null : "fx:id=\"ans4\" was not injected: check your FXML file 'examInside.fxml'.";
        assert question != null : "fx:id=\"question\" was not injected: check your FXML file 'examInside.fxml'.";

    }

}
