package com.datasol.entra.dao.impl;

import java.util.List;

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

	@Override
	public List<Client> getClients() throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Client").list();
	}

	@Override
	public Client getClientByEmail(String email) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return (Client) session
				.createQuery("from Client  where user.email=:email")
				.setParameter("email", email).uniqueResult();
	}

	@Override
	public void saveClient(Client client) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(client);

	}

	@Override
	public void deleteClient(Client client) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(client);
	}

}
