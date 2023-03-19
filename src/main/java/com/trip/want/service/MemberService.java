package com.trip.want.service;

import com.trip.want.common.constant.errorType.MemberError;
import com.trip.want.common.exception.MemberException;
import com.trip.want.common.util.SessionManager;
import com.trip.want.dto.member.MemberDto;
import com.trip.want.dto.member.MemberResDto;
import com.trip.want.dto.member.login.LoginMemberSessionDto;
import com.trip.want.dto.member.login.LoginReqDto;
import com.trip.want.dto.member.signUp.SignUpReqDto;
import com.trip.want.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    public MemberResDto createMember(SignUpReqDto dto) {
        return MemberResDto.of(memberRepository.save(dto.toEntity()).getId());
    }

    @Transactional(readOnly = true)
    public boolean checkAccountIdDuplicate(String accountId) {
        return memberRepository.existsByAccountId(accountId);
    }

    @Transactional(readOnly = true)
    public boolean checkNicknameDuplicate(String nickname) {
        return memberRepository.existsByNickname(nickname);
    }

    @Transactional(readOnly = true)
    public boolean checkEmailDuplicate(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean checkPhoneDuplicate(String phone) {
        return memberRepository.existsByPhone(phone);
    }

    public LoginMemberSessionDto loginMember(LoginReqDto dto) {
        MemberDto memberDto = checkMember(dto);

        return LoginMemberSessionDto.of(sessionManager.createSession(
                memberDto.getMemberId(),
                memberDto.getMemberName(),
                memberDto.getNickname(),
                memberDto.getMemberType()
        ));
    }

    private MemberDto checkMember(LoginReqDto dto) {
        MemberDto memberDto = MemberDto.fromEntity(memberRepository.findByAccountId(dto.getAccountId()));

        // accountId check, accountPw check 분리?
        // accountId check
        if (memberDto == null) {
            throw new MemberException(MemberError.MEMBER_NOT_FOUND);
        }

        // accountPw check
        if (!memberDto.getAccountPw().equals(dto.getAccountPw())) {
            throw new MemberException(MemberError.INVALID_PASSWORD);
        }

        return memberDto;
    }

}
