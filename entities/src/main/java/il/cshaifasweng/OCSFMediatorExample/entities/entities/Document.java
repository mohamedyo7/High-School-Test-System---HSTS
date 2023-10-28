package il.cshaifasweng.OCSFMediatorExample.entities.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "documents")
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id= 1000L;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    String data;
    private String id_exam;
    private String id_student;
    private String path;


    public String getId_exam() {
        return id_exam;
    }

    public void setId_exam(String id_exam) {
        this.id_exam = id_exam;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDocinsidetext() {
        return docinsidetext;
    }

    public void setDocinsidetext(String docinsidetext) {
        this.docinsidetext = docinsidetext;
    }

    private String docinsidetext;

    public String getCourse_name() {
        return Course_name;
    }

    public void setCourse_name(String course_name) {
        Course_name = course_name;
    }

    private String Course_name;

    public Document(){}

public Document(String id_exam,String id_student,String path,String docinsidetext,String course_name){

        setId_exam(id_exam);
        setId_student(id_student);
        setPath(path);
        setDocinsidetext(docinsidetext);
        setCourse_name(course_name);


}
public Document(Document doc){

        this.id_exam=doc.id_exam;
        this.id_student=doc.id_student;
        this.path=doc.path;
        this.docinsidetext=doc.docinsidetext;
        this.Course_name=doc.Course_name;
}


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
