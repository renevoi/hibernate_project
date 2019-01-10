package com.renevoi.studentDemoUsingCFG;

import com.renevoi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args){

        // Create Session Factory
        SessionFactory sessionFactory = new Configuration()
                                        .configure()
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            // start transaction
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student").list();

            // display the students
            displayStudents(students);
            System.out.println("\n");
           // query students whose last name is James and Davis
            List<Student> lastNameJamesDavis = session.createQuery("from Student s where s.lastName" +
                                                                                 "='James' or s.lastName='Davis'").list();
            System.out.println("\n");
            // display the students
            System.out.println("Students who have last name of James and Davis");
            displayStudents(lastNameJamesDavis);

            // query students that has @renevoi email
            List<Student> emailStudent = session.createQuery("from Student s where s.email LIKE '%@renevoi'").list();
            System.out.println("\n");

            // display students have renevoi email
            System.out.println("Students have email address of renevoi");
            displayStudents(emailStudent);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }


    }

    private static void displayStudents(List<Student> students) {
            students.forEach(student-> System.out.println(student));
    }



}
