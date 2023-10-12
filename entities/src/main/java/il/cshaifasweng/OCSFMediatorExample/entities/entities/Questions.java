package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Questions")
public class Questions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String ques_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @ManyToOne
    @JoinColumn(name = "exam")
    private Exams exam;

    @Column(name = "question")
    private String question;
    private String course_name;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


    //private String question;
    private String Ans1;
    private String Ans2;
    private String Ans3;
    private String Ans4;
    private String correct_ans;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns1() {
        return Ans1;
    }

    public void setAns1(String ans1) {
        Ans1 = ans1;
    }

    public void setAns2(String ans2) {
        Ans2 = ans2;
    }

    public void setAns3(String ans3) {
        Ans3 = ans3;
    }

    public void setAns4(String ans4) {
        Ans4 = ans4;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }

    public String getAns2() {
        return Ans2;
    }

    public String getAns3() {
        return Ans3;
    }

    public String getAns4() {
        return Ans4;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public Questions(String q , String a1,String a2 ,String a3,String a4,String cA) {
        this.question=q;
        this.Ans1=a1;
        this.Ans2=a2;
        this.Ans3=a3;
        this.Ans4=a4;
        this.correct_ans=cA;
        this.ques_id="empty";
    }
    public Questions() {
        this.question="empty";
        this.Ans1="empty";
        this.Ans2="empty";
        this.Ans3="empty";
        this.Ans4="empty";
        this.correct_ans="empty";
        this.ques_id="empty";
    }

    public void setQues_id(String quesId) {
        this.ques_id = quesId;
    }

    public String getQues_id() {
        return ques_id;
    }
}