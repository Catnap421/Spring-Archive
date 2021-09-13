package com.example.springenvers.domain;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private int age;
    private String name;
    private String address;
    private String job;

}
