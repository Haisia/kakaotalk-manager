package com.example.demo.domain.service.kakao.reservation;

import com.example.demo.domain.dto.ReservationDto;
import com.example.demo.domain.entity.message.reservation.MessageReservation;

public interface MessageReservationService {
  void saveCommerce(ReservationDto.SaveCommerce saveCommerce, MessageReservation messageReservation);
  void reservationMessageSend();
}
