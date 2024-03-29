package com.trip.want.dto.auth;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberInfo {

    private Long memberId;
    private String ip;

    public MemberInfo(HttpServletRequest request) {
        MemberSession memberSession = (MemberSession) request.getSession().getAttribute("memberInfo");
        if (memberSession != null) {
            this.memberId = memberSession.getMemberId();
        }
    }

    public MemberInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }
}
