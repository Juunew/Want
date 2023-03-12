package com.trip.want.common.exception;

import com.trip.want.common.constant.errorType.PostError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostException extends RuntimeException{

    private PostError postError;
    private String message;

    public PostException(PostError postError) {
        this.postError = postError;
        this.message = postError.getMessage();
    }
}
