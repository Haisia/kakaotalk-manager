package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.commerce.CommerceMessagePreset;
import com.example.demo.domain.entity.message.feed.FeedMessagePreset;
import com.example.demo.domain.entity.message.list.ListMessagePreset;
import com.example.demo.domain.entity.message.location.LocationMessagePreset;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Entity
public class Button {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "link_id")
  @ToString.Exclude
  private Link link;

  @ManyToOne
  @JoinColumn(name = "feed_message_preset_id")
  @ToString.Exclude
  private FeedMessagePreset feedMessagePreset;

  @ManyToOne
  @JoinColumn(name = "list_message_preset_id")
  @ToString.Exclude
  private ListMessagePreset listMessagePreset;

  @ManyToOne
  @JoinColumn(name = "location_message_preset_id")
  @ToString.Exclude
  private LocationMessagePreset locationMessagePreset;

  @ManyToOne
  @JoinColumn(name = "commerce_message_preset_id")
  @ToString.Exclude
  private CommerceMessagePreset commerceMessagePreset;

}
