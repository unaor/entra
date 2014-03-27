package com.datasol.entra.dao;

import java.util.List;

import com.datasol.entra.domain.User;
import com.datasol.entra.exception.DaoException;

public interface UserDao {
	
	public List<User> getUsers() throws DaoException;
	
	public User getUserByEmail(String email) throws DaoException;
	
	public void saveUser(User user) throws DaoException;
	
	public void deleteUser(User user) throws DaoException;

}
