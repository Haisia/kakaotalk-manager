package com.example.demo.web.controller.api;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.message.commerce.CommerceMessage;
import com.example.demo.domain.entity.message.feed.FeedMessage;
import com.example.demo.domain.entity.message.list.ListMessage;
import com.example.demo.domain.entity.message.location.LocationMessage;
import com.example.demo.domain.entity.message.text.TextMessage;
import com.example.demo.domain.service.kakao.message.json.commerce.CommerceObject;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import com.example.demo.domain.service.kakao.message.json.list.ListObject;
import com.example.demo.domain.service.kakao.message.json.location.LocationObject;
import com.example.demo.domain.service.kakao.message.json.text.TextObject;
import com.example.demo.domain.service.kakao.preset.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/preset")
public class PresetApiController {
  private final MessageService messageService;

  @PostMapping("/feed/save")
  public HttpEntity<?> saveFeedPreset(User user, @RequestBody FeedMessage feedMessage) {
    feedMessage.setUser(user);
    feedMessage.setPurpose("preset");

    messageService.savePreset(feedMessage, "feed");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/feed/list")
  public List<FeedObject> getFeedPreset(User user) {
    return messageService.getFeedPresetList(user.getId());
  }

  @PostMapping("/list/save")
  public HttpEntity<?> saveListPreset(User user, @RequestBody ListMessage listMessage) {
    listMessage.setUser(user);
    listMessage.setPurpose("preset");

    messageService.savePreset(listMessage, "list");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/list/list")
  public List<ListObject> getListPreset(User user) {
    return messageService.getListPresetList(user.getId());
  }

  @PostMapping("/location/save")
  public HttpEntity<?> saveLocationPreset(User user, @RequestBody LocationMessage locationMessage) {
    locationMessage.setUser(user);
    locationMessage.setPurpose("preset");

    messageService.savePreset(locationMessage, "location");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/location/list")
  public List<LocationObject> getLocationPreset(User user) {
    return messageService.getLocationPresetList(user.getId());
  }

  @PostMapping("/commerce/save")
  public HttpEntity<?> saveCommercePreset(User user, @RequestBody CommerceMessage commerceMessage) {
    commerceMessage.setUser(user);
    commerceMessage.setPurpose("preset");

    messageService.savePreset(commerceMessage, "commerce");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/commerce/list")
  public List<CommerceObject> getCommercePresetList(User user) {
    return messageService.getCommercePresetList(user.getId());
  }

  @PostMapping("/text/save")
  public HttpEntity<?> saveTextPreset(User user, @RequestBody TextMessage textMessage) {
    textMessage.setUser(user);
    textMessage.setPurpose("preset");

    messageService.savePreset(textMessage, "text");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/text/list")
  public List<TextObject> getTextPresetList(User user) {
    return messageService.getTextPresetList(user.getId());
  }

}
