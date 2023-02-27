package com.example.demo.domain.service.kakao.oauth.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {
    private String nickname;
    private String profileImageUrl;
    private String thumbnailImageUrl;
}
