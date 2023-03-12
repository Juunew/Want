package com.trip.want.common.constant;

public enum MemberType {
    USER("회원"),
    ADMIN("관리자");

    private final String memberRole;

    MemberType(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberRole() {
        return this.memberRole;
    }
}
