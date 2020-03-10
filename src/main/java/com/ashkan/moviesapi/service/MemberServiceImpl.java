package com.ashkan.moviesapi.service;

import com.ashkan.moviesapi.dao.MemberRepository;
import com.ashkan.moviesapi.entity.Member;
import com.ashkan.moviesapi.exception.NotFound.MemberNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(int theId) {
        return  memberRepository.findById(theId)
                .orElseThrow(()->new MemberNotFoundException(theId));
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteById(int theId) {
        memberRepository.deleteById(theId);
    }
}
