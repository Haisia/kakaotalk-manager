package com.example.demo.domain.service.kakao.preset;

import com.example.demo.domain.entity.message.common.Message;
import com.example.demo.domain.service.kakao.message.json.commerce.CommerceObject;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import com.example.demo.domain.service.kakao.message.json.list.ListObject;
import com.example.demo.domain.service.kakao.message.json.location.LocationObject;
import com.example.demo.domain.service.kakao.message.json.text.TextObject;

import java.util.List;

public interface MessagePresetService {
  void savePreset(Message message, String template);
  List<FeedObject> getFeedPresetList(Long userId);
  List<ListObject> getListPresetList(Long userId);
  List<LocationObject> getLocationPresetList(Long userId);
  List<CommerceObject> getCommercePresetList(Long userId);
  List<TextObject> getTextPresetList(Long userId);
}
