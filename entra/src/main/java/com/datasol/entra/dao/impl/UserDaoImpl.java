package com.datasol.entra.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datasol.entra.dao.UserDao;
import com.datasol.entra.domain.User;
import com.datasol.entra.exception.DaoException;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	@Override
	public User getUserByEmail(String email) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("getting the user "+email);
		return (User)session.createQuery("from User  where email=:email").setParameter("email", email).uniqueResult();
	}

	@Override
	public void saveUser(User user) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("registering new user "+user.getEmail());
		session.saveOrUpdate(user);

	}

	@Override
	public void deleteUser(User user) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);

	}

}
