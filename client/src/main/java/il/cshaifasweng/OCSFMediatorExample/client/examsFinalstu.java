package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class examsFinalstu {
    Message msg = new Message("");
    private boolean conditionMet;
    private PauseTransition delay;
    private PauseTransition delay2;
    double mark;
    String exam_id;
    double time;
    double eTime;
    ExamInfo examInfo = new ExamInfo();
    public static String courseid;
    @FXML
    private TextField eCode;
    List<Exams> exams= new ArrayList<>() ;
    @FXML
    private TableColumn<Exams, String> examsTablemini;

    @FXML
    private TableColumn<Exams, String> numberTable;
    @FXML
    private ResourceBundle resources;
    @FXML
    private Button downlodExamid;
    @FXML
    private URL location;

    @FXML
    private TextField studenid;
    @FXML
    private ListView<String> coursesList;
    @FXML
    private TableView<Exams> examsTable;
    @FXML
    private ListView<String> examsList;

    @FXML
    private Button start_b;

    public examsFinalstu() throws FileNotFoundException {
    }

    @FXML
    void BackB(ActionEvent event) throws IOException {
            Message msg = new Message("give me student data");
            sendMessage(msg);
            SimpleChatClient.setRoot("StudentController");}
    @FXML
    void download_exam(ActionEvent event) throws FileNotFoundException {
        if(examsTable.getSelectionModel().getSelectedItem().getCode().equals(eCode.getText())&&Integer.parseInt(studenid.getText())==SimpleClient.ID) {
            //downlodExamid.setVisible(false);
            start_b.setVisible(false);
            submit_but.setVisible(true);
            submit_exam.setVisible(true);
            submit_textfield.setVisible(true);
            examInfo.setExam_id(examsTable.getSelectionModel().getSelectedItem().getId());
            examInfo.setCourseid(examsTable.getSelectionModel().getSelectedItem().getCourse_name());
            examInfo.setStudentid(SimpleClient.ID);
            examInfo.setActualDuration(time);
            examInfo.setExecutionDateTime(new Date());
            examInfo.setNumberOfStartedStudents(1);
            msg.setExamInfo(examInfo);
            msg.setExam(examsTable.getSelectionModel().getSelectedItem());
            msg.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));
            msg.setCourse_id(Integer.parseInt(courseid));
            msg.setMessage("download the exam");
            msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
            sendMessage(msg);
            exam_id = examsTable.getSelectionModel().getSelectedItem().getId();
            time = msg.getExam().getTime();
            delay = new PauseTransition(Duration.millis(1000 * 60 * time));
            conditionMet = false;
            delay.setOnFinished(e -> {
                if (conditionMet) {
                } else {
                    delay2 = new PauseTransition(Duration.millis(1000 * 60 * eTime));
                    delay2.setOnFinished(d -> {
                        examInfo.setNumberOfFailedStudents(1);
                        System.out.println("enifo  " + examInfo.getId());
                        msg.setExamInfo(examInfo);
                        msg.setMessage("exam is over");
                        msg.setExam_id(exam_id);
                        submit_textfield.setText("");
                        submit_but.setVisible(false);
                        submit_exam.setVisible(false);
                        submit_textfield.setVisible(false);
                        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
                        msg.setStudentId(Integer.parseInt(studenid.getText()));
                        msg.setPath("0");
                        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
                        sendMessage(msg);
                        System.out.println("exam is over");
                        sendMessage(msg);
                        msg.setMessage("update document");
                        sendMessage(msg);
                    });
                    delay2.play();
                }
            });
            delay.play();
        }
        else System.out.println("Wrong code");
    }
    @FXML
    private Button submit_but;

    @FXML
    private Label submit_exam;

    @FXML
    private TextField submit_textfield;
    @FXML
    void Submit_but(ActionEvent event) {

        Message msg=new Message("update document");
        if(examsTable.getSelectionModel().getSelectedItem().getCode().equals(eCode.getText())&&Integer.parseInt(studenid.getText())==SimpleClient.ID) {

        } msg.setExam(examsTable.getSelectionModel().getSelectedItem());
        msg.setStudentId(Integer.parseInt(studenid.getText()));
        msg.setPath(submit_textfield.getText());
        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);




    }

    @FXML
    void startB(ActionEvent event) throws IOException {
        if(examsTable.getSelectionModel().getSelectedItem().getCode().equals(eCode.getText())&&Integer.parseInt(studenid.getText())==SimpleClient.ID){
            msg.setMessage("start exam");
            msg.setLogin_name("student");
            examInfo.setExam_id(examsTable.getSelectionModel().getSelectedItem().getId());
            examInfo.setCourseid(examsTable.getSelectionModel().getSelectedItem().getCourse_name());
            examInfo.setStudentid(SimpleClient.ID);
            msg.setExamInfo(examInfo);
            msg.setExam(examsTable.getSelectionModel().getSelectedItem());
            msg.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));
            msg.setCourse_id(Integer.parseInt(courseid));
            SimpleChatClient.setRoot("examInside");
            sendMessage(msg);

            } else{
                System.out.println("Wrong code or id");
                sendMessage("wrong code or id");}
        }

    @FXML
    void showExams(ActionEvent event) {
        Message msg =new Message("show exams");
        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);
    }

    @Subscribe
    public void setDataFromServerTF(MessageEvent event) throws IOException {
        if (event.getMessage().getMessage().equals("i will give you the courses")) {

            coursesList.getItems().clear();

                List<CourseReg> Courses_from_server_reg = event.getMessage().getCourses_list_from_server_reg();
                List<Exams>Exams_from_server=event.getMessage().getExams_list_from_server();
                List<Course>courses=event.getMessage().getCourses_list_from_server();


                for (int i = 0; i < Courses_from_server_reg.size(); i++) {

                    // Set the data to the table
                    if (Courses_from_server_reg.get(i).getStudent() != null) {

                        if (Courses_from_server_reg.get(i).getStudent().getStudent_id() == SimpleClient.ID) {

                            for (int j = 0; j < Exams_from_server.size(); j++) {

                                if (Courses_from_server_reg.get(i).getName().equals(Exams_from_server.get(j).getCourse_name())) {

                                    if (Exams_from_server.get(j).getStat()) {

                                        exams.add(Exams_from_server.get(j));

                                        coursesList.getItems().add(Courses_from_server_reg.get(i).getName());

                                        for (int x = 0; x < courses.size(); x++) {

                                            if (Courses_from_server_reg.get(i).getName().equals(courses.get(x).getName()))
                                                courseid = String.valueOf(courses.get(x).getId());
                                        }
                                    }
                                }
                            }

                        }

                    }
                }

                coursesList.refresh();

        } else if (event.getMessage().getMessage().equals("exam is over done")){
            if(exam_id.equals(event.getMessage().getExam_id())){
                msg.setIs_finished(conditionMet);
                msg.setMessage("end exam");
                msg.setStudentId(SimpleClient.ID);
                msg.setGrade_to_change((int)mark);
                msg.setExam_id(exam_id);
                sendMessage(msg);
                SimpleChatClient.setRoot("StudentController");
            }

        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();
            List<ExamsScan>examScanList=event.getMessage().getExamsScans_list_from_server();


            examsTablemini.setCellValueFactory(new PropertyValueFactory<>("id"));
            numberTable.setCellValueFactory(new PropertyValueFactory<>("ques_number"));

            for(int i=1;i<exams.size();i++){
                if(coursesList.getSelectionModel().getSelectedItem()!=null)
                    if(coursesList.getSelectionModel().getSelectedItem().equals(exams.get(i).getCourse_name())){
                        examsTable.getItems().add(exams.get(i));
                    }


            }
            for(int i=0;i<examScanList.size();i++) {
                if (examScanList.get(i).getStudent_ID() == SimpleClient.ID) {
                    if (coursesList.getSelectionModel().getSelectedItem().equals(examScanList.get(i).getName())){
                        for(int j=0;j<examsTable.getItems().size();j++){
                            if(examsTable.getItems().get(j).getId()==examScanList.get(i).getExam_ID()&&examScanList.get(i).getStudent_state_tostart().equals("false"))
                                examsTable.getItems().remove(j);
                        }

                    }
                }
            }
            examsTable.refresh();
        }
        else if (event.getMessage().getMessage().equals("i will download the exam")) {
            String desktopPath = System.getProperty("user.home") + "/Desktop/"+ examsTable.getSelectionModel().getSelectedItem().getId()+"_"+ SimpleClient.ID +".docx";
            submit_textfield.setText(desktopPath);
            XWPFDocument document=new XWPFDocument();
            FileOutputStream out = new FileOutputStream(desktopPath);
            XWPFParagraph paragraph=document.createParagraph();
            XWPFRun run=paragraph.createRun();
            List<Questions>questionsList=event.getMessage().getQuestions_list_from_server();
            run.setText("Please Answer The Questions Below :");
            run.addBreak();
            run.addBreak();
            run.addBreak();


            for(int i=0;i<questionsList.size();i++){
                if(questionsList.get(i).getQues_id().equals(String.valueOf(event.getMessage().getExam().getId()))&&questionsList.get(i).getCourse_name().equals(event.getMessage().getCourseName())){

                    run.setText(questionsList.get(i).getQuestion());
                    run.addBreak();
                    run.addBreak();

                    run.setText("1) "+questionsList.get(i).getAns1());
                    run.addBreak();
                    run.setText("2) "+questionsList.get(i).getAns2());
                    run.addBreak();
                    run.setText("3) "+questionsList.get(i).getAns3());
                    run.addBreak();
                    run.setText("4) "+questionsList.get(i).getAns4());
                    run.addBreak();
                    run.addBreak();
                    run.setText("Please Write Your Answer : ");
                    run.addBreak();
                    run.setText("");
                    run.addBreak();
                    run.addBreak();
                    run.addBreak();


                }
            }
            document.write(out);
            out.close();

        }
        else if (event.getMessage().getMessage().equals("extra time")){
            System.out.println("etttttttttt");
            if(exam_id.equals(event.getMessage().getExam().getId())) {
                eTime = event.getMessage().geteTime();
                System.out.println("etime is +  " + eTime);
            }
            else
                System.out.println("no eT");
        }
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
        submit_but.setVisible(false);
        submit_exam.setVisible(false);
        submit_textfield.setVisible(false);

        eTime=0;
        sendMessage("give me the courses");
        assert coursesList != null : "fx:id=\"coursesList\" was not injected: check your FXML file 'examsFinal.fxml'.";
        assert examsTable != null : "fx:id=\"examsTable\" was not injected: check your FXML file 'examsFinal.fxml'.";

    }

}
