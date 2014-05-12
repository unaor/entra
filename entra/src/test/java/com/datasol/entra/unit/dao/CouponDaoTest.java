package com.datasol.entra.unit.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
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
import com.datasol.entra.dao.UserDao;
import com.datasol.entra.domain.Client;
import com.datasol.entra.domain.Coupon;
import com.datasol.entra.domain.User;
import com.datasol.entra.exception.DaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testContext.xml")
@TransactionConfiguration(defaultRollback=true)
@Transactional
public class CouponDaoTest {
	
	@Autowired
	UserDao userDao;
	@Autowired
	ClientDao clientDao;
	@Autowired
	CouponDao couponDao;
	
	@Before
	public void setUp() throws DaoException{
		User uri =new User("uri","naor","uri@naor.com");
		userDao.saveUser(uri);
		Client client = new Client(uri);
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
		Coupon dbCoupon =couponDao.getCouponByClient(client.getClientId()).get(0);
		assertEquals("MEGA COUPON",dbCoupon.getCouponTitle());
	}
	
	@Test
	public void updateCouponDate() throws DaoException{
		Client client = clientDao.getClientByEmail("uri@naor.com");
		Coupon coupon = createCouponToPersist(client);
		couponDao.createCoupon(coupon);
		coupon = null;
		LocalDate twoWeeksFromNow = new LocalDate();
		twoWeeksFromNow = twoWeeksFromNow.plusDays(14);
		Coupon dbCoupon =couponDao.getcoupons().get(0);
		couponDao.extendCoupon(dbCoupon,14);
		dbCoupon = null;
		Coupon ExtendedCoupon = couponDao.getcoupons().get(0);
		LocalDate couponDate = new LocalDate(ExtendedCoupon.getCouponExpirationDate());
		assertEquals(twoWeeksFromNow, couponDate);
	}
	
	
	@After
	public void cleanUp() throws DaoException{
		List<Coupon> coupons = couponDao.getcoupons();
		for (Coupon coupon : coupons){
			couponDao.deleteCoupon(coupon);
		}
	}
	
	
	private Coupon createCouponToPersist(Client client){
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
		return coupon;
	}

}
