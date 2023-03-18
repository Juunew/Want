package com.trip.want.controller;

import com.trip.want.common.responseBody.WantResponse;
import com.trip.want.dto.member.MemberResDto;
import com.trip.want.dto.member.SignUpReqDto;
import com.trip.want.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/sign-up")
    public WantResponse<MemberResDto> signUp(@Valid @RequestBody SignUpReqDto dto) {
        MemberResDto result = memberService.createMember(dto);
        return WantResponse.success(result);
    }

    }
