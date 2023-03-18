package com.trip.want.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class MemberResDto {

    private Long memberId;

    public static MemberResDto of(Long memberId) {
        return new MemberResDto(memberId);
    }

}
