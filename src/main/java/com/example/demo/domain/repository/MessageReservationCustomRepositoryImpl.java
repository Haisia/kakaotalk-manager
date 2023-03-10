package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.reservation.MessageReservation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo.domain.entity.message.reservation.QMessageReservation.*;

@RequiredArgsConstructor
@Repository
public class MessageReservationCustomRepositoryImpl implements MessageReservationCustomRepository{
  private final JPAQueryFactory jpaQueryFactory;
  public List<MessageReservation> findMessageReservationListToSend() {
    return jpaQueryFactory.select(messageReservation)
            .from(messageReservation)
            .where(messageReservation.reservationDateTime.before(LocalDateTime.now())
                    .and(messageReservation.doYn.eq("N")))
            .fetch();
  }
}
