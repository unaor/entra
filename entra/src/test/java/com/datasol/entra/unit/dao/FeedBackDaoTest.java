package com.datasol.entra.unit.dao;

import java.util.Date;
import java.util.List;

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
		User user1 = new User("first", "second", "one@two.com");
		User user2 = new User("third", "fourth", "two@two.com");
		User user3 = new User("fifth", "sixth", "three@two.com");
		userDao.saveUser(user1);
		userDao.saveUser(user2);
		userDao.saveUser(user3);
		Client client = new Client(user1);
		client.setAffiliationDate(new Date());
		client.setBusinessName("new business");
		client.setStreetAddress("cra 7c");
		client.setCity("medellin");
		client.setProvince("antioquiya");
		client.setBusinessPhoneNumber("456765");
		client.setBusinessEmail("business@yahoo.com");
		client.setAllowedCoupons(2);
		clientDao.saveClient(client);
	}
	
	@Test
	public void createAndCountFeedbacks() throws DaoException{
		Client client  = clientDao.getClientByEmail("one@two.com");
		User user1 = userDao.getUserByEmail("two@two.com");
		FeedBack fb1 = new FeedBack();
		fb1.setReceiverOfFBClient(client);
		fb1.setFeedBackText("good service");
		fb1.setAuthorOfFBUser(user1);
		fb1.setStarRating(4);
		feedbackDao.createFeedback(fb1);
		//fb1=null;
		FeedBack dbFB = (FeedBack)feedbackDao.getClientFeedBacks(client.getClientId()).get(0);
		//FeedBack dbFB = (FeedBack)feedbackDao.getFeedbacksByUser(user1.getUserId()).get(0);
		assertEquals(user1.getUserId(), dbFB.getAuthorOfFBUser().getUserId());
		assertEquals("good service", dbFB.getFeedBackText());
	}
	
	@Test
	public void userCantAddTwiceFBForSameBusiness() throws DaoException{
		Client client  = clientDao.getClientByEmail("uri@naor.com");
		User user1 = userDao.getUserByEmail("one@two.com");
		FeedBack fb1 = new FeedBack();
		fb1.setReceiverOfFBClient(client);
		fb1.setFeedBackText("good service");
		//fb1.setUser(user1);
		fb1.setStarRating(4);
		feedbackDao.createFeedback(fb1);
		FeedBack fb2 = new FeedBack();
		fb2.setReceiverOfFBClient(client);
		//fb2.setUser(user1);
		fb2.setFeedBackText("bad service");
		fb2.setStarRating(1);
		feedbackDao.createFeedback(fb2);
		fb1=null;
		fb2=null;
		List<FeedBack> fbs = feedbackDao.getClientFeedBacks(client.getClientId());
		assertEquals(2, fbs.size());
	}
	
	@After
	public void cleanUp() throws DaoException{
		List<FeedBack> feedbacks = feedbackDao.getAllFeedbacks();
		for (FeedBack fb  : feedbacks){
			feedbackDao.deleteFB(fb);
		}
	}

}
