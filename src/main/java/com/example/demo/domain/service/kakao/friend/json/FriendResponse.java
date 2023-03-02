package com.example.demo.domain.service.kakao.friend.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FriendResponse {
    private List<Friend> elements;
    @JsonAlias({"totalCount","total_count"})
    private Integer totalCount;
}
