package com.tlgtmc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 4);
			System.out.println("My Student Before Update: " + myStudent);

			session.delete(myStudent);
			System.out.println("My Student After Update: " + myStudent);

			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
