package il.cshaifasweng.OCSFMediatorExample.entities;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;



public class Message implements Serializable {

    int id;
    double grade;

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    String ans;



    List<Object> object;
    LocalDateTime timeStamp;
    String message;
    String data;
    String test;
    int studentId;
    Exams exam;
    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public Exams getExam() {
        return exam;
    }

    public void setExam(Exams exam) {
        this.exam = exam;
    }

    int course_id;
    private Questions question ;
    private Lecturer lec;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    private String Type;

    public Lecturer getLec() {
        return lec;
    }

    public void setLec(Lecturer lec) {
        this.lec = lec;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private CourseReg course;
    private Student student;

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    private Mediator mediator;

    public CourseReg getCourse() {
        return course;
    }

    public void setCourse(CourseReg course) {
        this.course = course;
    }

    int grade_to_change;
    private List<Questions> questions_list_from_server;

    public List<Questions> getQuestions_list_from_server() {
        return questions_list_from_server;
    }

    public void setQuestions_list_from_server(List<Questions> questions_list_from_server) {
        this.questions_list_from_server = questions_list_from_server;
    }
    private List<Exams> exams_list_from_server;

    public List<Exams> getExams_list_from_server() {
        return exams_list_from_server;
    }

    public void setExams_list_from_server(List<Exams> exams_list_from_server) {
        this.exams_list_from_server = exams_list_from_server;
    }

    private List<Student> students_list_from_server;
    private List<Grade> grades_list_from_server;
    private List<Course> courses_list_from_server;
    private List<CourseReg> courses_list_from_server_reg;
    private List<ExamsScan>examsScans_list_from_server;

    public List<ExamsScan> getExamsScans_list_from_server() {
        return examsScans_list_from_server;
    }

    public void setExamsScans_list_from_server(List<ExamsScan> examsScans_list_from_server) {
        this.examsScans_list_from_server = examsScans_list_from_server;
    }

    public List<Mediator> getMediators_list_from_server() {
        return mediators_list_from_server;
    }

    public void setMediators_list_from_server(List<Mediator> mediators_list_from_server) {
        this.mediators_list_from_server = mediators_list_from_server;
    }

    private List<Mediator> mediators_list_from_server;

    public List<Lecturer> getLecturers_list_from_server() {
        return lecturers_list_from_server;
    }

    public void setLecturers_list_from_server(List<Lecturer> lecturers_list_from_server) {
        this.lecturers_list_from_server = lecturers_list_from_server;
    }

    private List<Lecturer> lecturers_list_from_server;


    public List<CourseReg> getCourses_list_from_server_reg() {
        return courses_list_from_server_reg;
    }

    public void setCourses_list_from_server_reg(List<CourseReg> courses_list_from_server_reg) {
        this.courses_list_from_server_reg = courses_list_from_server_reg;
    }




    private String courseName;
    private String Login_name;

    public String getLogin_name() {
        return Login_name;
    }

    public void setLogin_name(String login_name) {
        Login_name = login_name;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String First_name;
    private String Last_name;
    private String password;
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }


    public int getCourse_id()
    {
        return course_id;
    }
    public void setObject(List<Object> object) {
        this.object = object;
    }

    public List<Object> getObject() {
        return object;
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

    public Message(String message, List<Student> students, List<Grade> grades) {
        this.students_list_from_server=students;
        this.grades_list_from_server=grades;
        this.message = message;
    }

    public List<Grade> getGrades_list_from_server() {
        return grades_list_from_server;
    }

    public List<Student> getStudents_list_from_server() {

        return this.students_list_from_server;

    }
    public List<Course> getCourses_list_from_server() {

        return this.courses_list_from_server;

    }
    public void setGrades_list_from_server(List<Grade> grades_list_from_server) {

        this.grades_list_from_server = grades_list_from_server;
    }

    public void setStudents_list_from_server(List<Student> students_list_from_server) {
        this.students_list_from_server=students_list_from_server;

    }
    public void setCourses_list_from_server(List<Course> courses_list_from_server){
        this.courses_list_from_server = courses_list_from_server ;
    }
    public Message(int id, LocalDateTime timeStamp, String message) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.message = message;
    }


    public Message(int id, String message) {
        this.id = id;
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.data = null;
    }
    public Message(String message){
        this.id=0;
        this.message=message;
        this.timeStamp = LocalDateTime.now();
        this.data = null;
    }

    public Message(int id, String message,String data) {
        this.id = id;
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.data = data;
    }
    public Message(int id, String s1, String message,String s2) {
        this.id = id;
        this.message = s1;
        this.data = message;
        this.test=s2;
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