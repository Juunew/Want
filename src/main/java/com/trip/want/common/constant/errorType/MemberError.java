package com.trip.want.common.constant.errorType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum MemberError {

    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "잘못된 비밀번호입니다."),
    LOGIN_INFO_NOT_FOUND(HttpStatus.UNAUTHORIZED, "로그인 정보가 존재하지 않습니다.");

    private final HttpStatus status;
    private final String message;
}
