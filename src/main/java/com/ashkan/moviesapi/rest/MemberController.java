package com.ashkan.moviesapi.rest;

import com.ashkan.moviesapi.entity.Member;
import com.ashkan.moviesapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("{Id}")
    public Member getMember(@PathVariable int Id) {
        return memberService.findById(Id);
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        memberService.save(member);
        return member;
    }
}
