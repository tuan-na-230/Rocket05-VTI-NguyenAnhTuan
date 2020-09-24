package com.vti.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<AccountDTO> getAllAccounts(int pageNumber, int pageSize, String nameSearch, Position filter) {

		Session session = null;
		List<AccountDTO> lists = new ArrayList<AccountDTO>();
		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Criteria cr = session.createCriteria(Account.class);
			if(nameSearch != null && nameSearch.length() > 0) {
				if(filter != null) {
					cr.add(Restrictions.and(Restrictions.eq("username", nameSearch), Restrictions.eq("position", filter)));
				}
				else {
					cr.add(Restrictions.eq("username", nameSearch));
				}
			}
			else {
				if(filter != null) {
					cr.add( Restrictions.eq("position", filter));
				}
			}
			cr.addOrder(Order.asc("username"));
			cr.setFirstResult((pageNumber - 1) * pageSize);
			cr.setMaxResults(pageSize);
			
			List<Account> results = cr.list();
			for(int i=0; i<results.size(); i++) {
				lists.add(new AccountDTO(results.get(i).getEmail(), results.get(i).getUsername(), results.get(i).getFirstName(),
						results.get(i).getLastName(), results.get(i).getDepartment().getName(), results.get(i).getPosition().getName().getValue(),
						results.get(i).getSalary().getName().getValue(), results.get(i).getCreateDate()));
			}
			return lists;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account Account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Account);

			session.getTransaction().commit();
			System.out.println("Create account successful!");
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Account getAccountByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE id = :idParameter");

			// set parameter
			query.setParameter("idParameter", (short)id);

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByEmail(String email) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE email = :emailParameter");

			// set parameter
			query.setParameter("emailParameter", email);

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Account getAccountByUsername(String username) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE username = :usernameParameter");

			// set parameter
			query.setParameter("usernameParameter", username);

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(account);

			session.getTransaction().commit();
			System.out.println("Update is successfull!");
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void deleteAccount(short id) {
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			Query query = session.createSQLQuery("CALL DeleteAccount (:accountID)")
					  .setParameter("accountID", id);
			query.executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Delete account complete!");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByID(int id) {

		// get account
		Account account = getAccountByID(id);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}
	
	public boolean isAccountExistsByEmail(String email) {

		// get account
		Account account = getAccountByEmail(email);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}
	
	public boolean isAccountExistsByUsername(String username) {

		// get account
		Account account = getAccountByUsername(username);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}
}
