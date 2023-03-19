package com.trip.want.entity;

import com.trip.want.common.constant.MemberType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_account")
    private String accountId;

    @Column(name = "member_password")
    private String accountPw;

    private String nickname;

    private String memberName;

    private String birthday;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @CreatedDate
    private LocalDateTime signUpDate;

    public Member(String accountId, String accountPw, String nickname, String memberName, String birthday, String email, String phone, MemberType memberType, LocalDateTime signUpDate) {
        this.accountId = accountId;
        this.accountPw = accountPw;
        this.nickname = nickname;
        this.memberName = memberName;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.memberType = memberType;
        this.signUpDate = signUpDate;
    }

    public static Member of(String accountId, String accountPw, String nickname, String memberName, String birthday, String email, String phone, MemberType memberType, LocalDateTime signUpDate) {
        return new Member(
                accountId,
                accountPw,
                nickname,
                memberName,
                birthday,
                email,
                phone,
                memberType,
                signUpDate
        );
    }

}
