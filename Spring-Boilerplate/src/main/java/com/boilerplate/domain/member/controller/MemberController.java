package com.boilerplate.domain.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.boilerplate.core.auth.jwt.dto.TokenDto;
import com.boilerplate.domain.member.model.dto.MemberDto;
import com.boilerplate.domain.member.model.entity.Member;
import com.boilerplate.domain.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId){
        Member member = memberService.findById(memberId);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/exist/{provider}")
    public ResponseEntity<MemberCheckDto> isExistMember(@RequestBody TokenDto token, @PathVariable String provider) throws JsonProcessingException {
        boolean isExist = memberService.isExistMemberByProvider(token.getAccessToken(), provider);

        return ResponseEntity.ok(new MemberCheckDto(isExist));
    }

    @GetMapping("/test")
    public ResponseEntity<MemberDto> test(){
        MemberDto memberDto = MemberDto.builder().memberId(1L).email("test@gmail.com").name("treering").identifier("test").uniqueCode("1234").build();
        return ResponseEntity.ok(memberDto);
    }

    @AllArgsConstructor
    public class MemberCheckDto {
        private boolean exist;
    }

}