package com.boilerplate.domain.member.model.component;

import com.boilerplate.domain.member.model.dto.MemberDto;
import com.boilerplate.domain.member.model.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member convertToMember(MemberDto memberDto);

    MemberDto convertToMemberDto(Member member);
}