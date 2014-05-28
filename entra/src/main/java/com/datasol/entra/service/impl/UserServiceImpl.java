package com.datasol.entra.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.datasol.entra.dao.UserDao;
import com.datasol.entra.domain.Authority;
import com.datasol.entra.domain.User;
import com.datasol.entra.exception.DaoException;
import com.datasol.entra.exception.ServiceException;
import com.datasol.entra.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	private final String USER_AUTHORITY="User";
	
	@Autowired
	UserDao userDao;

	private static final Logger log = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false ,rollbackFor = Exception.class) 
	public void registerUser(User user) throws ServiceException {
		log.debug("starting user registration user" + user.getEmail());
		//TODO:it needs to be false until we can confirm the email
		user.setEnabled(true);
		user.setRegistrationDate(new Date());
		Authority authority = new Authority();
		authority.setAuthorityName(USER_AUTHORITY);
		user.setAuthority(authority);
		try{
			userDao.saveUser(user);
			log.debug("successfully persisted user");
		}catch (DaoException ex){
			log.error("could not save user "+ex);
			throw new ServiceException("error saving user to database");
		}

	}

}
