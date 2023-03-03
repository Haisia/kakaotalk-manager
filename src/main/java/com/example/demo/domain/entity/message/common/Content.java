package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.commerce.CommerceMessagePreset;
import com.example.demo.domain.entity.message.list.ListMessagePreset;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Content {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;
  @Column(name = "description")
  private String description;
  @Column(name = "image_url")
  private String imageUrl;
  @Column(name = "image_width")
  private Long imageWidth;
  @Column(name = "image_height")
  private Long imageHeight;

  @OneToOne(mappedBy = "content", cascade = CascadeType.ALL)
  private Link link;

  @JoinColumn(name = "list_message_preset")
  @ManyToOne(cascade = CascadeType.ALL)
  @ToString.Exclude
  private ListMessagePreset listMessagePreset;

  @JoinColumn(name = "commerce_message_preset")
  @OneToOne(cascade = CascadeType.ALL)
  @ToString.Exclude
  private CommerceMessagePreset commerceMessagePreset;
}
