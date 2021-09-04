package com.boilerplate.core.auth.social.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.boilerplate.core.auth.jwt.JwtProvider;
import com.boilerplate.core.auth.social.dto.SocialProfile;
import com.boilerplate.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class SocialService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final ObjectMapper objectMapper;

    private final MemberRepository memberRepository;
    private final JwtProvider jwtTokenProvider;

    @Value("${spring.social.kakao.url}")
    private String providerUrl;

    public ResponseEntity<String> getSocialResponse(String accessToken) throws HttpClientErrorException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBearerAuth(accessToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);

        return restTemplate.postForEntity(providerUrl, request, String.class);
    }

    public SocialProfile getSocialProfile(String accessToken) throws JsonProcessingException {
        ResponseEntity<String> response = getSocialResponse(accessToken);

        JsonNode jsonNode = objectMapper.readTree(response.getBody());

        SocialProfile profile = new SocialProfile();
        profile.setIdentifer(jsonNode.get("email").textValue());
        return profile;
    }
}



