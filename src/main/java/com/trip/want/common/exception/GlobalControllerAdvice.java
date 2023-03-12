package com.trip.want.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<?> memberExceptionHandler(MemberException e) {
        log.info("ErrorCode = {}, ErrorMessage = {}", e.getMemberError(), e.getMessage());
        return ResponseEntity.status(e.getMemberError().getStatus())
                .body(e.getMemberError().name());
    }

    @ExceptionHandler(PostException.class)
    public ResponseEntity<?> postExceptionHandler(PostException e) {
        log.info("ErrorCode = {}, ErrorMessage = {}", e.getPostError(), e.getMessage());
        return ResponseEntity.status(e.getPostError().getStatus())
                .body(e.getPostError().name());
    }
}
