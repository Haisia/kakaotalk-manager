package com.example.demo.domain.service.kakao.message.json;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendMessageRequest {
    @JsonAlias({"receiverUuids","receiver_uuids"})
    private String receiverUuids;
    @JsonAlias({"templateObject","template_object"})
    private String templateObject;
}
