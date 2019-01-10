package com.renevoi.studentDemoUsingCFG;

import com.renevoi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args){

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
            Student studentRene1 = new Student("Renevoi1", "James", "renevoi1.catapang@renevoi");
            Student studentRene2 = new Student("Renevoi2", "Davis", "renevoi2.catapang@renevoi");
            Student studentRene3 = new Student("Renevoi3", "Clark", "renevoi3.catapang@rene");

            // start a Transaction
            session.beginTransaction();
            // save the Student Object
            session.save(studentRene1);
            session.save(studentRene2);
            session.save(studentRene3);
            // commit transaction
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }


}
