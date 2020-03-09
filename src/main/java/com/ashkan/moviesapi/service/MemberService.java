package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.entity.Member;

import java.util.List;

public interface MemberService {
    public List<Member> findAll();

    public Member findById(int theId);

    public void save(Member member);

    public void deleteById(int theId);
}
