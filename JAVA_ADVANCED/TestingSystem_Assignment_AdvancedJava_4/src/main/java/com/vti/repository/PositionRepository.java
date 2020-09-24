package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;

public class PositionRepository {

	private HibernateUtils hibernateUtils;

	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Position> getAllPositions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Position> query = session.createQuery("FROM Position");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Position getPositionByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get Position by id
			Position position = session.get(Position.class, id);

			return position;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Position getPositionByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Position> query = session.createQuery("FROM Position WHERE PositionName = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Position position = query.uniqueResult();

			return position;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createPosition(Position position) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(position);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isPositionExistsByID(short id) {

		// get Position
		Position position = getPositionByID(id);

		// return result
		if (position == null) {
			return false;
		}

		return true;
	}

	public boolean isPositionExistsByName(String name) {
		Position position = getPositionByName(name);

		if (position == null) {
			return false;
		}
		return true;
	}

}
