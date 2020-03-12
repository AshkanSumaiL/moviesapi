package com.ashkan.moviesapi.services.implementations;

import com.ashkan.moviesapi.repositories.MemberRepository;
import com.ashkan.moviesapi.entities.Member;
import com.ashkan.moviesapi.exceptions.NotFound.MemberNotFoundException;
import com.ashkan.moviesapi.services.interfaces.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Member findById(int id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException(id));
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void deleteById(int id) {
        memberRepository.deleteById(id);
    }
}
