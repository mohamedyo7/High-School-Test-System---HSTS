package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class EditGrade {

    @FXML
    private ListView<String> STD_ID_LIST;
    @FXML
    private ListView<String> student_word;

    @FXML
    private TextArea word_scan;

    public static int student_id_toaddnote;
    public static String course_name;
     public static int course_id_to_word;

    @FXML
    void Back_but(ActionEvent event) throws IOException {
     SimpleChatClient.setRoot("TeacherPage");

    }
    @FXML
    private ListView<String> STD_Course_LIST;

    @FXML
    private Label student_scan_label;

    @FXML
    void STD_Course_LIST_Pressed(MouseEvent event) {
        Message msg=new Message("give me students id2");
        String s1=STD_Course_LIST.getSelectionModel().getSelectedItem();
        msg.setCourseName(s1);
        sendMessage(msg);


    }
    @FXML
    void student_word_pressed(MouseEvent event) {
        word_scan.setVisible(true);
        word_scan_label.setVisible(true);
        insert_grade_but.setVisible(true);
        insert_grade_field.setVisible(true);
        insert_grade_label.setVisible(true);
        //student_scan_label.setVisible(true);
        Message msg=new Message("give me word scan");
        msg.setStudentId(Integer.parseInt(student_word.getSelectionModel().getSelectedItem()));
        msg.setCourseName(STD_Course_LIST.getSelectionModel().getSelectedItem());
        sendMessage(msg);



    }
    @FXML
    private Button insert_grade_but;

    @FXML
    private TextField insert_grade_field;

    @FXML
    private Text insert_grade_label;

    @FXML
    private Text word_scan_label;
    @FXML
    void insert_grade_but(ActionEvent event) {
        Message msg = new Message("change the student grade");
        msg.setGrade(Double.parseDouble(insert_grade_field.getText()));
        msg.setGrade_to_change((int) msg.getGrade());
        msg.setCourse_id(course_id_to_word);
        msg.setStudentId(Integer.parseInt(student_word.getSelectionModel().getSelectedItem()));
        sendMessage(msg);
        }



    @FXML
    void STD_ID_LIST_PRESS(MouseEvent event) throws IOException {
        SimpleChatClient.setRoot("ScanPage");
        Message msg=new Message("give me exams scans");
        String s=STD_ID_LIST.getSelectionModel().getSelectedItem();
        if(s!=null) {
            msg.setId(Integer.parseInt(s));
            msg.setExam_id(s);
            student_id_toaddnote = Integer.parseInt(s);
        }
        course_name=STD_Course_LIST.getSelectionModel().getSelectedItem();
        msg.setCourseName(STD_Course_LIST.getSelectionModel().getSelectedItem());
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
        if (event.getMessage().getMessage().equals("i will give you students id")) {
            int c = 0;
            int h = 0;
            List<CourseReg> coursesRegList = event.getMessage().getCourses_list_from_server_reg();
            List<Exams> examsList = event.getMessage().getExams_list_from_server();
            List<ExamsScan> examsScanList = event.getMessage().getExamsScans_list_from_server();


            for (int i = 0; i < coursesRegList.size(); i++) {
                if (coursesRegList.get(i).getType().equals("Teacher") && coursesRegList.get(i).getLecturer().getId() == event.getMessage().getId()) {
                    for (int j = 0; j < examsList.size(); j++) {
                        if (coursesRegList.get(i).getName().equals(examsList.get(j).getCourse_name())) {
                            for (int z = 0; z < STD_Course_LIST.getItems().size(); z++) {
                                if (STD_Course_LIST.getItems().get(z).equals(coursesRegList.get(i).getName())) {
                                    h = 1;
                                    break;
                                }
                            }
                            if (h == 0)
                                STD_Course_LIST.getItems().add(coursesRegList.get(i).getName());

                        }
                    }
                }
            }


        } else if (event.getMessage().getMessage().equals("i will give you students id2")) {

            String s = STD_Course_LIST.getSelectionModel().getSelectedItem();
            List<ExamsScan> examsScanList = event.getMessage().getExamsScans_list_from_server();
            List<Document> documentList = event.getMessage().getDocuments_list_from_server();
            List<Course>courseList=event.getMessage().getCourses_list_from_server();
            if(courseList!=null)
                for(int i=0;i<courseList.size();i++){
                    if(courseList.get(i).getName().equals(STD_Course_LIST.getSelectionModel().getSelectedItem())) {
                        course_id_to_word = courseList.get(i).getId();
                    }
                }

            for (int x = 0; x < examsScanList.size(); x++) {
                if (examsScanList.get(x).getName().equals(s)) {
                    if (!isExitst(examsScanList, examsScanList.get(x).getStudent_ID()))
                        STD_ID_LIST.getItems().add(String.valueOf(examsScanList.get(x).getStudent_ID()));


                }


            }
            for (int i = 0; i < documentList.size(); i++) {
                if (documentList.get(i).getCourse_name().equals(event.getMessage().getCourseName())) {
                    if (!isExitstdoc(documentList, Integer.parseInt(documentList.get(i).getId_student()))){
                        student_word.getItems().add(String.valueOf(documentList.get(i).getId_student()));

                }
                }
            }

        }
        else if (event.getMessage().getMessage().equals("i will give you word scan")) {
            List<Document> documentList = event.getMessage().getDocuments_list_from_server();
            String s1 = "";

            for (int i = 0; i < documentList.size(); i++) {
                if (documentList.get(i).getCourse_name().equals(event.getMessage().getCourseName())&&documentList.get(i).getId_student().equals(String.valueOf(event.getMessage().getStudentId()))) {
                    s1 = documentList.get(i).getData();
                    break;
                }
            }
            word_scan.setText(s1);



        }

}




    public boolean isExitst(List<ExamsScan> l , int id){
        for(int i =0 ; i<STD_ID_LIST.getItems().size();i++){
            if(STD_ID_LIST.getItems().get(i).equals(String.valueOf(id))){
                return true;
            }
        }
        return false;
        }
    public boolean isExitstdoc(List<Document> l , int id){
        for(int i =0 ; i<student_word.getItems().size();i++){
            if(student_word.getItems().get(i).equals(String.valueOf(id))){
                return true;
            }
        }
        return false;
    }


    @FXML
    void initialize() {
        int msgId=0;
        word_scan.setVisible(false);
       // student_scan_label.setVisible(false);
        word_scan_label.setVisible(false);
        insert_grade_but.setVisible(false);
        insert_grade_field.setVisible(false);
        insert_grade_label.setVisible(false);
        EventBus.getDefault().register(this);

        Message msg=new Message("give me students id");
        msg.setId(SimpleClient.ID);
        msg.setType(SimpleClient.Type);
        sendMessage(msg);




    }

}
