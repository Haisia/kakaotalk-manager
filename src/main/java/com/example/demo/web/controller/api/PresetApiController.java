package com.example.demo.web.controller.api;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.message.commerce.CommerceMessagePreset;
import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import com.example.demo.domain.entity.message.list.ListMessagePreset;
import com.example.demo.domain.entity.message.location.LocationMessagePreset;
import com.example.demo.domain.entity.message.text.TextMessagePreset;
import com.example.demo.domain.service.kakao.message.json.commerce.CommerceObject;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import com.example.demo.domain.service.kakao.message.json.list.ListObject;
import com.example.demo.domain.service.kakao.message.json.location.LocationObject;
import com.example.demo.domain.service.kakao.message.json.text.TextObject;
import com.example.demo.domain.service.kakao.preset.MessagePresetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/preset")
public class PresetApiController {
  private final MessagePresetService messagePresetService;

  @PostMapping("/feed/save")
  public HttpEntity<?> saveFeedPreset(User user, @RequestBody FeedMessagePreset feedMessagePreset) {
    feedMessagePreset.setUser(user);
    messagePresetService.savePreset(feedMessagePreset, "feed");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/feed/list")
  public List<FeedObject> getFeedPreset(User user) {
    return messagePresetService.getFeedPresetList(user.getId());
  }

  @PostMapping("/list/save")
  public HttpEntity<?> saveListPreset(User user, @RequestBody ListMessagePreset listMessagePreset) {
    listMessagePreset.setUser(user);
    messagePresetService.savePreset(listMessagePreset, "list");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/list/list")
  public List<ListObject> getListPreset(User user) {
    return messagePresetService.getListPresetList(user.getId());
  }

  @PostMapping("/location/save")
  public HttpEntity<?> saveLocationPreset(User user, @RequestBody LocationMessagePreset locationMessagePreset) {
    locationMessagePreset.setUser(user);
    messagePresetService.savePreset(locationMessagePreset, "location");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/location/list")
  public List<LocationObject> getLocationPreset(User user) {
    return messagePresetService.getLocationPresetList(user.getId());
  }

  @PostMapping("/commerce/save")
  public HttpEntity<?> saveCommercePreset(User user, @RequestBody CommerceMessagePreset commerceMessagePreset) {
    commerceMessagePreset.setUser(user);
    messagePresetService.savePreset(commerceMessagePreset, "commerce");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/commerce/list")
  public List<CommerceObject> getCommercePresetList(User user) {
    return messagePresetService.getCommercePresetList(user.getId());
  }

  @PostMapping("/text/save")
  public HttpEntity<?> saveTextPreset(User user, @RequestBody TextMessagePreset textMessagePreset) {
    textMessagePreset.setUser(user);
    messagePresetService.savePreset(textMessagePreset, "text");
    return ResponseEntity.ok().build();
  }

  @GetMapping("/text/list")
  public List<TextObject> getTextPresetList(User user) {
    return messagePresetService.getTextPresetList(user.getId());
  }

}
