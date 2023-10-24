package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Exams")
public class Exams implements Serializable {


    @Id
    @Column (name = "exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int intid;
    private String id;

    private String eid="";

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    @Column(name = "ques_number")
    private int ques_number;
    private boolean stat ;
    private String teacherID;
    private String teacherName;
private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean request;

    public boolean isStat() {
        return stat;
    }

    public boolean isRequest() {
        return request;
    }

    public void setRequest(boolean request) {
        this.request = request;
    }

    private double time;
    private String code;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    private String name;

    public Exams(String id) {
        this.id = id;
        this.stat=false;
        this.time=0.00001;
    }



    public void setStat(boolean stat) {
        this.stat = stat;
    }

    public boolean getStat() {
        return this.stat;
    }
    public Exams() {
        this.stat=false;
        this.id="-1";
        this.time=0.00001;
    }

    public void setQues_number(int ques_number) {
        this.ques_number = ques_number;
    }

    public int getQues_number() {
        return ques_number;
    }

    //private List<String> strques = new ArrayList<>();
    private String course_name;

    public String getCourse_name() {
        return course_name;
    }

/*    public void setQues(Questions ques) {
        this.ques = ques;
    }*/


    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}