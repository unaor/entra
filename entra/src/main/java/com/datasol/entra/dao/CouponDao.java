package com.datasol.entra.dao;

import java.util.List;

import com.datasol.entra.domain.Coupon;
import com.datasol.entra.exception.DaoException;

public interface CouponDao {
	
	public void createCoupon(Coupon coupon) throws DaoException;
	
	public void deleteCoupon(Coupon coupon) throws DaoException;
	
	public void changeCouponActivationStatus(Coupon coupon) throws DaoException;
	
	public void extendCoupon(Coupon coupon) throws DaoException;
	
	public List<Coupon> getcoupons() throws DaoException;

}
