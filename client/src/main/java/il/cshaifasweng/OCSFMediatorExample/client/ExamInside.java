package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ExamInside {
    int i=1;
    double mark;
    int exam_id;
    String cAns;
    int quenum;

    List<Questions> ques=new ArrayList<>();
    List<Questions> fques=new ArrayList<>();

    List<Exams> exams=new ArrayList<>();
    String id="0";
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
    void backB(ActionEvent event) throws IOException {
        SimpleChatClient.setRoot("examsFinal");
    }

    @FXML
    void doneB(ActionEvent event) throws IOException {
        for (Exams value : exams) {
            if (value.getStat()) {
                fques.clear();
                i = 0;
                id = String.valueOf(value.getId());
                Message msg = new Message("end exam");
                msg.setExam(value);
                sendMessage(msg);
                SimpleChatClient.setRoot("StudentController");
                break;
            }
        }
    }

    @FXML
    void nextb(ActionEvent event) throws IOException {

        if(ans1.isSelected()){
            if(ans1.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans1.setSelected(false);
        }
        if(ans2.isSelected()){
            if(ans2.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans2.setSelected(false);
        }
        if(ans3.isSelected()){
            if(ans3.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans3.setSelected(false);
        }
        if(ans4.isSelected()){
            if(ans4.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans4.setSelected(false);
        }
        if(i<fques.size()){
            question.setText(fques.get(i).getQuestion());
            ans1.setText(fques.get(i).getAns1());
            ans2.setText(fques.get(i).getAns2());
            ans3.setText(fques.get(i).getAns3());
            ans4.setText(fques.get(i).getAns4());
            cAns=fques.get(i).getCorrect_ans();
            i++;
        }
        else {

            fques.clear();
            i = 0;
            cAns = "";
            quenum = 0;
            Message msg = new Message("end exam");
            msg.setId(exam_id);
            sendMessage(msg);
            System.out.println("mark is " + mark);
            msg.setMessage("the grade is");
            msg.setGrade(mark);
            mark = 0.0;
            SimpleChatClient.setRoot("gradeExam");
            sendMessage(msg);
        }
    }


    @Subscribe
    public void setDataFromServerTF(MessageEvent event) {
        if (event.getMessage().getMessage().equals("i will show questions2")){
            ques = event.getMessage().getQuestions_list_from_server();
            exams = event.getMessage().getExams_list_from_server();
            fques.clear();
            id = String.valueOf(exam_id);
            i=0;
            for (Questions que : ques) {
                if (que.getQues_id().equals(id)) {
                    System.out.println("id is"+ que.getQuestion()+ " " + que.getAns1()+" " + que.getAns2());
                    fques.add(que);
                }

            }
            if(!fques.isEmpty()){
                question.setText(fques.get(i).getQuestion());
                System.out.println("ques is "+fques.get(i).getQuestion());
                ans1.setText(fques.get(i).getAns1());
                ans2.setText(fques.get(i).getAns2());
                ans3.setText(fques.get(i).getAns3());
                ans4.setText(fques.get(i).getAns4());
                cAns=fques.get(i).getCorrect_ans();
                i++;
                quenum=fques.size();
            }
            else {
                System.out.println("its null");
            }

        } else if (event.getMessage().getMessage().equals("i will start exam")) {
            exam_id=event.getMessage().getExam().getId();
            System.out.println("hi"+exam_id);
            sendMessage("show questions2");

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
        fques.clear();
        i=0;
        mark=0.0;
        cAns="";
        quenum=0;

        assert ans1 != null : "fx:id=\"ans1\" was not injected: check your FXML file 'examInside.fxml'.";
        assert ans2 != null : "fx:id=\"ans2\" was not injected: check your FXML file 'examInside.fxml'.";
        assert ans3 != null : "fx:id=\"ans3\" was not injected: check your FXML file 'examInside.fxml'.";
        assert ans4 != null : "fx:id=\"ans4\" was not injected: check your FXML file 'examInside.fxml'.";
        assert question != null : "fx:id=\"question\" was not injected: check your FXML file 'examInside.fxml'.";

    }

}