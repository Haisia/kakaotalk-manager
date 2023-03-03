package com.example.demo.domain.service.kakao.message.json.common;

import com.fasterxml.jackson.annotation.JsonAlias;

public class SendMessageParam {
  @JsonAlias({"groupId","group_id"})
  protected Long groupId;

  public Long getGroupId() {
    return groupId;
  }
}
