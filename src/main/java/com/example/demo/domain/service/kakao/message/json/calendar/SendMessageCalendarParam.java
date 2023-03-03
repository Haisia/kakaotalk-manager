package com.example.demo.domain.service.kakao.message.json.calendar;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageCalendarParam extends SendMessageParam {
  @Valid
  @NotNull(message = "calendarObject 는 필수 입력값 입니다.")
  @JsonAlias({"calendarObject","calendar_object"})
  CalendarObject calendarObject;

  public SendMessageCalendarParam(Long groupId, CalendarObject calendarObject) {
    super.groupId = groupId;
    this.calendarObject = calendarObject;
  }
}

