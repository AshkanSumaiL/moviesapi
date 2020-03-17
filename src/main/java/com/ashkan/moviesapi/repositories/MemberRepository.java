package com.ashkan.moviesapi.repositories;

import com.ashkan.moviesapi.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
