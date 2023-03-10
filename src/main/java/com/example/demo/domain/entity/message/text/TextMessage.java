package com.example.demo.domain.entity.message.text;

import com.example.demo.domain.entity.message.common.Link;
import com.example.demo.domain.entity.message.common.Message;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@DiscriminatorValue("text")
public class TextMessage extends Message {
  private String text;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "link_id")
  @ToString.Exclude
  private Link link;
  private String buttonTitle;
}
