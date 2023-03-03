package com.example.demo.domain.service.kakao.friend.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Friend {
    private String uuid;
    @JsonAlias({"profileThumbnailImage","profile_thumbnail_image"})
    private String profileThumbnailImage;
    @JsonAlias({"profileNickname","profile_nickname"})
    private String profileNickname;
}
