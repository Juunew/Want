package com.trip.want.entity;

import com.trip.want.common.constant.Continent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "nation")
@Entity
public class Nation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nation_id")
    private Long id;

    private String nationName;

    @Enumerated(EnumType.STRING)
    private Continent continent;
}
