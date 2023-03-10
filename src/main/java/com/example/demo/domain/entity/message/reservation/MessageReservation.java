package com.example.demo.domain.entity.message.reservation;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.message.common.Message;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class MessageReservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JoinColumn(name = "user_id")
  @ManyToOne
  private User user;

  @JoinColumn(name = "message_id")
  @OneToOne
  private Message message;

  private LocalDateTime reservationDateTime;
  private String doYn;

  public MessageReservation(User user, Message message, LocalDateTime reservationDateTime) {
    this.user = user;
    this.message = message;
    this.reservationDateTime = reservationDateTime;
    this.doYn = "N";
  }
}
