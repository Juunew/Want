package com.trip.want.common.config;

import com.trip.want.common.constant.errorType.MemberError;
import com.trip.want.common.exception.MemberException;
import com.trip.want.dto.auth.MemberSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
public class WantInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("request method = {}", request.getMethod());
        if (Objects.equals(request.getMethod(), "POST") || Objects.equals(request.getMethod(), "PUT") || Objects.equals(request.getMethod(), "DELETE")) {
            return authenticationFilter(request);
        }

        return true;
    }

    private boolean authenticationFilter(HttpServletRequest request) {
        MemberSession memberSession = (MemberSession) request.getSession().getAttribute("memberInfo");

        if (memberSession == null) {
            throw new MemberException(MemberError.LOGIN_INFO_NOT_FOUND);
        }

        return true;
    }
}
