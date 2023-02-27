package com.example.demo.domain.service.kakao.message.json.feed;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemContent {
  private String profileText;
  private String profileImageUrl;
  private String titleImageUrl;
  private String titleImageText;
  private String titleImageCategory;
  @Valid
  private List<Item> items;
  private String sum;
  private String sumOp;
}
