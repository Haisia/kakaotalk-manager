package com.example.demo.domain.service.kakao.message.json.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Link {
  private String webUrl;
  private String mobileWebUrl;
  private String androidExecutionParams;
  private String iosExecutionParams;

  public boolean isNotBlankAnyOne(){
    if (webUrl != null) return true;
    if (mobileWebUrl != null) return true;
    if (androidExecutionParams != null) return true;
    if (iosExecutionParams != null) return true;

    return false;
  }

  public Link(String webUrl, String mobileWebUrl, String androidExecutionParams, String iosExecutionParams) {
    this.webUrl = webUrl;
    this.mobileWebUrl = mobileWebUrl;
    this.androidExecutionParams = androidExecutionParams;
    this.iosExecutionParams = iosExecutionParams;

    if (!isNotBlankAnyOne()) throw new IllegalArgumentException("Link 의 값 중 적어도 하나는 존재해야 합니다.");
  }
}
