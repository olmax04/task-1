package com.task.taskproject1.controllers;

import com.task.taskproject1.entity.Member;
import com.task.taskproject1.interfaces.MemberInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired MemberInterface memberInterface;


    @GetMapping("/members")
    public List<Member> getMembers(){
        return memberInterface.findAll();
    }

    @GetMapping("/member/create")
    public void createMember(){
        Member member = new Member();
        member.setMemberId(1);
        member.setName("Maksim");
        member.setSurname("Alesiayuk");

        memberInterface.insert(member);
    }
}
