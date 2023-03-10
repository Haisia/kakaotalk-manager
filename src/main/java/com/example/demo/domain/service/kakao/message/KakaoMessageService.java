package com.example.demo.domain.service.kakao.message;

import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.GroupRepository;
import com.example.demo.domain.service.kakao.message.json.SendMessageRequest;
import com.example.demo.domain.service.kakao.message.json.SendMessageResponse;
import com.example.demo.domain.service.kakao.message.json.common.MessageObject;
import com.example.demo.domain.service.kakao.message.json.common.SendMessageParam;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoMessageService {
  private static final int MAXIMUM_RECEIVER_PER_ONETIME = 5;
  private final GroupRepository groupRepository;

  /**
   * SendMessageParam 의 GroupId 에 해당하는
   * 전원에게 메세지를 보냄.
   */
  public void sendMessage(User user, SendMessageParam sendMessageParam, MessageObject messageObject, String template) {
    Long groupId = sendMessageParam.getGroupId();
    Group group = groupRepository.findById(groupId).orElseThrow();

    validation(user, messageObject, group, template);

    List<SendMessageRequest> sendMessageRequestList = getSendMessageRequestList(group, messageObject);
    for (SendMessageRequest sendMessageRequest : sendMessageRequestList) {
      messageSendApiCall(user, sendMessageRequest);
    }
  }

  private List<SendMessageRequest> getSendMessageRequestList(Group group, MessageObject message) {
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    List<String> receiver = group.getGroupMemberList()
                    .stream()
                    .map(groupMember -> groupMember.getFriend().getUuid())
                    .toList();

    List<String> receiverUuid = new ArrayList<>();
    List<SendMessageRequest> result = new ArrayList<>();
    for (int i = 0; i < receiver.size(); i++) {
      receiverUuid.add(receiver.get(i));

      if (receiverUuid.size() >= MAXIMUM_RECEIVER_PER_ONETIME || i == receiver.size() - 1) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(gson.toJson(receiverUuid), gson.toJson(message));
        result.add(sendMessageRequest);
        receiverUuid.clear();
      }
    }
    return result;
  }

  private void messageSendApiCall(User who, SendMessageRequest sendMessageRequest) {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("receiver_uuids", sendMessageRequest.getReceiverUuids());
    params.add("template_object", sendMessageRequest.getTemplateObject());

    WebClient webClient = WebClient.builder()
            .baseUrl("https://kapi.kakao.com/v1/api/talk/friends/message/default/send")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + who.getAccessToken())
            .build();

    webClient.post()
            .body(BodyInserters.fromValue(params))
            .retrieve()
            .onStatus(status -> status.value() == HttpStatus.BAD_REQUEST.value() || status.value() == HttpStatus.UNAUTHORIZED.value(),
                    response -> Mono.error(RuntimeException::new))
            .bodyToMono(SendMessageResponse.class)
            .block();
  }

  /**
   * 검증
   * 1. 호출된 컨트롤러와 MessageObject 의 object_type 파라미터가 일치하는가?
   * 2. 요청한 유저가 group 의 소유자인가?
   */
  private void validation(User user, MessageObject messageObject, Group group, String template) {
    if (!messageObject.objectType.equals(template)) throw new IllegalArgumentException("옳바르지 않은 템플릿입니다.");
    if (group.getUser() != user) throw new IllegalCallerException("해당 그룹의 소유자가 아닙니다.");
  }

}
