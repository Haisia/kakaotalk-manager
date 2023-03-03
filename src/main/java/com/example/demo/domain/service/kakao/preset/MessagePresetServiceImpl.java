package com.example.demo.domain.service.kakao.preset;

import com.example.demo.domain.entity.message.commerce.Commerce;
import com.example.demo.domain.entity.message.commerce.CommerceMessagePreset;
import com.example.demo.domain.entity.message.common.*;
import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import com.example.demo.domain.entity.message.feed.ItemContent;
import com.example.demo.domain.entity.message.list.ListMessagePreset;
import com.example.demo.domain.entity.message.location.LocationMessagePreset;
import com.example.demo.domain.entity.message.text.TextMessagePreset;
import com.example.demo.domain.repository.*;
import com.example.demo.domain.service.kakao.message.json.commerce.CommerceObject;
import com.example.demo.domain.service.kakao.message.json.feed.FeedObject;
import com.example.demo.domain.service.kakao.message.json.list.ListObject;
import com.example.demo.domain.service.kakao.message.json.location.LocationObject;
import com.example.demo.domain.service.kakao.message.json.text.TextObject;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagePresetServiceImpl implements MessagePresetService{
  private final FeedMessagePresetRepository feedMessagePresetRepository;
  private final ListMessagePresetRepository listMessagePresetRepository;
  private final LocationMessagePresetRepository locationMessagePresetRepository;
  private final CommerceMessagePresetRepository commerceMessagePresetRepository;
  private final TextMessagePresetRepository textMessagePresetRepository;
  private final ButtonRepository buttonRepository;
  private final ContentRepository contentRepository;
  private final CommerceRepository commerceRepository;
  private final ModelMapper modelMapper;
  @Override
  public void savePreset(MessagePreset messagePreset, String template) {
    switch (template) {
      case "feed": createFeedMessagePreset((FeedMessagePreset) messagePreset); break;
      case "list": createListMessagePreset((ListMessagePreset) messagePreset); break;
      case "location": createLocationMessagePreset((LocationMessagePreset) messagePreset); break;
      case "commerce": createCommerceMessagePreset((CommerceMessagePreset) messagePreset); break;
      case "text": createTextMessagePreset((TextMessagePreset) messagePreset); break;
    }
  }

  @Override
  public List<FeedObject> getFeedPresetList(Long userId) {
    List<FeedMessagePreset> findList = feedMessagePresetRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<FeedObject>>() {}.getType());
  }

  @Override
  public List<ListObject> getListPresetList(Long userId) {
    List<ListMessagePreset> findList = listMessagePresetRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<ListObject>>() {}.getType());
  }

  @Override
  public List<LocationObject> getLocationPresetList(Long userId) {
    List<LocationMessagePreset> findList = locationMessagePresetRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<LocationObject>>() {}.getType());
  }

  @Override
  public List<CommerceObject> getCommercePresetList(Long userId) {
    List<CommerceMessagePreset> findList = commerceMessagePresetRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<LocationObject>>() {}.getType());
  }

  @Override
  public List<TextObject> getTextPresetList(Long userId) {
    List<TextMessagePreset> findList = textMessagePresetRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<TextObject>>() {}.getType());
  }

  private void createFeedMessagePreset(FeedMessagePreset feedMessagePreset) {
    Link contentLink = feedMessagePreset.getContent().getLink();
    contentLink.setContent(feedMessagePreset.getContent());

    ItemContent itemContent = feedMessagePreset.getItemContent();
    for (Item item : itemContent.getItems()) {
      item.setItemContent(itemContent);
    }

    feedMessagePreset.getSocial().setFeedMessagePreset(feedMessagePreset);
    for (Button button : feedMessagePreset.getButtons()) {
      button.setFeedMessagePreset(feedMessagePreset);
    }

    feedMessagePresetRepository.save(feedMessagePreset);

    List<Button> buttons = feedMessagePreset.getButtons();
    buttonRepository.saveAll(buttons);

  }

  private void createListMessagePreset(ListMessagePreset listMessagePreset) {
    List<Content> contents = listMessagePreset.getContents();
    for (Content content : contents) {
      content.setListMessagePreset(listMessagePreset);
    }
    contentRepository.saveAll(contents);

    List<Button> buttons = listMessagePreset.getButtons();
    for (Button button : buttons) {
      button.setListMessagePreset(listMessagePreset);
    }
    buttonRepository.saveAll(buttons);

    listMessagePresetRepository.save(listMessagePreset);
  }

  private void createLocationMessagePreset(LocationMessagePreset locationMessagePreset) {
    List<Button> buttons = locationMessagePreset.getButtons();
    for (Button button : buttons) {
      button.setLocationMessagePreset(locationMessagePreset);
    }

    locationMessagePresetRepository.save(locationMessagePreset);

    buttonRepository.saveAll(buttons);
  }

  private void createCommerceMessagePreset(CommerceMessagePreset commerceMessagePreset) {
    commerceMessagePresetRepository.save(commerceMessagePreset);

    Content content = commerceMessagePreset.getContent();
    content.setCommerceMessagePreset(commerceMessagePreset);
    contentRepository.save(content);

    Commerce commerce = commerceMessagePreset.getCommerce();
    commerce.setCommerceMessagePreset(commerceMessagePreset);
    commerceRepository.save(commerce);

    List<Button> buttons = commerceMessagePreset.getButtons();
    for (Button button : buttons) {
      button.setCommerceMessagePreset(commerceMessagePreset);
    }
    buttonRepository.saveAll(buttons);
  }

  private void createTextMessagePreset(TextMessagePreset textMessagePreset) {
    textMessagePresetRepository.save(textMessagePreset);
  }
}
