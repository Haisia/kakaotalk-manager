package com.example.demo.domain.entity.message.location;

import com.example.demo.domain.entity.message.common.Button;
import com.example.demo.domain.entity.message.common.Content;
import com.example.demo.domain.entity.message.common.MessagePreset;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue("location")
public class LocationMessagePreset extends MessagePreset {
  @JoinColumn(name = "content_id")
  @OneToOne(cascade = CascadeType.ALL)
  @ToString.Exclude
  private Content content;
  @OneToMany(mappedBy = "locationMessagePreset")
  private List<Button> buttons;
  private String address;
  private String addressTitle;
}
