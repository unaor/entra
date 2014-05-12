package com.datasol.entra.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datasol.entra.dao.CouponDao;
import com.datasol.entra.domain.Coupon;
import com.datasol.entra.exception.DaoException;

@Repository
public class CouponDaoImpl implements CouponDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(CouponDaoImpl.class);

	@Override
	public void createCoupon(Coupon coupon) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("creating new coupon "+coupon.getCouponTitle());
		session.saveOrUpdate(coupon);

	}

	@Override
	public void deleteCoupon(Coupon coupon) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("deleting coupon "+coupon.getCouponTitle());
		session.delete(coupon);

	}

	@Override
	public void changeCouponActivationStatus(Coupon coupon) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("changing coupon "+coupon.getCouponTitle() +" its active : "+coupon.getIsActive());
		coupon.setIsActive(!coupon.getIsActive());
		session.update(coupon);

	}

	@Override
	public void extendCoupon(Coupon coupon,int numOfDays) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("extending coupon "+coupon.getCouponTitle() +" end date");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, numOfDays);
		coupon.setCouponExpirationDate(cal.getTime());
		session.update(coupon);
	}

	@Override
	public List<Coupon> getcoupons() throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		logger.debug("getting all coupons");
		return (List<Coupon>) session.createQuery("from Coupon").list();
	}

	@Override
	public List<Coupon> getCouponByClient(Long clientId) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		List<Coupon> coupons = session.createQuery("from Coupon c where c.client.clientId = :clientId").
				setParameter("clientId", clientId).list();
		return coupons;
	}

}
