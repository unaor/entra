package com.datasol.entra.service;

import com.datasol.entra.domain.User;
import com.datasol.entra.exception.ServiceException;

public interface UserService {
	
	public void registerUser(User user) throws ServiceException;

}
