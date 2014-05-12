package com.datasol.entra.dao;

import java.util.List;

import com.datasol.entra.domain.FeedBack;
import com.datasol.entra.exception.DaoException;

public interface FeedBackDao {
	
	public void createFeedback(FeedBack feedback) throws DaoException;
	
	public List<FeedBack> getClientFeedBacks(Long clientId) throws DaoException;
	
	public List<FeedBack> getFeedbacksByUser(Long userId) throws DaoException;
	
	public List<FeedBack> getAllFeedbacks() throws DaoException;
	
	public void deleteFB(FeedBack fb) throws DaoException;

}
