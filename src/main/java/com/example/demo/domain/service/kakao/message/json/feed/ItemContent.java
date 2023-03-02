package com.example.demo.domain.service.kakao.message.json.feed;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemContent {
  @JsonAlias({"profileText","profile_text"})
  private String profileText;
  @JsonAlias({"profileImageUrl","profile_image_url"})
  private String profileImageUrl;
  @JsonAlias({"titleImageUrl","title_image_url"})
  private String titleImageUrl;
  @JsonAlias({"titleImageText","title_image_text"})
  private String titleImageText;
  @JsonAlias({"titleImageCategory","title_image_category"})
  private String titleImageCategory;
  @Valid
  private List<Item> items;
  private String sum;
  @JsonAlias({"sumOp","sum_op"})
  private String sumOp;
}
