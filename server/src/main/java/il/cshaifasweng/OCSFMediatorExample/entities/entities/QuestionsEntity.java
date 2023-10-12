package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions", schema = "sys", catalog = "")
public class QuestionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ques_id")
    private int quesId;
    @Basic
    @Column(name = "Ans1")
    private String ans1;
    @Basic
    @Column(name = "Ans2")
    private String ans2;
    @Basic
    @Column(name = "Ans3")
    private String ans3;
    @Basic
    @Column(name = "Ans4")
    private String ans4;
    @Basic
    @Column(name = "correct_ans")
    private String correctAns;
    @Basic
    @Column(name = "course_name")
    private String courseName;
    @Basic
    @Column(name = "question")
    private String question;

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionsEntity that = (QuestionsEntity) o;

        if (quesId != that.quesId) return false;
        if (ans1 != null ? !ans1.equals(that.ans1) : that.ans1 != null) return false;
        if (ans2 != null ? !ans2.equals(that.ans2) : that.ans2 != null) return false;
        if (ans3 != null ? !ans3.equals(that.ans3) : that.ans3 != null) return false;
        if (ans4 != null ? !ans4.equals(that.ans4) : that.ans4 != null) return false;
        if (correctAns != null ? !correctAns.equals(that.correctAns) : that.correctAns != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quesId;
        result = 31 * result + (ans1 != null ? ans1.hashCode() : 0);
        result = 31 * result + (ans2 != null ? ans2.hashCode() : 0);
        result = 31 * result + (ans3 != null ? ans3.hashCode() : 0);
        result = 31 * result + (ans4 != null ? ans4.hashCode() : 0);
        result = 31 * result + (correctAns != null ? correctAns.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }
}
