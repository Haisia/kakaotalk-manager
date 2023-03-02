package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FriendDto {
  private String nickname;
  private String profileImageUrl;
  private String uuid;

  public FriendDto(){}

}
