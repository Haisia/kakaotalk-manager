package com.example.demo.domain.entity.message.commerce;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
public class Commerce {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long regularPrice;
  private Long discountPrice;
  private Long discountRate;

  @JoinColumn(name = "comerce_message_id")
  @OneToOne(cascade = CascadeType.ALL)
  @ToString.Exclude
  private CommerceMessage commerceMessage;
}
