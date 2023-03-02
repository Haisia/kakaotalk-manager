package com.example.demo.domain.service.kakao.message.json.commerce;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageCommerceParam extends SendMessageParam {
  @Valid
  @NotNull(message = "commerceObject 는 필수 입력값 입니다.")
  @JsonAlias({"commerceObject","commerce_object"})
  CommerceObject commerceObject;

  public SendMessageCommerceParam(Long groupId, CommerceObject commerceObject) {
    super.groupId = groupId;
    this.commerceObject = commerceObject;
  }
}

