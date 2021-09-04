package com.boilerplate.domain.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.boilerplate.core.exception.BadRequestException;
import com.boilerplate.core.auth.social.dto.SocialProfile;
import com.boilerplate.core.auth.social.service.SocialService;
import com.boilerplate.domain.member.model.entity.Member;
import com.boilerplate.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final SocialService socialService;

    @Transactional(readOnly = true)
    public Member findById(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(()->new BadRequestException("존재하지 않은 사용자에 대한 요청입니다."));
    }


    @Transactional
    public boolean isExistMemberByProvider(String accessToken, String provider) throws JsonProcessingException {
        SocialProfile profile = socialService.getSocialProfile(accessToken);
        return memberRepository.existsByEmail(profile.getEmail());
    }
}