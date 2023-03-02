package com.example.demo.domain.service.kakao.message.json.commerce;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommerceObject extends MessageObject {
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
  private Content content;
  @Valid
  @NotNull(message = "commerce 는 필수 입력값 입니다.")
  private Commerce commerce;
  private List<Button> buttons;

  public CommerceObject(String objectType, Content content, Commerce commerce, List<Button> buttons) {
    super.objectType = objectType;
    this.content = content;
    this.commerce = commerce;
    this.buttons = buttons;
  }
}
