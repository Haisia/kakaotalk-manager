package com.example.demo.domain.service.kakao.reservation;

import com.example.demo.domain.dto.ReservationDto;
import com.example.demo.domain.entity.message.reservation.MessageReservation;
import com.example.demo.domain.repository.CommerceMessageRepository;
import com.example.demo.domain.repository.MessageReservationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MessageReservationServiceImpl implements MessageReservationService {
  private final MessageReservationRepository messageReservationRepository;
  private final CommerceMessageRepository commerceMessageRepository;

  public void saveCommerce(ReservationDto.SaveCommerce saveCommerce, MessageReservation messageReservation) {
    commerceMessageRepository.save(saveCommerce.getCommerceMessage());
    messageReservationRepository.save(messageReservation);
  }

  @Transactional
  public void reservationMessageSend(){
    List<MessageReservation> findList = messageReservationRepository.findMessageReservationListToSend();
    if (findList.size() == 0) return;

    // todo: 생각해보니까 예약메세지는 카카오 토큰만료문제로 카카오톡에서 기능을 제공하지 않는 한 구현이 불가능함 ㅠㅠ
    // 그래서 콘솔창에 해당 메세지를 띄우는걸로 대체 함
    for (MessageReservation messageReservation : findList) {
      System.out.println("예약메세지 " + messageReservation.getId() + "를 송신합니다.");
      messageReservation.setDoYn("Y");
    }
  }
}
