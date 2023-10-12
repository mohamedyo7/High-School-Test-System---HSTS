package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Exams")
public class Exams implements Serializable {


    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "exam_id")
    private int id;
    @Column(name = "ques_number")
    private int ques_number;
    private boolean stat ;


    private String name;

    public Exams(int id) {
        this.id = id;
        this.stat=false;
    }

/*
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Questions> questions = new ArrayList<>();
*/


    public void setStat(boolean stat) {
        this.stat = stat;
    }

    public boolean getStat() {
        return this.stat;
    }
    public Exams() {
        this.stat=false;
        this.id=1;
    }
/*    @ManyToOne
    @JoinColumn(name = "questions")
    private Questions ques;*/
    public void setQues_number(int ques_number) {
        this.ques_number = ques_number;
    }

    public int getQues_number() {
        return ques_number;
    }

    //private List<String> strques = new ArrayList<>();
    private String course_name;
/*    public void add_Ques(Questions ques){
        this.questions.add(ques);
    }
*//*
    public Questions getQues() {
        return ques;
    }
*//*

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }*/
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
