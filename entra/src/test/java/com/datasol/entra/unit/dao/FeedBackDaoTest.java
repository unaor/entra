package com.datasol.entra.unit.dao;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.datasol.entra.dao.ClientDao;
import com.datasol.entra.dao.FeedBackDao;
import com.datasol.entra.dao.UserDao;
import com.datasol.entra.domain.Client;
import com.datasol.entra.domain.FeedBack;
import com.datasol.entra.domain.User;
import com.datasol.entra.exception.DaoException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class FeedBackDaoTest {
	
	@Autowired
	ClientDao clientDao;
	@Autowired
	UserDao userDao;
	@Autowired
	FeedBackDao feedbackDao;
	
	@Before
	public void setUp() throws DaoException{
		Client client = new Client();
		client.setFirstName("uri");
		client.setLastName("naor");
		client.setEmail("uri@naor.com");
		client.setAffiliationDate(new Date());
		client.setBusinessName("new business");
		client.setStreetAddress("cra 7c");
		client.setCity("medellin");
		client.setProvince("antioquiya");
		client.setBusinessPhoneNumber("456765");
		client.setBusinessEmail("business@yahoo.com");
		clientDao.saveClient(client);
		User user1 = new User("first", "second", "one@two.com");
		User user2 = new User("third", "fourth", "two@two.com");
		User user3 = new User("fifth", "sixth", "three@two.com");
		userDao.saveUser(user1);
		userDao.saveUser(user2);
		userDao.saveUser(user3);
	}
	
	@Test
	public void createAndCountFeedbacks() throws DaoException{
		Client client  = clientDao.getClientByEmail("uri@naor.com");
		User user1 = userDao.getUserByEmail("one@two.com");
		FeedBack fb1 = new FeedBack();
		fb1.setClient(client);
		fb1.setFeedBackText("good service");
		//fb1.setUser(user1);
		fb1.setStarRating(4);
		feedbackDao.createFeedback(fb1);
	}
	
	@Test
	public void userCantAddTwiceFBForSameBusiness() throws DaoException{
		Client client  = clientDao.getClientByEmail("uri@naor.com");
		User user1 = userDao.getUserByEmail("one@two.com");
		FeedBack fb1 = new FeedBack();
		fb1.setClient(client);
		fb1.setFeedBackText("good service");
		//fb1.setUser(user1);
		fb1.setStarRating(4);
		feedbackDao.createFeedback(fb1);
		FeedBack fb2 = new FeedBack();
		fb2.setClient(client);
		//fb2.setUser(user1);
		fb2.setFeedBackText("bad service");
		fb2.setStarRating(1);
		feedbackDao.createFeedback(fb2);
		fb1=null;
		fb2=null;
		List<FeedBack> fbs = feedbackDao.getClientFeedBacks(client.getUserId());
		assertEquals(2, fbs.size());
	}

}
