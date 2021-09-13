package com.example.springenvers.service;

import com.example.springenvers.domain.Job;
import com.example.springenvers.domain.Member;
import com.example.springenvers.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void 멤버_추가_테스트(){
        Member member = Member.builder()
                .name("조현우")
                .age(25)
                .job(Job.Student.getKrName())
                .address("순천시")
                .build();

        memberRepository.save(member);

        Member savedMember = memberRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());

        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAge(), savedMember.getAge());
        assertEquals(member.getJob(), savedMember.getJob());
        assertEquals(member.getAddress(), savedMember.getAddress());

    }

    @Test
    public void 멤버_수정_테스트(){
        Member member = memberRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());

        member.setAddress("서울시");

        memberRepository.save(member);

        Member savedMember = memberRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());

        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAge(), savedMember.getAge());
        assertEquals(member.getJob(), savedMember.getJob());
        assertEquals(member.getAddress(), savedMember.getAddress());
    }
}
