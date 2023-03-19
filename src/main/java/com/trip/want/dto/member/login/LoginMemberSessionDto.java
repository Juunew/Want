package com.trip.want.dto.member.login;

import com.trip.want.common.constant.MemberType;
import com.trip.want.dto.auth.MemberSession;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LoginMemberSessionDto {

    private Long memberId;
    private String memberName;
    private String nickname;
    private MemberType memberType;

    public static LoginMemberSessionDto of(MemberSession memberSession) {
        return new LoginMemberSessionDto(
                memberSession.getMemberId(),
                memberSession.getMemberName(),
                memberSession.getNickname(),
                memberSession.getMemberType()
        );
    }
}
