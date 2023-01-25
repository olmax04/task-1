package com.task.taskproject1.interfaces;

import com.task.taskproject1.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberInterface extends MongoRepository<Member,String> {
}
