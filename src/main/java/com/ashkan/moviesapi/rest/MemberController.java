package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Member;
import com.ashkan.moviesapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/members/{Id}")
    public Member getMember(@PathVariable int Id) {
        Member member = memberService.findById(Id);
        if (member == null) {
            throw new RuntimeException("Member id not found - " + Id);
        }
        return member;
    }



    @PostMapping("/members")
    public Member addMember(@RequestBody Member member) {
        //actor.setId(0);
        memberService.save(member);
        return member;
    }
}
