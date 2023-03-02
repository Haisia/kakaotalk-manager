package com.example.demo.domain.service.kakao.message.json.list;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.Link;
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
public class ListObject extends MessageObject {
  @NotBlank(message = "header_title 는 필수 입력값 입니다.")
  @JsonAlias({"headerTitle","header_title"})
  private String headerTitle;
  @Valid
  @NotNull(message = "header_link 는 필수 입력값 입니다.")
  @JsonAlias({"headerLink","header_link"})
  private Link headerLink;
  @Valid
  @NotNull(message = "contents 는 필수 입력값 입니다.")
  private List<Content> contents;
  @Valid
  private List<Button> buttons;

  public ListObject(String objectType, String headerTitle, Link headerLink, List<Content> contents, List<Button> buttons) {
    super.objectType = objectType;
    this.headerTitle = headerTitle;
    this.headerLink = headerLink;
    this.contents = contents;
    this.buttons = buttons;
  }
}
