package com.example.demo.domain.service.kakao.message.json.location;

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
public class LocationObject extends MessageObject {
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
  private Content content;
  @Valid
  private List<Button> buttons;
  @NotBlank(message = "address 는 필수 입력값 입니다.")
  private String address;
  @JsonAlias({"addressTitle","address_title"})
  private String addressTitle;

  public LocationObject(String objectType, Content content, List<Button> buttons, String address, String addressTitle) {
    super.objectType = objectType;
    this.content = content;
    this.buttons = buttons;
    this.address = address;
    this.addressTitle = addressTitle;
  }
}
