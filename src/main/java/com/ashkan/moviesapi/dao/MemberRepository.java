package com.ashkan.moviesapi.dao;

import com.ashkan.moviesapi.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
