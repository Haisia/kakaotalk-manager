package com.example.demo.web.controller.api;

import com.example.demo.domain.dto.ReservationDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.entity.message.reservation.MessageReservation;
import com.example.demo.domain.service.kakao.reservation.MessageReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@EnableScheduling
@RestController
@RequestMapping("/reservation/message")
public class ReservationMessageApiController {
  private final MessageReservationService messageReservationService;
  @PostMapping("/save/commerce")
  public void saveReservationCommerce(User user, @RequestBody ReservationDto.SaveCommerce saveCommerce){
    MessageReservation messageReservation = new MessageReservation(user, saveCommerce.getCommerceMessage(), saveCommerce.getReservationDateTime());
    messageReservation.getMessage().setPurpose("reservation");
    messageReservation.getMessage().setUser(user);
    messageReservation.setUser(user);

    messageReservationService.saveCommerce(saveCommerce, messageReservation);
  }

  @Scheduled(fixedDelay = 60*1000, initialDelay = 60*1000)
  public void reservationMessageSend() {
    messageReservationService.reservationMessageSend();
  }
}
