package com.example.demo.domain.service.kakao.message.json.common;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content {
  @NotBlank(message = "title 는 필수 입력값 입니다.")
  private String title;
  private String description;
  @NotBlank(message = "image_url 는 필수 입력값 입니다.")
  @JsonAlias({"imageUrl","image_url"})
  private String imageUrl;
  @Pattern(regexp = "^[0-9]+$", message = "image_width 는 숫자만 입력가능합니다.")
  @JsonAlias({"imageWidth","image_width"})
  private String imageWidth;
  @Pattern(regexp = "^[0-9]+$", message = "image_height 는 숫자만 입력가능합니다.")
  @JsonAlias({"imageHeight","image_height"})
  private String imageHeight;
  @Valid
  @NotNull(message = "link 는 필수 입력값 입니다.")
  private Link link;
}
