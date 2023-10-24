package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class examsFinalstu {
    Message msg = new Message("");



    public static String courseid;
    @FXML
    private TextField eCode;
    private double time;
    List<Exams> exams= new ArrayList<>() ;
    @FXML
    private TableColumn<Exams, String> examsTablemini;

    @FXML
    private TableColumn<Exams, String> numberTable;
    @FXML
    private ResourceBundle resources;

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
        Message msg1=new Message("start exam");
        msg1.setLogin_name("student");
        ExamInfo examInfo=new ExamInfo();
        examInfo.setExam_id(examsTable.getSelectionModel().getSelectedItem().getId());
        examInfo.setCourseid(examsTable.getSelectionModel().getSelectedItem().getCourse_name());
        examInfo.setStudentid(SimpleClient.ID);
        msg1.setExamInfo(examInfo);
        msg1.setExam(examsTable.getSelectionModel().getSelectedItem());
        msg1.setCourseName(String.valueOf(examsTable.getSelectionModel().getSelectedItem()));
        msg1.setCourse_id(Integer.parseInt(courseid));
        sendMessage(msg1);
        submit_but.setVisible(true);
        submit_exam.setVisible(true);
        submit_textfield.setVisible(true);
        Message msg=new Message("download the exam");
        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
        msg.setCourseName(coursesList.getSelectionModel().getSelectedItem());
        sendMessage(msg);

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
        msg.setExam(examsTable.getSelectionModel().getSelectedItem());
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
            ExamInfo examInfo=new ExamInfo();
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

        } else if (event.getMessage().getMessage().equals("i will give you the exams")) {
            examsTable.getItems().clear();
            List<Exams> exams = event.getMessage().getExams_list_from_server();
            List<ExamsScan>examScanList=event.getMessage().getExamsScans_list_from_server();
            List<Document>documentList=event.getMessage().getDocuments_list_from_server();


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
                            if(Objects.equals(examsTable.getItems().get(j).getId(), examScanList.get(i).getExam_ID()) &&examScanList.get(i).getStudent_state_tostart().equals("false"))
                                examsTable.getItems().remove(j);
                        }

                    }
                }
            }
            for(int i=0;i<documentList.size();i++) {
                if (documentList.get(i).getId_student().equals( String.valueOf(SimpleClient.ID))) {
                    if (coursesList.getSelectionModel().getSelectedItem().equals(documentList.get(i).getCourse_name())){
                        for(int j=0;j<examsTable.getItems().size();j++){
                            if(Objects.equals(examsTable.getItems().get(j).getId(), documentList.get(i).getId_exam()) &&documentList.get(i).getDocinsidetext().equals("false"))
                                examsTable.getItems().remove(j);
                        }

                    }
                }
            }

            examsTable.refresh();
        }
        else if (event.getMessage().getMessage().equals("i will download the exam")) {
            String desktopPath = System.getProperty("user.home") + "/Desktop/"+ examsTable.getSelectionModel().getSelectedItem().getId()+"_"+ SimpleClient.ID +".docx";
            examsTable.getItems().remove(examsTable.getSelectionModel().getSelectedItem());
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
        submit_but.setVisible(false);
        submit_exam.setVisible(false);
        submit_textfield.setVisible(false);
        sendMessage("give me the courses");
        assert coursesList != null : "fx:id=\"coursesList\" was not injected: check your FXML file 'examsFinal.fxml'.";
        assert examsTable != null : "fx:id=\"examsTable\" was not injected: check your FXML file 'examsFinal.fxml'.";

    }

}
