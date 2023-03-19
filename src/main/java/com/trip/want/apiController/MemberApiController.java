package com.trip.want.apiController;

import com.trip.want.common.util.SessionManager;
import com.trip.want.dto.member.MemberResDto;
import com.trip.want.dto.member.login.LoginMemberSessionDto;
import com.trip.want.dto.member.login.LoginReqDto;
import com.trip.want.dto.member.signUp.SignUpReqDto;
import com.trip.want.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
@RestController
public class MemberApiController {

    private final MemberService memberService;
    private final SessionManager sessionManager;

    // 회원가입
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpReqDto dto) {
        MemberResDto result = memberService.createMember(dto);
        return ResponseEntity.ok(result);
    }

    /**
     * 중복체크 - accountId, nickname, email, phone
     */
    @GetMapping("/check-duplicate/account-id/{accountId}")
    public ResponseEntity<?> checkAccountIdDuplicate(@PathVariable String accountId) {
        boolean result = memberService.checkAccountIdDuplicate(accountId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/check-duplicate/nickname/{nickname}")
    public ResponseEntity<?> checkNicknameDuplicate(@PathVariable String nickname) {
        boolean result = memberService.checkNicknameDuplicate(nickname);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/check-duplicate/email/{email}")
    public ResponseEntity<?> checkEmailDuplicate(@PathVariable String email) {
        boolean result = memberService.checkEmailDuplicate(email);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/check-duplicate/phone/{phone}")
    public ResponseEntity<?> checkPhoneDuplicate(@PathVariable String phone) {
        boolean result = memberService.checkPhoneDuplicate(phone);
        return ResponseEntity.ok(result);
    }

    // 로그인
    @PostMapping("/log-in")
    public ResponseEntity<?> loginMember(@RequestBody LoginReqDto dto) {
        LoginMemberSessionDto result = memberService.loginMember(dto);
        return ResponseEntity.ok(result);
    }

    // 로그아웃
    @GetMapping("/log-out")
    public ResponseEntity<?> logoutMember(HttpServletRequest request) {
        return ResponseEntity.ok(sessionManager.destroyedSession(request));
    }
}
