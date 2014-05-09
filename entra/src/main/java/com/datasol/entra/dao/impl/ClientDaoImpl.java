package com.datasol.entra.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datasol.entra.dao.ClientDao;
import com.datasol.entra.domain.Client;
import com.datasol.entra.exception.DaoException;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public List<Client> getClients() throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Client").list();
	}

	@Override
	public Client getClientByEmail(String email) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("getting client by email: "+email);
		return (Client) session
				.createQuery("from Client c where c.user.email=:email")
				.setParameter("email", email).uniqueResult();
	}

	@Override
	public void saveClient(Client client) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("new client has joined "+client.getUser().getEmail());
		session.saveOrUpdate(client);

	}

	@Override
	public void deleteClient(Client client) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(client);
	}

}
