package com.ashkan.moviesapi.controllers;

import com.ashkan.moviesapi.entities.Member;
import com.ashkan.moviesapi.services.interfaces.MemberService;
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

    @GetMapping("{id}")
    public Member getMember(@PathVariable int id) {
        return memberService.findById(id);
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        memberService.save(member);
        return member;
    }
}
