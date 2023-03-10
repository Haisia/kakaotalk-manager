package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.reservation.MessageReservation;

import java.util.List;

public interface MessageReservationCustomRepository {
  List<MessageReservation> findMessageReservationListToSend();
}
