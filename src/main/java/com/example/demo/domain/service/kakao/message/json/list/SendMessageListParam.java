package com.example.demo.domain.service.kakao.message.json.list;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageListParam extends SendMessageParam {
  @Valid
  @NotNull(message = "listObject 는 필수 입력값 입니다.")
  ListObject listObject;

  public SendMessageListParam(Long groupId, ListObject listObject) {
    super.groupId = groupId;
    this.listObject = listObject;
  }
}

