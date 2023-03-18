package com.trip.want.dto.member;

import com.trip.want.common.constant.MemberType;
import com.trip.want.entity.Member;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
public class SignUpReqDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String accountId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "(?=.*[a-zA-z])(?=.*\\d)(?=.*[~!@#$%^&*()+=]).{8,16}",
    message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 포함된 8자 ~ 16자 사이여야 합니다.")
    private String accountPw;

    @NotBlank(message = "닉네입을 입력해주세요.")
    @Size(min = 2, max = 10, message = "닉네임은 2자 이상 10자 이하로 입력해주세요.")
    private String nickname;

    @NotBlank(message = "이름을 입력해주세요.")
    private String memberName;

    @NotBlank(message = "생년월일을 입력해주세요.")
    @Pattern(regexp = "([0-9]{4})([0-9]{2})(0-9){2}", message = "올바른 생년월일을 입력해주세요.")
    private String birthday;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "(010)(\\d{4})(\\d{4})", message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;

    public Member toEntity() {
        return Member.builder()
                .accountId(accountId)
                .accountPw(accountPw)
                .nickname(nickname)
                .memberName(memberName)
                .birthday(birthday)
                .email(email)
                .phone(phone)
                .memberType(MemberType.USER)
                .signUpDate(LocalDateTime.now())
                .build();
    }

}
