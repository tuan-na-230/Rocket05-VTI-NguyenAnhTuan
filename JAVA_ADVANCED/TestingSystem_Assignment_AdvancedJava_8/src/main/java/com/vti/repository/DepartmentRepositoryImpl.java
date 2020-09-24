package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.utils.HibernateUtils;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@Component("DepartmentRepositoryImpl")
public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Autowired
	private HibernateUtils hibernateUtils;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDTO> getAllDepartments() {

		Session session = null;
		List<DepartmentDTO> lists = new ArrayList<DepartmentDTO>();
		
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(Department.class);
			cr.addOrder(Order.asc("id"));
			
			List<Department> results = cr.list();
			for(int i=0; i<results.size(); i++) {
				lists.add(new DepartmentDTO(results.get(i).getId(), results.get(i).getTotalMember(), results.get(i).getName()));
			}
			
			return lists;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<DepartmentDTO> getAllDepartments(Paging paging, @RequestParam(name = "search") String search, FilterDepartment filter, Sorting sorting) {

		Session session = null;
		List<DepartmentDTO> lists = new ArrayList<DepartmentDTO>();
		
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(Department.class);
			
			if(!StringUtils.isEmpty(search)) {
				
				try {
			        Short numSearch = Short.parseShort(search);
			        
			        //Search ID
			        cr.add(Restrictions.eq("id", numSearch.shortValue()));
			    } catch(NumberFormatException e ) {
			    	
			    	//Search NAME
			    	cr.add(Restrictions.ilike("name", "%" + search + "%"));
			    }
			}
			
			// filter
			// min Member
			if(null != filter.getMinMember()) {
				cr.add(Restrictions.ge("totalMember", filter.getMinMember().shortValue()));
			}
			
			// max Member
			if(null != filter.getMaxMember()) {
				cr.add(Restrictions.le("totalMember", filter.getMaxMember().shortValue()));
			}

			// sorting
			if("id".equals(sorting.getField()) || "totalMember".equals(sorting.getField()) || "name".equals(sorting.getField()))
			cr.addOrder(
					"desc".equals(sorting.getType().toLowerCase()) ? 
							Order.desc(sorting.getField()):
							Order.asc(sorting.getField()));
			else
				cr.addOrder(Order.asc("id"));

			// paging
			cr.setFirstResult((paging.getPage() - 1) * paging.getSize());
			cr.setMaxResults(paging.getSize());
			
			List<Department> results = cr.list();
			for(int i=0; i<results.size(); i++) {
				lists.add(new DepartmentDTO(results.get(i).getId(), results.get(i).getTotalMember(), results.get(i).getName()));
			}
			
			return lists;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings({ "deprecation" })
	public long getTotalCount(String search, String filter) {
		
		Session session = null;
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(Department.class);
			if(search != null) {
				cr.add(Restrictions.ilike("name", "%"+search+"%"));
			}
			else {
				if(filter != null) {
					cr.add(Restrictions.eq("name", filter));
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

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

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
