package com.trip.want.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "like")
@Entity
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private LocalDateTime likeDate;
}
