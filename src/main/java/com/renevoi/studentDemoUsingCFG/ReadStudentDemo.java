package com.renevoi.studentDemoUsingCFG;

import com.renevoi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ReadStudentDemo {

    public static void main(String[] args){

        /*Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        configuration.configure("hibernate.cfg.xml");*/

        // Create Session Factory
        SessionFactory sessionFactory = new Configuration()
                                        .configure()
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        // Create Session
        Session session = sessionFactory.openSession();

        try {
            // use the session object to save the Java Object

            // create a Student Object
            Student studentRene = new Student("RenevoiGet", "Catapang", "renevoi.catapang@gmail");

            // start a Transaction
            session.beginTransaction();
            // save the Student Object
            session.save(studentRene);
            // commit transaction
            session.getTransaction().commit();

            Student student = session.get(Student.class, studentRene.getId());

            System.out.println(student);

            List<Student> students = session.createQuery("from Student").getResultList();

            for (Student studentAll :
                    students) {
                System.out.println(studentAll.getId());
            }

            List<Student> studentsLastName = session.createQuery("from Student s where s.lastName='Davis' " +
                    "                                           or s.email like 'renevoi1%'")
                                            .getResultList();

            for (Student student1:
                 studentsLastName) {
                System.out.println(student1);
            }
        }
        finally {
            sessionFactory.close();
        }

    }

}
