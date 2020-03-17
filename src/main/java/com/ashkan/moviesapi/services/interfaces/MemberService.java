package com.ashkan.moviesapi.services.interfaces;

import com.ashkan.moviesapi.entities.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll();

    Member findById(int id);

    void save(Member member);

    void deleteById(int id);
}
