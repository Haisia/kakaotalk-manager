package com.example.demo.domain.service.kakao.oauth.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {

    private String id;
    @JsonAlias({"kakaoAccount","kakao_account"})
    private KakaoAccount kakaoAccount;

}


