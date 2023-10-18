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
    private PauseTransition delay2;
    double mark;
    int exam_id;
    String exam_name;
    String std_ans;
    private boolean conditionMet;
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
            std_ans=ans1.getText();
            if(ans1.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans1.setSelected(false);
        }
        if(ans2.isSelected()){
            std_ans=ans2.getText();
            if(ans2.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans2.setSelected(false);
        }
        if(ans3.isSelected()){
            std_ans=ans3.getText();
            if(ans3.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans3.setSelected(false);
        }
        if(ans4.isSelected()){
            std_ans=ans4.getText();
            if(ans4.getText().equals(cAns)){
                mark+= ((double) 100 /quenum);
            }
            ans4.setSelected(false);
        }
        System.out.println("mark is 1 ");
        Message msg1=new Message("save data");
        System.out.println("mark is 2 ");
        msg1.setId(exam_id);
        System.out.println(exam_id+"mark is 3 ");
        msg1.setCourseName(exam_name);
        System.out.println(exam_name+"mark is 4 ");
        msg1.setAns(std_ans);
        System.out.println(std_ans+"mark is 5 ");
        msg1.setStudentId(SimpleClient.ID);
        System.out.println(SimpleClient.ID+"mark is 6 ");
        msg1.setType(question.getText());
        sendMessage(msg1);
        System.out.println("mark is 7 ");
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
            conditionMet=true;
            msg.setMessage("exam is over");
            //msg.setId(exam_id);
            sendMessage(msg);
            //System.out.println("mark is " + mark);
            //msg.setMessage("the grade is");
            //msg.setGrade(mark);
            //SimpleChatClient.setRoot("gradeExam");
            //sendMessage(msg);
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
                if(!fques.get(i).getQues_id().equals("empty")) {
                    //if(ans1.getText().isEmpty())
                    ans1.setText(fques.get(i).getAns1());
                    // if(ans2.getText().isEmpty())
                    ans2.setText(fques.get(i).getAns2());
                    // if(ans3.getText().isEmpty())
                    ans3.setText(fques.get(i).getAns3());
                    // if(ans4.getText().isEmpty())
                    ans4.setText(fques.get(i).getAns4());
                    // if(cAns.isEmpty())
                    cAns = fques.get(i).getCorrect_ans();
                }
                    i++;
                    quenum = fques.size();

            }
            else {
                System.out.println("its null");
            }

        } else if (event.getMessage().getMessage().equals("i will start exam")) {
            fques.clear();
            i = 1;
            eTime=0;
            cAns = "";
            quenum = 0;
            mark = 0.0;
            exam_id=event.getMessage().getExam().getId();
            System.out.println("hi2 " +event.getMessage().getExam().getCode() );
            exam_name=event.getMessage().getExam().getCourse_name();
            System.out.println("hi"+exam_id);
            time = event.getMessage().getExam().getTime();
            System.out.println("time"+ time);
            msg.setStudentId(SimpleClient.ID);
            msg.setId(exam_id);

            delay = new PauseTransition(Duration.millis(1000 * 60 * time));
            conditionMet = false;
            delay.setOnFinished(e -> {
                System.out.println(conditionMet);
                if (conditionMet) {
                }else {
                    delay2 = new PauseTransition(Duration.millis(1000 * 60 * eTime));
                    delay2.setOnFinished(d -> {
                        System.out.println("etime");
                        System.out.println(eTime);
                        System.out.println("11");
                        msg.setMessage("exam is over");
                        msg.setId(exam_id);
                        sendMessage(msg);
                        System.out.println("2222");
                    });
                    delay2.play();
                    }
            });
            delay.play();
            sendMessage("show questions2");

        }
        else if (event.getMessage().getMessage().equals("i will save data")) {
            System.out.println("beje?");

        }

        else if (event.getMessage().getMessage().equals("exam is over done")){
            //changeGrade(message.getStudentId(), message.getCourse_id(), message.getGrade_to_change());
            System.out.println("3");
            System.out.println(exam_id);
            System.out.println(event.getMessage().getId());
            if(exam_id==event.getMessage().getId()){
                msg.setIs_finished(conditionMet);
                msg.setMessage("end exam");
                msg.setStudentId(SimpleClient.ID);
                msg.setGrade_to_change((int)mark);
                msg.setId(exam_id);
                sendMessage(msg);
                msg.setMessage("the grade is");
                msg.setGrade(mark);
                SimpleChatClient.setRoot("gradeExam");
                sendMessage(msg);
            }
            System.out.println("4");

        }
        else if (event.getMessage().getMessage().equals("extra time")){
            eTime=event.getMessage().geteTime();
            System.out.println("etime" + eTime);
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
        conditionMet = true;
        fques.clear();
        i=1;
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