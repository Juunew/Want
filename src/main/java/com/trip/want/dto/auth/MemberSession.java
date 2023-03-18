package com.trip.want.dto.auth;

import com.trip.want.common.constant.MemberType;
import com.trip.want.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberSession implements Serializable {

    private Long memberId;
    private String memberName;
    private String nickname;
    private MemberType memberType;

    public MemberSession(Member member) {
        this.memberId = member.getId();
        this.memberName = member.getMemberName();
        this.nickname = member.getNickname();
        this.memberType = member.getMemberType();
    }
}
