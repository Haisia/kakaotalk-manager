package com.example.demo.domain.entity.message.list;

import com.example.demo.domain.entity.message.common.Button;
import com.example.demo.domain.entity.message.common.Content;
import com.example.demo.domain.entity.message.common.Link;
import com.example.demo.domain.entity.message.common.Message;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue("list")
public class ListMessage extends Message {

  private String headerTitle;

  @JoinColumn(name = "header_link_id")
  @OneToOne(cascade = CascadeType.ALL)
  @ToString.Exclude
  private Link headerLink;

  @OneToMany(mappedBy = "listMessage")
  private List<Content> contents;

  @OneToMany(mappedBy = "listMessage")
  private List<Button> buttons;
}
