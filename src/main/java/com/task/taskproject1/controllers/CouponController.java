package com.task.taskproject1.controllers;

import com.task.taskproject1.entity.Coupon;
import com.task.taskproject1.interfaces.CouponInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.sql.Timestamp;

@RestController
public class CouponController {

    @Autowired
    private CouponInterface couponInterface;

    @GetMapping("/coupons")
    public List<Coupon> getCoupons(){
        return couponInterface.findAll();
    }
    @GetMapping("/coupons/{memberId}/valid")
    public List<Coupon> getValidCouponsByMemberId(@PathVariable long memberId) {
        List<Coupon> coupons = getCouponsByMemberId(memberId);
        List<Coupon> validCoupons = new ArrayList<Coupon>();
        for (int i = 0; i < coupons.size(); i++) {
            Coupon coupon = coupons.get(i);
            Timestamp dateFrom = Timestamp.valueOf(coupon.getValidFrom());
            Timestamp dateUntil = Timestamp.valueOf(coupon.getValidUntil());
            int diffInDays = (int)( (dateUntil.getTime() - dateFrom.getTime()) / (1000 * 60 * 60 * 24) );
            if(diffInDays>0){
                validCoupons.add(coupon);
            }
        }
        return validCoupons;
    }
    @GetMapping("/coupons/{memberId}/all")
    public List<Coupon> getCouponsByMemberId(@PathVariable long memberId){
        return couponInterface.findCouponsByMemberId(memberId);
    }

    @GetMapping("/coupon/create")
    public void createCoupon(){
        Coupon coupon = new Coupon();
        coupon.setMemberId(1);
        coupon.setCouponId(2);
        Date dateFrom = new Date();
        Timestamp timestampFrom = new Timestamp(dateFrom.getTime());
        Date dateUntil = new Date();
        Timestamp timestampUntil = new Timestamp(dateUntil.getTime());
        coupon.setValidFrom(timestampFrom.toString());
        coupon.setValidUntil(timestampUntil.toString());
        couponInterface.insert(coupon);
    }

}
