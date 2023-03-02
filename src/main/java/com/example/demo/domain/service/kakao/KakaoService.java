package com.example.demo.domain.service.kakao;

import com.example.demo.domain.service.kakao.friend.KakaoFriendService;
import com.example.demo.domain.service.kakao.message.KakaoMessageService;
import com.example.demo.domain.service.kakao.oauth.KakaoAuthService;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class KakaoService {

    private final KakaoAuthService authService;
    private final KakaoMessageService messageService;
    private final KakaoFriendService friendService;
}
