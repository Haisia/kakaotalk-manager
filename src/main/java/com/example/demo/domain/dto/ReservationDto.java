package com.example.demo.domain.dto;

import com.example.demo.domain.entity.message.commerce.CommerceMessage;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ReservationDto {

  @Getter
  @Setter
  public static class SaveCommerce {
    private CommerceMessage commerceMessage;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime reservationDateTime;
  }
}
