package com.example.demo.domain.service.kakao.message.json.common;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

public class MessageObject {
  @NotNull(message = "object_type 는 필수 입력값 입니다.")
  @JsonAlias({"objectType","object_type"})
  public String objectType;
}
