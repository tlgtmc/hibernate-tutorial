package com.tlgtmc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			Student myStudent = new Student("Daffy", "Duck", "duffyDuck@gmail.com");

			session.beginTransaction();
			session.save(myStudent);
			session.getTransaction().commit();
			
			System.out.println("Saved Student ID: " + myStudent.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myNewStudent = session.get(Student.class, myStudent.getId());
			
			System.out.println("My Student: " + myNewStudent);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
