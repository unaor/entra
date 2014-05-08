package com.datasol.entra.unit.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.datasol.entra.dao.UserDao;
import com.datasol.entra.domain.User;
import com.datasol.entra.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class UserDaoTest {
	
	private static Validator validator;
	
	@Autowired
	UserDao userDao;
	@Autowired
	SessionFactory sessionFactory;
	
	@BeforeClass
	public static void setUp(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	      validator = factory.getValidator();
	}
	
	@Before
	public void insertUser() throws DaoException{
		User uri = new User();
		uri.setFirstName("uri");
		uri.setLastName("naor");
		uri.setEmail("uri@naor.com");
		userDao.saveUser(uri);
		
	}
	
	@Test
	public void getUserByEmail() throws DaoException{
		User nullUser = userDao.getUserByEmail("hoho");
		assertNull(nullUser);
		User uri = userDao.getUserByEmail("uri@naor.com");
		assertEquals("uri", uri.getFirstName());
	}
	
	@Test/*(expected=ConstraintViolationException.class)*/
	public void testValidationsShortName() throws DaoException{
		User badUser = new User();
		badUser.setFirstName("a");
		badUser.setLastName("good last name");
		badUser.setEmail("good@email.com");
		/*Session session = sessionFactory.getCurrentSession();
		session.save(badUser);
		session.flush();	*/
		//userDao.saveUser(badUser);
		 Set<ConstraintViolation<User>> errors  = validator.validate(badUser);
		 assertEquals(1,errors.size());
		 assertEquals("size must be between 2 and 20",errors.iterator().next().getMessage());
		 
	}
	@Test
	public void testValidationsEmail() throws DaoException{
		User badUser = new User();
		badUser.setFirstName("amos");
		badUser.setLastName("good last name");
		badUser.setEmail("good@email,com");
		 Set<ConstraintViolation<User>> errors  = validator.validate(badUser);
		 assertEquals(1,errors.size());
		 assertEquals("not a well-formed email address",errors.iterator().next().getMessage());
		 
	}
	
	@Test(expected = org.hibernate.exception.ConstraintViolationException.class)  
	public void testUniqueEmail() throws DaoException{
		User uri = new User("uri","naor","a@b.com");
		userDao.saveUser(uri);
		//Session session = sessionFactory.getCurrentSession();
		//session.save(uri);
		//session.flush();	
		User clone = new User("clone","wars","a@b.com");
		userDao.saveUser(clone);
		//session.save(clone);
		//session.flush();
	}

	@After
	public void cleanUp() throws DaoException{
		List<User> users = userDao.getUsers();
		if(users!=null && !users.isEmpty()){
			for(User user : users){
				userDao.deleteUser(user);
			}
		}
		
	}
}
