package com.example.demo.domain.service.kakao.preset;

import com.example.demo.domain.entity.message.commerce.Commerce;
import com.example.demo.domain.entity.message.commerce.CommerceMessage;
import com.example.demo.domain.entity.message.common.*;
import com.example.demo.domain.entity.message.feed.FeedMessage;
import com.example.demo.domain.entity.message.feed.ItemContent;
import com.example.demo.domain.entity.message.list.ListMessage;
import com.example.demo.domain.entity.message.location.LocationMessage;
import com.example.demo.domain.entity.message.text.TextMessage;
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
public class MessageServiceImpl implements MessageService{
  private final FeedMessageRepository feedMessageRepository;
  private final ListMessageRepository listMessageRepository;
  private final LocationMessageRepository locationMessageRepository;
  private final CommercemessageRepository commercemessageRepository;
  private final TextMessageRepository textMessageRepository;
  private final ButtonRepository buttonRepository;
  private final ContentRepository contentRepository;
  private final CommerceRepository commerceRepository;
  private final ModelMapper modelMapper;
  @Override
  public void savePreset(Message message, String template) {
    switch (template) {
      case "feed": createfeedMessage((FeedMessage) message); break;
      case "list": createlistMessage((ListMessage) message); break;
      case "location": createlocationMessage((LocationMessage) message); break;
      case "commerce": createCommercemessage((CommerceMessage) message); break;
      case "text": createtextMessage((TextMessage) message); break;
    }
  }

  @Override
  public List<FeedObject> getFeedPresetList(Long userId) {
    List<FeedMessage> findList = feedMessageRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<FeedObject>>() {}.getType());
  }

  @Override
  public List<ListObject> getListPresetList(Long userId) {
    List<ListMessage> findList = listMessageRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<ListObject>>() {}.getType());
  }

  @Override
  public List<LocationObject> getLocationPresetList(Long userId) {
    List<LocationMessage> findList = locationMessageRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<LocationObject>>() {}.getType());
  }

  @Override
  public List<CommerceObject> getCommercePresetList(Long userId) {
    List<CommerceMessage> findList = commercemessageRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<LocationObject>>() {}.getType());
  }

  @Override
  public List<TextObject> getTextPresetList(Long userId) {
    List<TextMessage> findList = textMessageRepository.findAllByUserId(userId);
    return modelMapper.map(findList, new TypeToken<List<TextObject>>() {}.getType());
  }

  private void createfeedMessage(FeedMessage feedMessage) {
    Link contentLink = feedMessage.getContent().getLink();
    contentLink.setContent(feedMessage.getContent());

    ItemContent itemContent = feedMessage.getItemContent();
    for (Item item : itemContent.getItems()) {
      item.setItemContent(itemContent);
    }

    feedMessage.getSocial().setFeedMessage(feedMessage);
    for (Button button : feedMessage.getButtons()) {
      button.setFeedMessage(feedMessage);
    }

    feedMessageRepository.save(feedMessage);

    List<Button> buttons = feedMessage.getButtons();
    buttonRepository.saveAll(buttons);

  }

  private void createlistMessage(ListMessage listMessage) {
    List<Content> contents = listMessage.getContents();
    for (Content content : contents) {
      content.setListMessage(listMessage);
    }
    contentRepository.saveAll(contents);

    List<Button> buttons = listMessage.getButtons();
    for (Button button : buttons) {
      button.setListMessage(listMessage);
    }
    buttonRepository.saveAll(buttons);

    listMessageRepository.save(listMessage);
  }

  private void createlocationMessage(LocationMessage locationMessage) {
    List<Button> buttons = locationMessage.getButtons();
    for (Button button : buttons) {
      button.setLocationMessage(locationMessage);
    }

    locationMessageRepository.save(locationMessage);

    buttonRepository.saveAll(buttons);
  }

  private void createCommercemessage(CommerceMessage commerceMessage) {
    commercemessageRepository.save(commerceMessage);

    Content content = commerceMessage.getContent();
    content.setCommerceMessage(commerceMessage);
    contentRepository.save(content);

    Commerce commerce = commerceMessage.getCommerce();
    commerce.setCommerceMessage(commerceMessage);
    commerceRepository.save(commerce);

    List<Button> buttons = commerceMessage.getButtons();
    for (Button button : buttons) {
      button.setCommerceMessage(commerceMessage);
    }
    buttonRepository.saveAll(buttons);
  }

  private void createtextMessage(TextMessage textMessage) {
    textMessageRepository.save(textMessage);
  }
}
