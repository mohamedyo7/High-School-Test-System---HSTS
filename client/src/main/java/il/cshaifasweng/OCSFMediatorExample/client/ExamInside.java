package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Questions;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
public class ExamInside {
    int i=1;
    double time;
    double eTime;
    private PauseTransition delay;
    double mark;
    int exam_id;
    private boolean conditionMet = false;
    private double remainingTime = 0;
    String cAns;
    int quenum;
    String courseid;
    List<Questions> ques=new ArrayList<>();
    List<Questions> fques=new ArrayList<>();
    Message msg = new Message("");
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
                id = String.valueOf(value.getId());
                msg.setMessage("end exam");
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
            msg.setMessage("end exam");
            msg.setId(exam_id);
            sendMessage(msg);
            System.out.println("mark is " + mark);
            msg.setMessage("the grade is");
            msg.setGrade(mark);
            SimpleChatClient.setRoot("gradeExam");
            sendMessage(msg);
        }
    }


    @Subscribe
    public void setDataFromServerTF(MessageEvent event) throws IOException {

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
            if(!(fques.isEmpty())){
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
            fques.clear();
            i = 0;
            eTime=0;
            cAns = "";
            quenum = 0;
            mark = 0.0;
            exam_id=event.getMessage().getExam().getId();
            System.out.println("hi2 " +event.getMessage().getExam().getCode() );
            System.out.println("hi"+exam_id);
            time = event.getMessage().getExam().getTime();
            System.out.println("time"+ time);
            msg.setStudentId(SimpleClient.ID);
            msg.setId(exam_id);
            delay = new PauseTransition(Duration.millis(1000 * 60 * 60 * time));
            delay.setOnFinished(e -> {
                if (conditionMet) {
                    double newDelayMillis = calculateNewDelay();
                    remainingTime += newDelayMillis;
                    updateDelay(remainingTime);
                    System.out.println("etime 1 "+ eTime);
                }
                    System.out.println("etime 2 "+ eTime);
                    System.out.println("over");
                    msg.setMessage("exam is over");
                    System.out.println("heeeeeeeeeeeeeeeeee " + exam_id);
                    msg.setId(exam_id);
                    sendMessage(msg);

            });
            delay.play();
            sendMessage("show questions2");

        }

        else if (event.getMessage().getMessage().equals("exam is over done")){
            //changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
            System.out.println("exam is over done " + event.getMessage().getId());
            if(exam_id==event.getMessage().getId()){

                msg.setMessage("end exam");
                msg.setStudentId(SimpleClient.ID);
                msg.setGrade_to_change((int)mark);
                msg.setId(exam_id);
                sendMessage(msg);
                System.out.println("mark is " + mark);
                msg.setMessage("the grade is");
                msg.setGrade(mark);
                SimpleChatClient.setRoot("gradeExam");
                sendMessage(msg);
            }


        }
        else if (event.getMessage().getMessage().equals("extra time")){
            eTime=msg.geteTime();
        }

    }
    private double calculateNewDelay() {
        // Calculate the new delay based on your condition
        return eTime; // Example: 5 seconds
    }
    public void updateDelay(double newDelayMillis) {
        if (delay != null) {
            delay.stop();
            delay.setDuration(Duration.millis(newDelayMillis));
            delay.play();
        }
    }
    public void setConditionMet(boolean conditionMet) {
        this.conditionMet = conditionMet;
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