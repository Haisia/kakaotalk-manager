package com.example.demo.domain.service.kakao.message.json.calendar;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalendarObject extends MessageObject {
  @NotBlank(message = "id_type 는 필수 입력값 입니다.")
  @JsonAlias({"idType","id_type"})
  private String idType;
  @NotBlank(message = "id 는 필수 입력값 입니다.")
  private String id;
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
  private Content content;
  private List<Button> buttons;

  public CalendarObject(String objectType, String idType, String id, Content content, List<Button> buttons) {
    super.objectType = objectType;
    this.idType = idType;
    this.id = id;
    this.content = content;
    this.buttons = buttons;
  }
}
