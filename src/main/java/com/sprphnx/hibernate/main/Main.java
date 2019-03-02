package com.sprphnx.hibernate.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sprphnx.hibernate.entities.Departments;

public class Main {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Departments.class).buildSessionFactory();

		// Create Session
		Session session = sessionFactory.getCurrentSession();

		try {
			//createDepartment(session);
			//readDepartment(session);
			//readAllDepartments(session);
			//readSpecificDepartments(session);
			//updateDepartment(session);
			session.beginTransaction();
			session.createQuery("update Departments d set d.departmentName ='IT'").executeUpdate();
			session.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}

	}

	private static void updateDepartment(Session session) {
		session.beginTransaction();
		Departments department = session.get(Departments.class, 280L);
		System.out.println("***************"+department.getDepartmentName());
		department.setDepartmentName("IT department");
		session.getTransaction().commit();//explicit save of the object is not required as the object is in persitant state.
		System.out.println("***************"+department.getDepartmentName());
	}

	private static void readSpecificDepartments(Session session) {
		session.beginTransaction();
		List<Departments> departments = session.createQuery("from Departments d where d.departmentName like 'IT%'").getResultList();
		System.out.println("_______________________________________");
		departments.forEach((department)->System.out.println(department.getDepartmentName()));
		System.out.println("_______________________________________");
		session.getTransaction().commit();
	}

	private static void readAllDepartments(Session session) {
		session.beginTransaction();
		List<Departments> departments = session.createQuery("from Departments").getResultList();
		departments.forEach((department)->System.out.println(department.getDepartmentName()));
	}

	private static void readDepartment(Session session) {
		session.beginTransaction();
		Departments departments = session.get(Departments.class, 280L);
		System.out.println("*******************************");
		System.out.println(departments.getDepartmentName());
		System.out.println("*******************************");
	}

	private static void createDepartment(Session session) {
		// Create the object
		Departments informationTechnology = new Departments(280L, "Information Technology", 205L, 1700L);

		// Start the transaction
		session.beginTransaction();

		// Save the new department
		session.save(informationTechnology);

		// Commit the transaction
		session.getTransaction().commit();
	}

}
