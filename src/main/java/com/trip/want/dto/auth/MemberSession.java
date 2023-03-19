package com.trip.want.dto.auth;

import com.trip.want.common.constant.MemberType;
import com.trip.want.dto.member.MemberDto;
import com.trip.want.entity.Member;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberSession implements Serializable {

    private Long memberId;
    private String memberName;
    private String nickname;
    private MemberType memberType;

    public MemberSession(MemberDto dto) {
        this.memberId = dto.getMemberId();
        this.memberName = dto.getMemberName();
        this.nickname = dto.getNickname();
        this.memberType = dto.getMemberType();
    }

    public static MemberSession of(Long memberId, String memberName, String nickname, MemberType memberType) {
        return new MemberSession(
                memberId,
                memberName,
                nickname,
                memberType
        );
    }

}
