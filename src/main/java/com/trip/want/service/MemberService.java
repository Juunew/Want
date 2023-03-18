package com.trip.want.service;

import com.trip.want.dto.member.MemberResDto;
import com.trip.want.dto.member.SignUpReqDto;
import com.trip.want.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResDto createMember(SignUpReqDto dto) {
        return MemberResDto.of(memberRepository.save(dto.toEntity()).getId());
    }
}
