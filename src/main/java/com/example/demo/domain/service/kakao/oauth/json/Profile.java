package com.example.demo.domain.service.kakao.oauth.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {
    private String nickname;
    @JsonAlias({"profileImageUrl","profile_image_url"})
    private String profileImageUrl;
    @JsonAlias({"thumbnailImageUrl","thumbnail_image_url"})
    private String thumbnailImageUrl;
}
