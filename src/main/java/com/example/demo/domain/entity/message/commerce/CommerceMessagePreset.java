package com.example.demo.domain.entity.message.commerce;

import com.example.demo.domain.entity.message.common.Button;
import com.example.demo.domain.entity.message.common.Content;
import com.example.demo.domain.entity.message.common.MessagePreset;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorValue("commerce")
@NoArgsConstructor
public class CommerceMessagePreset extends MessagePreset {
  @OneToOne(mappedBy = "commerceMessagePreset", cascade = CascadeType.ALL)
  private Content content;
  @OneToOne(mappedBy = "commerceMessagePreset", cascade = CascadeType.ALL)
  private Commerce commerce;
  @OneToMany(mappedBy = "commerceMessagePreset", cascade = CascadeType.ALL)
  private List<Button> buttons;

}
