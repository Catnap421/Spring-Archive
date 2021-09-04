package com.boilerplate.core.auth.social.dto;

import lombok.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
    private String identifer;
    private String gender;
    private String age_range;
}