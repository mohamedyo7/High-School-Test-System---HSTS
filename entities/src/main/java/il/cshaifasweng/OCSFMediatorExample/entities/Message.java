package il.cshaifasweng.OCSFMediatorExample.entities;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.Course;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Grade;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Student;
import il.cshaifasweng.OCSFMediatorExample.entities.entities.Lecturer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


public class Message implements Serializable {
    private static final long serialVersionUID = -8224097662914849956L;
    int id;
    LocalDateTime timeStamp;
    String message;
    String data;
    int studentId;

    int course_id;

    int grade_to_change;

    private Object obj;
    public int getCourse_id()
    {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getGrade_to_change() {
        return grade_to_change;
    }

    public void setGrade_to_change(int grade_to_change) {
        this.grade_to_change = grade_to_change;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int number) {
        this.studentId = number;
    }

    public void setObject(Object obj1) {
        this.obj = obj1;
    }
    public Object getObject() {
        return this.obj;
    }
    public Message(String body){
        this.id=0;
        this.message=body;
        this.data = null;
        this.timeStamp = LocalDateTime.now();
    }
    public Message(int id, LocalDateTime timeStamp, String message) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.message = message;
    }

  /*  public Message(int id, String message) {
        this.id = id;
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.data = null;
    }*/

    public Message(int id, String message,String data) {
        this.id = id;
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}