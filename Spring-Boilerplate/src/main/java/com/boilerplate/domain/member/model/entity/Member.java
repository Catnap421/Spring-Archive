package com.boilerplate.domain.member.model.entity;

import com.boilerplate.core.auth.jwt.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id", nullable = false)
    private Long memberId;

    @Column(name="identifier", nullable = false)
    private String identifier;

    @Column(name="email", length = 255, nullable = false)
    private String email;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name="name", length = 15, nullable = false)
    private String name;

    @Column(name="unique_code", length = 7, nullable = false)
    private String uniqueCode;

    @Enumerated(EnumType.STRING)
    @Column(name="role", length = 20, nullable = false)
    private Role role;

    @Builder.Default
    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate = LocalDateTime.now();

    @Builder.Default
    @Column(name = "mod_date", nullable = false)
    private LocalDateTime modDate = LocalDateTime.now();
}
