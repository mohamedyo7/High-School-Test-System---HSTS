package il.cshaifasweng.OCSFMediatorExample.client;

import il.cshaifasweng.OCSFMediatorExample.entities.Message;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.CourseReg;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Document;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Exams;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.ExamsScan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
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

    @FXML
    void Back_but(ActionEvent event) throws IOException {
     SimpleChatClient.setRoot("TeacherPage");

    }
    @FXML
    private ListView<String> STD_Course_LIST;

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
        Message msg=new Message("give me word scan");
        msg.setStudentId(Integer.parseInt(student_word.getSelectionModel().getSelectedItem()));
        msg.setCourseName(STD_Course_LIST.getSelectionModel().getSelectedItem());
        sendMessage(msg);



    }

    @FXML
    void STD_ID_LIST_PRESS(MouseEvent event) throws IOException {
        SimpleChatClient.setRoot("ScanPage");
        Message msg=new Message("give me exams scans");
        String s=STD_ID_LIST.getSelectionModel().getSelectedItem();
        if(s!=null) {
            msg.setId(Integer.parseInt(s));
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
            System.out.println("hat tnshof 1");
            int c = 0;
            int h=0;
            String s = STD_Course_LIST.getSelectionModel().getSelectedItem();
            List<ExamsScan> examsScanList = event.getMessage().getExamsScans_list_from_server();
            List<Document> documentList = event.getMessage().getDocuments_list_from_server();

            for (int x = 0; x < examsScanList.size(); x++) {
                System.out.println("hat tnshof 2");
                if (examsScanList.get(x).getName().equals(s)) {
                    for (int y = 0; y < STD_ID_LIST.getItems().size(); y++) {
                        if (STD_ID_LIST.getItems().get(y).equals(String.valueOf(examsScanList.get(x).getStudent_ID()))) {
                            c = 1;
                            break;
                        }

                    }
                    if (c == 0)
                        STD_ID_LIST.getItems().add(String.valueOf(examsScanList.get(x).getStudent_ID()));
                }
            }
            System.out.println("hat tnshof 3");
            for (int x = 0; x < documentList.size(); x++) {
                System.out.println("hat tnshof 4");
                if (documentList.get(x).getCourse_name().equals(s)) {
                    System.out.println("hat tnshof 5");
                    for (int y = 0; y < student_word.getItems().size(); y++) {
                        System.out.println("hat tnshof 6");
                        if (student_word.getItems().get(y).equals(String.valueOf(documentList.get(x).getId_student()))) {
                            System.out.println("hat tnshof 7");
                            h = 1;
                            break;
                        }

                    }
                    if (h == 0)
                        student_word.getItems().add(String.valueOf(documentList.get(x).getId_student()));
                }
            }


        } else if (event.getMessage().getMessage().equals("i will give you word scan")) {
            System.out.println("haa 1");

            List<Document>documentList=event.getMessage().getDocuments_list_from_server();
            String s = "";
            System.out.println("haa 2");
            for(int i=0;i<documentList.size();i++){
                if(documentList.get(i).getId_student().equals(String.valueOf(event.getMessage().getStudentId()))&&documentList.get(i).getCourse_name().equals(event.getMessage().getCourseName())){
                    s=documentList.get(i).getPath();
                    System.out.println("haa 3");
                }
            }
            try {
                FileInputStream fis = new FileInputStream(s);
                XWPFDocument document = new XWPFDocument(fis);

                for (XWPFParagraph paragraph : document.getParagraphs()) {
                    System.out.println("haa 4");
                    String text = paragraph.getText();
                    word_scan.setText(text);
                    System.out.println(text);

                }

                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void initialize() {
        int msgId=0;
        word_scan.setVisible(false);
        EventBus.getDefault().register(this);

        Message msg=new Message("give me students id");
        msg.setId(SimpleClient.ID);
        msg.setType(SimpleClient.Type);
        sendMessage(msg);




    }

}
