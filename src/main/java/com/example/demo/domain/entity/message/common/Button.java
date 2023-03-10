package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.commerce.CommerceMessage;
import com.example.demo.domain.entity.message.feed.FeedMessage;
import com.example.demo.domain.entity.message.list.ListMessage;
import com.example.demo.domain.entity.message.location.LocationMessage;
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
  @JoinColumn(name = "feed_message_id")
  @ToString.Exclude
  private FeedMessage feedMessage;

  @ManyToOne
  @JoinColumn(name = "list_message_id")
  @ToString.Exclude
  private ListMessage listMessage;

  @ManyToOne
  @JoinColumn(name = "location_message_id")
  @ToString.Exclude
  private LocationMessage locationMessage;

  @ManyToOne
  @JoinColumn(name = "commerce_message_id")
  @ToString.Exclude
  private CommerceMessage commerceMessage;

}
