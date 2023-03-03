package com.example.demo.domain.service.kakao.oauth.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OauthToken {
    @JsonAlias({"accessToken","access_token"})
    private String accessToken;
    @JsonAlias({"tokenType","token_type"})
    private String tokenType;
    @JsonAlias({"refreshToken","refresh_token"})
    private String refreshToken;
    private String scope;
    @JsonAlias({"refreshTokenExpiresIn","refresh_token_expires_in"})
    private int refreshTokenExpiresIn;
    @JsonAlias({"expiresIn","expires_in"})
    private int expiresIn;
}
