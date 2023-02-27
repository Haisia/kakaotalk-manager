package com.example.demo.domain.service.kakao.message.json.common;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Social {
  @Pattern(regexp = "^[0-9]+$", message = "like_count 는 숫자만 입력가능합니다.")
  private String likeCount;
  @Pattern(regexp = "^[0-9]+$", message = "comment_count 는 숫자만 입력가능합니다.")
  private String commentCount;
  @Pattern(regexp = "^[0-9]+$", message = "shared_count 는 숫자만 입력가능합니다.")
  private String sharedCount;
  @Pattern(regexp = "^[0-9]+$", message = "view_count 는 숫자만 입력가능합니다.")
  private String viewCount;
  @Pattern(regexp = "^[0-9]+$", message = "subscriber_count 는 숫자만 입력가능합니다.")
  private String subscriberCount;
}
