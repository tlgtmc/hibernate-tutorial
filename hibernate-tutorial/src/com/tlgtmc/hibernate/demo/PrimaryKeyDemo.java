package com.tlgtmc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			Student myStudent1 = new Student("Paul", "Walker", "paulAlbert@gmail.com");
			Student myStudent2 = new Student("John", "Walker", "johnAlbert@gmail.com");
			Student myStudent3 = new Student("Kurt", "Walker", "kurtAlbert@gmail.com");

			session.beginTransaction();
			session.save(myStudent1);
			session.save(myStudent2);
			session.save(myStudent3);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
