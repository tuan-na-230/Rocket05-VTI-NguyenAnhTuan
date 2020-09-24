package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize, String nameSearch, short filter) {

		Session session = null;
		List<DepartmentDTO> lists = new ArrayList<DepartmentDTO>();
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(DetailDepartment.class);
			if(nameSearch != null) {
				if(filter > 0) {
					cr.add(Restrictions.and(Restrictions.eq("name", nameSearch), Restrictions.gt("emulationPoint", filter)));
				}
				else {
					cr.add(Restrictions.eq("name", nameSearch));
				}
			}
			else {
				if(filter > 0) {
					cr.add( Restrictions.gt("emulationPoint", filter));
				}
			}
			cr.addOrder(Order.asc("name"));
			cr.setFirstResult(pageNumber);
			cr.setMaxResults(pageSize);
			
			List<DetailDepartment> results = cr.list();
			for(int i=0; i<results.size(); i++) {
				lists.add(new DepartmentDTO(results.get(i).getId(), results.get(i).getName(), results.get(i).getAddress().getName()));
			}
			
			return lists;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings({ "deprecation" })
	public long getTotalCount(String nameSearch, short filter) {
		
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(DetailDepartment.class);
			if(nameSearch != null) {
				if(filter > 0) {
					cr.add(Restrictions.and(Restrictions.eq("name", nameSearch), Restrictions.gt("emulationPoint", filter)));
				}
				else {
					cr.add(Restrictions.eq("name", nameSearch));
				}
			}
			else {
				if(filter > 0) {
					cr.add( Restrictions.gt("emulationPoint", filter));
				}
			}
			
			cr.setProjection(Projections.rowCount());
			Long count = (Long) cr.uniqueResult();
			
			return count;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public DepartmentDTO getDepartmentByID(short id, String nameSearch, short filter) {

		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			
			Criteria cr = session.createCriteria(DetailDepartment.class);
			
			if(nameSearch != null) {
				if(filter > 0) {
					cr.add(Restrictions.and(Restrictions.eq("name", nameSearch), Restrictions.gt("emulationPoint", filter)));
				}
				else {
					cr.add(Restrictions.eq("name", nameSearch));
				}
			}
			else {
				if(filter > 0) {
					cr.add( Restrictions.gt("emulationPoint", filter));
				}
			}
			cr.add(Restrictions.eq("id", id));
			
			// get department by id
			List<DetailDepartment> results = cr.list();
			DetailDepartment department = results.get(0);
			
			DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getName(), department.getAddress().getName());

			return departmentDTO;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Department getDepartmentByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public DepartmentDTO getDepartmenDTOtByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			DetailDepartment department = query.uniqueResult();
			DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getName(), department.getAddress().getName());

			return departmentDTO;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {

		Transaction transaction = null;
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			transaction = session.beginTransaction();

			// create
			session.save(department);

			transaction.commit();
			
		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(short id, String newName, short newEmulationPoint, String newAddress) {

		Transaction transaction = null;
		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			transaction = session.beginTransaction();

			// get department
			DetailDepartment detailDepartment = (DetailDepartment) session.load(DetailDepartment.class, id);

			// update
			detailDepartment.setName(newName);
			detailDepartment.setEmulationPoint(newEmulationPoint);
			detailDepartment.getAddress().setName(newAddress);
			
			transaction.commit();
			
		} catch (Exception e) {
			
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public void deleteDepartment(short id) {

		Transaction transaction = null;
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			transaction = session.beginTransaction();
			
			// get department
			Department department = (Department) session.load(Department.class, id);	
			Department departmentID;
			
			//create new department waiting
			Criteria cr1 = session.createCriteria(DetailDepartment.class);
			cr1.add(Restrictions.ilike("name", "waiting%"));
			cr1.setProjection(Projections.rowCount());
			
			List result = cr1.list();
			
			long count = (long) result.get(0);
			String newDepartmentname = "waiting" + (count + 1);
			createDepartment(new Department(newDepartmentname));
			departmentID = getDepartmentByName(newDepartmentname);
			
			//Update Account and Detaildepartment
			Criteria cr = session.createCriteria(Account.class);
			cr.add(Restrictions.eq("department", department));
			
			List<Account> accounts = cr.list();
			
			for (Account account : accounts) {
				account.setDepartment(departmentID);
			}
			
			Criteria cr2 = session.createCriteria(DetailDepartment.class);
			cr2.add(Restrictions.eq("id", id));
			
			List<DetailDepartment> detailDepartments = cr2.list();
			
			// delete
			session.delete(detailDepartments.get(0));
			session.delete(department);
			
			transaction.commit();
			System.out.println("Delete department completed!");

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(short id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
