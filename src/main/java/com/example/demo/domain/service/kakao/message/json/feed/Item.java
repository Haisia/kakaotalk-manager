package com.example.demo.domain.service.kakao.message.json.feed;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
  @NotBlank(message = "item 는 필수 입력값 입니다.")
  private String item;
  @NotBlank(message = "item_op 는 필수 입력값 입니다.")
  @JsonAlias({"itemOp","item_op"})
  private String itemOp;
}
