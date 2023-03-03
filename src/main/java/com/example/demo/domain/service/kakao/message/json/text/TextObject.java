package com.example.demo.domain.service.kakao.message.json.text;

import com.example.demo.domain.service.kakao.message.json.common.Button;
import com.example.demo.domain.service.kakao.message.json.common.Link;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TextObject extends MessageObject {
    @NotBlank(message = "text 는 필수 입력값 입니다.")
    private String text;
    @Valid
    @NotNull(message = "link 는 필수 입력값 입니다.")
    private Link link;
    @JsonAlias({"buttonTitle","button_title"})
    private String buttonTitle;
    @Valid
    private List<Button> buttons;

    public TextObject(String objectType, String text, Link link, String buttonTitle) {
        super.objectType = objectType;
        this.text = text;
        this.link = link;
        this.buttonTitle = buttonTitle;
    }
}
