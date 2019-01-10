package com.renevoi.studentDemoUsingCFG;

import com.renevoi.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args){

        SessionFactory sessionFactory = new Configuration()
                                        .configure()
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {

            session.beginTransaction();

            // update student using the id
            int studentId = 3;

            Student student = session.get(Student.class, studentId);

            System.out.println("Before Update");
            System.out.println(student.getFirstName());

            student.setFirstName("RenevoiUpdated");

            // display the updated row
            System.out.println("After Update");
            System.out.println(student.getFirstName());

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }

}
