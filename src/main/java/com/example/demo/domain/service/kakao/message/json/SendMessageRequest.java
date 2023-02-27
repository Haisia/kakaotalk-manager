package com.example.demo.domain.service.kakao.message.json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendMessageRequest {
    private String receiverUuids;
    private String templateObject;
}
