package com.trip.want.common.exception;

import com.trip.want.common.constant.errorType.MemberError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberException extends RuntimeException{

    private MemberError memberError;
    private String message;

    public MemberException(MemberError memberError) {
        this.memberError = memberError;
        this.message = memberError.getMessage();
    }
}
