package com.hiber;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		// student pbject to set student instance
		Student s1 = new Student();
		s1.setId(101);
		s1.setName("wasim");
		// student pbject to set student instance
		Student s2 = new Student();
		s2.setId(102);
		s2.setName("salman");
		// course object to set course instance
		Course c1 = new Course();
		c1.setId(111);
		c1.setName("Math");
		// course object to set course instance
		Course c2 = new Course();
		c2.setId(112);
		c2.setName("Physics");
		// course object to set course instance
		Course c3 = new Course();
		c3.setId(113);
		c3.setName("Chemistery");
		Set<Course> courses = new HashSet<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		Set<Student> students = new HashSet<>();
		students.add(s1);
		students.add(s2);
		s2.setCourses(courses);
		c1.setStudents(students);
		try {
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();
			session.save(s1);
			session.save(s2);
			session.save(c1);
			session.save(c2);
			session.save(c3);
			t.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}
}
