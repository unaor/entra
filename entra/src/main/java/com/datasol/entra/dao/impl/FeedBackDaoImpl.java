package com.datasol.entra.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datasol.entra.dao.FeedBackDao;
import com.datasol.entra.domain.FeedBack;
import com.datasol.entra.exception.DaoException;

@Repository
public class FeedBackDaoImpl implements FeedBackDao {
	
	@Autowired
	SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(FeedBackDaoImpl.class);

	@Override
	public void createFeedback(FeedBack feedback) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("adding feedback to client "+feedback.getReceiverOfFBClient().getClientId());
		session.saveOrUpdate(feedback);
	}

	@Override
	public List<FeedBack> getClientFeedBacks(Long clientId) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<FeedBack> feedbacks = session.createQuery("from FeedBack fb where fb.receiverOfFBClient.clientId = :clientId").
				setParameter("clientId", clientId).list();
		return feedbacks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedBack> getFeedbacksByUser(Long userId) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<FeedBack> feedbacks = session.createQuery("from FeedBack fb where fb.authorOfFBUser.userId=:userId").
				setParameter("userId", userId).list();
		return feedbacks;
	}

	@Override
	public List<FeedBack> getAllFeedbacks() throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from FeedBack").list();
	}

	@Override
	public void deleteFB(FeedBack fb) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(fb);
		
	}

}
