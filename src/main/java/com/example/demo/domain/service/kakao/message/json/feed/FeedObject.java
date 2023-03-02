package com.example.demo.domain.service.kakao.message.json.feed;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Content;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import com.example.demo.domain.service.kakao.message.json.common.Social;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FeedObject extends MessageObject {
  @Valid
  @NotNull(message = "content 는 필수 입력값 입니다.")
  private Content content;
  @Valid
  @JsonAlias({"itemContent","item_content"})
  private ItemContent itemContent;
  @Valid
  private Social social;
  @Valid
  private List<Button> buttons;

  public FeedObject(String objectType, Content content, ItemContent itemContent, Social social, List<Button> buttons) {
    super.objectType = objectType;
    this.content = content;
    this.itemContent = itemContent;
    this.social = social;
    this.buttons = buttons;
  }

  public FeedObject(Content content, ItemContent itemContent, Social social, List<Button> buttons) {
    this.content = content;
    this.itemContent = itemContent;
    this.social = social;
    this.buttons = buttons;
  }
}
