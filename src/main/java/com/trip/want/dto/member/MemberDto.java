package com.trip.want.dto.member;

import com.trip.want.common.constant.MemberType;
import com.trip.want.entity.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberDto {

    private Long memberId;
    private String accountId;
    private String accountPw;
    private String nickname;
    private String memberName;
    private String birthday;
    private String email;
    private String phone;
    private MemberType memberType;

    public static MemberDto fromEntity(Member member) {
        return new MemberDto(
                member.getId(),
                member.getAccountId(),
                member.getAccountPw(),
                member.getNickname(),
                member.getMemberName(),
                member.getBirthday(),
                member.getEmail(),
                member.getPhone(),
                member.getMemberType()
        );
    }

}
