package com.task.taskproject1.interfaces;

import com.task.taskproject1.entity.Coupon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CouponInterface extends MongoRepository<Coupon,String> {

    List<Coupon> findCouponsByMemberId(long memberId);
}
