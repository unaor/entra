package com.datasol.entra.unit.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.After;
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
		Client client = new Client(uri);
		client.setAffiliationDate(new Date());
		client.setBusinessName("new business");
		client.setStreetAddress("cra 7c");
		client.setCity("medellin");
		client.setProvince("antioquiya");
		client.setBusinessPhoneNumber("456765");
		client.setBusinessEmail("business@yahoo.com");
		clientDao.saveClient(client);
		Client dbClient = clientDao.getClientByEmail("uri@naor.com");
		assertNotNull(dbClient);
		assertEquals("medellin", dbClient.getCity());
	}
	
	
	@After
	public void cleanUp() throws DaoException{
		Client client  =clientDao.getClients().get(0);
		clientDao.deleteClient(client);
		User user = userDao.getUsers().get(0);
		userDao.deleteUser(user);
	}

}
