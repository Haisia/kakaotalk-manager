package com.example.demo.domain.entity.message.common;

import com.example.demo.domain.entity.message.commerce.CommerceMessage;
import com.example.demo.domain.entity.message.list.ListMessage;
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

  @JoinColumn(name = "list_message")
  @ManyToOne(cascade = CascadeType.ALL)
  @ToString.Exclude
  private ListMessage listMessage;

  @JoinColumn(name = "commerce_message")
  @OneToOne(cascade = CascadeType.ALL)
  @ToString.Exclude
  private CommerceMessage commerceMessage;
}
