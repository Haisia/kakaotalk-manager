package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.reservation.MessageReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageReservationRepository extends MessageReservationCustomRepository, JpaRepository<MessageReservation, Long> {

}
