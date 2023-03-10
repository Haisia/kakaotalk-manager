package com.example.demo.domain.entity.message.commerce;

import com.example.demo.domain.entity.message.common.Button;
import com.example.demo.domain.entity.message.common.Content;
import com.example.demo.domain.entity.message.common.Message;
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
public class CommerceMessage extends Message {
  @OneToOne(mappedBy = "commerceMessage", cascade = CascadeType.ALL)
  private Content content;
  @OneToOne(mappedBy = "commerceMessage", cascade = CascadeType.ALL)
  private Commerce commerce;
  @OneToMany(mappedBy = "commerceMessage", cascade = CascadeType.ALL)
  private List<Button> buttons;

}
