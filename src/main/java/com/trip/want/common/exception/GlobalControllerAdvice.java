package com.trip.want.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValidException(MethodArgumentNotValidException e) {
        log.info("ErrorMessage = {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
