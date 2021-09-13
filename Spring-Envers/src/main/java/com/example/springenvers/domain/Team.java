package com.example.springenvers.domain;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Builder
@Getter
@Audited
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    @Column(name = "limit_number")
    private int limitNumber;
}
