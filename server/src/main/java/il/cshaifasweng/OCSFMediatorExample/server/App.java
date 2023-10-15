package il.cshaifasweng.OCSFMediatorExample.server;

import il.cshaifasweng.OCSFMediatorExample.entities.entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class App {

    public static Session session;
    public static SessionFactory sessionFactory = getSessionFactory();

    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();

        // Add ALL of your entities here. You can also try adding a whole package.
        configuration.addAnnotatedClass(Exams.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Grade.class);
        configuration.addAnnotatedClass(Lecturer.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Questions.class);
        configuration.addAnnotatedClass(ExamsScan.class);

        configuration.addAnnotatedClass(CourseReg.class);
        configuration.addAnnotatedClass(Mediator.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void generateCourses() throws Exception {

        Course course0 = new Course("Math");
        session.save(course0);
        session.flush();
        Course course1 = new Course("English");
        session.save(course1);
        session.flush();
        Course course2 = new Course("Arabic");
        session.save(course2);
        session.flush();
        Course course3 = new Course("Hebrew");
        session.save(course3);
        session.flush();
        Course course4 = new Course("Music");
        session.save(course4);
        session.flush();
        Course course5 = new Course("Data Structure");
        session.save(course5);
        session.flush();
        Course course6 = new Course("Algorithmes");
        session.save(course6);
        session.flush();
        Course course7 = new Course("Object Oriented Programming");
        session.save(course7);
        session.flush();
        Course course8 = new Course("Assemble");
        session.save(course8);
        session.flush();
        Course course9 = new Course("Sport");
        session.save(course9);
        session.flush();
    }

// ...

    private static <T> List<T> getAll(Class<T> object) {


        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = builder.createQuery(object);
        Root<T> rootEntry = criteriaQuery.from(object);
        CriteriaQuery<T> allCriteriaQuery = criteriaQuery.select(rootEntry);
        TypedQuery<T> allQuery = session.createQuery(allCriteriaQuery);
        return allQuery.getResultList();
    }




    public static List<Student> getAllStudents() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        query.from(Student.class);
        List<Student> data = session.createQuery(query).getResultList();
        return data;
    }


    public static void generateQuestion(Questions questions){
        session.save(questions);
        session.flush();
    }

    public static void generateQuestions(){
        Questions ques = new Questions("test", "1", "2", "3", "4", "2");
        session.save(ques);
        session.flush();
    }


    public static void updateExamStat(int examId, boolean newStat) throws Exception {

        List<Exams> exams = getAllExams();
        try {


            // Find the corresponding Exam entity
            Exams exam = null;
            for (Exams e : exams) {
                if (e.getId() == examId) {
                    exam = e;
                    break;
                }
            }

            if (exam == null) {
                throw new Exception("No exam found with the specified ID.");
            }

            // Update the stat
            exam.setStat(newStat);

            // Save the updated exam object
            session.update(exam);
            session.getTransaction().commit(); // Save everything..commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }


    public static void updateExam(Exams updatedExam) throws Exception {

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            List<Exams> exams = getAllExams();

            Exams exam = null;
            for (Exams e : exams) {
                if (e.getId() == updatedExam.getId()) {
                    exam = e;
                    break;
                }
            }

            if (exam == null) {
                throw new Exception("No exam found with the specified ID.");
            }

            // Update exam properties
            exam.setId(updatedExam.getId());
            exam.setQues_number(updatedExam.getQues_number());
            exam.setCourse_name(updatedExam.getCourse_name());
            exam.setStat(updatedExam.getStat());

            session.update(exam);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            throw e; // Rethrow the exception for higher-level error handling
        }
    }


    public static List<Grade> getGradesByStudentId(int studentId) throws Exception{


        boolean found=false;

        List<Student> students = getAll(Student.class);
        for(int i =0;i<students.size() && !found ;i++)
        {
            if(students.get(i).getStudent_id()==studentId) {
                found=true;
            }
        }
        if(found)
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
            Root<Grade> gradeRoot = query.from(Grade.class);
            Join<Grade, Student> studentJoin = gradeRoot.join("student");
            query.select(gradeRoot).where(builder.equal(studentJoin.get("student_id"), studentId));
            List<Grade> grades = session.createQuery(query).getResultList();
            return grades;
        }
        return null;


    }
    public static void  changeGrade(int studentId, int courseId, int newGrade) throws Exception {



        List<Grade> student_grades = getGradesByStudentId(studentId);
        try {

            // Find the corresponding Grade entity
            Grade grade = null;
            for (Grade g : student_grades) {
                if (g.getCourseid() == courseId) {
                    grade = g;
                    break;
                }
            }

            if (grade == null) {
                throw new Exception("No grade found for the specified student and course.");
            }


            // Update the grade
            grade.setGrade(String.valueOf(newGrade));
            session.update(grade);

            session.getTransaction().commit(); // Save everything..commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static List<Exams> getAllExams() throws Exception {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Exams> query = builder.createQuery(Exams.class);
        query.from(Exams.class);
        List<Exams> exams = session.createQuery(query).getResultList();
        return exams;
    }
    public static void generateExam(Exams exam){

        session.save(exam);
        session.flush();
    }
    public static void generateExams(){
        Exams exam = new Exams(1);
        session.save(exam);
        session.flush();
    }
    public static List<Course> getAllCourses() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        query.from(Course.class);
        List<Course> COURSES = session.createQuery(query).getResultList();
        return COURSES;
    }
public static void generate(){
        Lecturer lec = new Lecturer(7,"Rai","Massalha","7");
        session.save(lec);
        session.flush();
        List<Course> c = getAllCourses();
        for(int i=0;i<7;i++){
            CourseReg r =new CourseReg(lec,c.get(i).getName(),"Teacher");
            session.save(r);
            session.flush();
        }


}



    public static void main(String[] args) {

        try {
            try {
                session = sessionFactory.openSession();
                session.beginTransaction();
            }catch (HibernateException e){
                e.printStackTrace();
            }
            generateQuestions();
            generateCourses();
            generateExams();
            generate();

            session.getTransaction().commit(); // Save everything.

        } catch (Exception exception) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.err.println("An error occured, changes have been rolled back.");
            exception.printStackTrace();
        } finally {
            assert session!=null;
            session.close();
        }

    }
}