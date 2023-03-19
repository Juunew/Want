package com.trip.want.common.config;

import com.trip.want.common.config.annotation.InfoMember;
import com.trip.want.common.util.HttpServletRequestUtil;
import com.trip.want.dto.auth.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Component
public class MemberInfoResolver implements HandlerMethodArgumentResolver {

    private final HttpServletRequestUtil util;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isMemberInfoAnnotation = parameter.getParameterAnnotation(InfoMember.class) != null;
        boolean isMemberInfoClass = parameter.getParameterType().equals(MemberInfo.class);

        return isMemberInfoAnnotation && isMemberInfoClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return new com.trip.want.dto.auth.MemberInfo(request).setIp(util.getIp(request));
    }
}
