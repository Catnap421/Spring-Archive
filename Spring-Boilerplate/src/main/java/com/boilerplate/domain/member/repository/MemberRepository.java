package com.boilerplate.domain.member.repository;

import com.boilerplate.domain.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByUniqueCode(String uniqueCode);
    boolean existsByEmail(String email);
}
