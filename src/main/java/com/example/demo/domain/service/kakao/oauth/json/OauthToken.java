package com.example.demo.domain.service.kakao.oauth.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OauthToken {
    private String accessToken;
    private String tokenType;
    private String refreshToken;
    private String scope;
    private int refreshTokenExpiresIn;
    private int expiresIn;
}
