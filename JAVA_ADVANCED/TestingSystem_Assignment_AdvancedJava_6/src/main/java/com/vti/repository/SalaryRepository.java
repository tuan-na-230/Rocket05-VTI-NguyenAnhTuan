package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.utils.HibernateUtils;

public class SalaryRepository {

	private HibernateUtils hibernateUtils;

	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalarys() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createSalary(Salary Salary) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Salary);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Salary getSalaryByName(SalaryName name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Salary salary = query.uniqueResult();

			return salary;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public boolean isSalaryExistsByName(SalaryName name) {
		Salary salary = getSalaryByName(name);

		if (salary == null) {
			return false;
		}
		return true;
	}
}
