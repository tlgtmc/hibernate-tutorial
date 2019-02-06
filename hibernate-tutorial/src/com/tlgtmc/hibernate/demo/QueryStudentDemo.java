package com.tlgtmc.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tlgtmc.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Student> studentList = session.createQuery("from Student").getResultList();

			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.firstName = 'Daffy'").getResultList();

			displayStudents(studentList);
			
			studentList = session.createQuery("from Student s where s.firstName = 'Daffy' or s.lastName='Albert'").getResultList();

			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();

			displayStudents(studentList);
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> studentList) {
		for (Student student : studentList) {
			System.out.println(student.getFirstName());
		}
	}

}
