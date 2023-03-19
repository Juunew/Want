package com.trip.want.common.util;

import com.trip.want.common.constant.MemberType;
import com.trip.want.dto.auth.MemberSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SessionManager {

    public MemberSession createSession(Long memberId, String memberName, String nickname, MemberType memberType) {
        return MemberSession.of(
                memberId,
                memberName,
                nickname,
                memberType
        );
    }

    public String destroyedSession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "log-out success";
    }
}
