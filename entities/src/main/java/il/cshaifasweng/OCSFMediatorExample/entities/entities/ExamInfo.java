package il.cshaifasweng.OCSFMediatorExample.entities.entities;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ExamInfo")
public class ExamInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String exam_id;
    private Date executionDateTime;
    private double actualDuration=0;
    private int numberOfStartedStudents=0;
    private int numberOfCompletedStudents=0;
    private int numberOfFailedStudents=0;
    private int studentid;

    private String courseid;

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String  courseid) {
        this.courseid = courseid;
    }

    // Constructors
    public ExamInfo(Date executionDateTime, int actualDuration, int numberOfStartedStudents, int numberOfCompletedStudents, int numberOfFailedStudents) {
        this.executionDateTime = executionDateTime;
        this.actualDuration = actualDuration;
        this.numberOfStartedStudents = numberOfStartedStudents;
        this.numberOfCompletedStudents = numberOfCompletedStudents;
        this.numberOfFailedStudents = numberOfFailedStudents;
    }

    public ExamInfo() {

    }

    // Getters and Setters
    public Date getExecutionDateTime() {
        return executionDateTime;
    }

    public void setExecutionDateTime(Date executionDateTime) {
        this.executionDateTime = executionDateTime;
    }

    public double getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(double actualDuration) {
        this.actualDuration = actualDuration;
    }

    public int getNumberOfStartedStudents() {
        return numberOfStartedStudents;
    }

    public void setNumberOfStartedStudents(int numberOfStartedStudents) {
        this.numberOfStartedStudents = numberOfStartedStudents;
    }

    public int getNumberOfCompletedStudents() {
        return numberOfCompletedStudents;
    }

    public void setNumberOfCompletedStudents(int numberOfCompletedStudents) {
        this.numberOfCompletedStudents = numberOfCompletedStudents;
    }

    public int getNumberOfFailedStudents() {
        return numberOfFailedStudents;
    }

    public void setNumberOfFailedStudents(int numberOfFailedStudents) {
        this.numberOfFailedStudents = numberOfFailedStudents;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public String  getexamId() {
        return exam_id;
    }

public void setexamId(String id) {
        this.exam_id = id;}
}