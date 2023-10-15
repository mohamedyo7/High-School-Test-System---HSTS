package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamsScan;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;

public class ScanPage {

    @FXML
    private TextArea Corr_Ans;

    @FXML
    private ListView<String> Questions_exam_list;

    @FXML
    private TextArea Your_ans;

    @FXML
    void Back_but(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("StudentController");

    }

    @FXML
    void Show_Ans(ActionEvent event) {
        Message msg=new Message("Show Answers");
        String s=exam_list.getSelectionModel().getSelectedItem();
        msg.setId(Integer.parseInt(s));
        msg.setCourseName(Questions_exam_list.getSelectionModel().getSelectedItem());
        sendMessage(msg);

    }

    @FXML
    private ListView<String> exam_list;
    @FXML
    void Show_Ques(ActionEvent event) {
        Message msg=new Message("give me exam questions");
        String s=exam_list.getSelectionModel().getSelectedItem();
        msg.setId(Integer.parseInt(s));
        sendMessage(msg);

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
    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will give you exams scans")) {
            int c=0;
            exam_list.getItems().clear();
            List<ExamsScan> examsScanList=event.getMessage().getExamsScans_list_from_server();

            List<Questions>questionsList=event.getMessage().getQuestions_list_from_server();
            for(int i=0;i<examsScanList.size();i++) {

                if (examsScanList.get(i).getStudent_ID() == event.getMessage().getId() && examsScanList.get(i).getName().equals(event.getMessage().getCourseName())) {
                    for(int j=0;j<examsScanList.size();j++) {
                        if(!(exam_list.getItems().isEmpty()))
                        if(exam_list.getItems().get(j).equals(String.valueOf(examsScanList.get(i).getExam_ID())))
                            c=1;
                    }
                    if(c==0)
                    exam_list.getItems().add(String.valueOf(examsScanList.get(i).getExam_ID()));
                }
            }
            exam_list.refresh();



            }
        else  if (event.getMessage().getMessage().equals("i will give you exams questions")) {


            Questions_exam_list.getItems().clear();


            List<Questions>questionsList=event.getMessage().getQuestions_list_from_server();
            for(int i=0;i<questionsList.size();i++) {

                if (questionsList.get(i).getQues_id().equals(String.valueOf(event.getMessage().getId()))) {
                    Questions_exam_list.getItems().add(questionsList.get(i).getQuestion());
                }
            }
            Questions_exam_list.refresh();


        }
        else  if (event.getMessage().getMessage().equals("i will Show Answers")) {


            //Corr_Ans.clear();
            //Your_ans.clear();


            List<Questions>questionsList=event.getMessage().getQuestions_list_from_server();
            for(int i=0;i<questionsList.size();i++) {

                if(questionsList.get(i).getQues_id().equals(String.valueOf(event.getMessage().getId())))
                if (questionsList.get(i).getQuestion().equals(String.valueOf(event.getMessage().getCourseName()))) {
                    Corr_Ans.setText(questionsList.get(i).getCorrect_ans());
                }
            }
            List<ExamsScan>examsScanList=event.getMessage().getExamsScans_list_from_server();
            for(int i=0;i<examsScanList.size();i++) {

                if(examsScanList.get(i).getExam_ID()==event.getMessage().getId())
                    if (examsScanList.get(i).getType().equals(String.valueOf(event.getMessage().getCourseName()))) {
                        Your_ans.setText(examsScanList.get(i).getAnswer());
                    }
            }





        }
        }
    @FXML
    void initialize() {

        EventBus.getDefault().register(this);
    }
    }

