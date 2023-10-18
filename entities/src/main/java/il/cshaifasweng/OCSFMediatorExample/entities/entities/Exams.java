package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "Exams")
public class Exams implements Serializable {


    @Id
    @Column (name = "exam_id")
    private int id;
    @Column(name = "ques_number")
    private int ques_number;
    private boolean stat ;
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

    public Exams(int id) {
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
        this.id=1;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}