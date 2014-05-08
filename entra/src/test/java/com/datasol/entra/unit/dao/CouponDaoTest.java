package com.datasol.entra.unit.dao;

import static org.junit.Assert.assertEquals;

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
import com.datasol.entra.dao.CouponDao;
import com.datasol.entra.domain.Client;
import com.datasol.entra.domain.Coupon;
import com.datasol.entra.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class CouponDaoTest {
	
	@Autowired
	ClientDao clientDao;
	@Autowired
	CouponDao couponDao;
	
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
	}
	
	@Test
	public void createCoupon() throws DaoException{
		Client client = clientDao.getClientByEmail("uri@naor.com");
		Coupon coupon = new Coupon();
		coupon.setAvailableQuantity(3);
		coupon.setClient(client);
		coupon.setCouponCreationDate(new Date());
		coupon.setCouponDescription("first test coupon");
		coupon.setCouponExpirationDate(new Date());
		coupon.setCouponPictureLocation("where/are/you");
		coupon.setCouponTitle("MEGA COUPON");
		coupon.setCouponValue(400);
		coupon.setIsActive(true);
		couponDao.createCoupon(coupon);
		coupon = null;
		Coupon dbCoupon =couponDao.getcoupons().get(0);
		assertEquals("MEGA COUPON",dbCoupon.getCouponTitle());
	}
	
	@After
	public void cleanUp() throws DaoException{
		List<Coupon> coupons = couponDao.getcoupons();
		for (Coupon coupon : coupons){
			couponDao.deleteCoupon(coupon);
		}
	}

}
