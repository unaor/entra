package com.datasol.entra.unit.dao;

import java.util.Date;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.datasol.entra.dao.ClientDao;
import com.datasol.entra.dao.UserDao;
import com.datasol.entra.domain.Client;
import com.datasol.entra.domain.User;
import com.datasol.entra.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class ClientTestDao {
	
	@Autowired
	ClientDao clientDao;
	@Autowired
	UserDao userDao;
	@Autowired
	SessionFactory sessionFactory;
	
	@Before
	public void insertUser() throws DaoException{
		User uri = new User();
		uri.setFirstName("uri");
		uri.setLastName("naor");
		uri.setEmail("uri@naor.com");
		userDao.saveUser(uri);
	}
	
	@Test
	public void createClient() throws DaoException{
		User uri = userDao.getUserByEmail("uri@naor.com");
		Client client = new Client();
		client.setUserId(uri.getUserId());
		client.setAffiliationDate(new Date());
		client.setBusinessName("new business");
		client.setCity("medellin");
		clientDao.saveClient(client);
		Client dbClient = clientDao.getClientByEmail("uri@naor.com");
		assertNotNull(dbClient);
		assertEquals("medellin", dbClient.getCity());
	}

}
