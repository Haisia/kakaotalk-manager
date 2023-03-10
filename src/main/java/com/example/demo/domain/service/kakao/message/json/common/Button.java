package com.example.demo.domain.service.kakao.message.json.common;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Button {
  @Valid
  @NotBlank(message = "title 필수 입력값 입니다.")
  private String title;
  @Valid
  @NotNull(message = "Link 필수 입력값 입니다.")
  private Link link;
}
