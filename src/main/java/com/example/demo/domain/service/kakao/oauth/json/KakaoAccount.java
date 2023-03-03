package com.example.demo.domain.service.kakao.oauth.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoAccount {
    private Profile profile;
    private String email;
}
