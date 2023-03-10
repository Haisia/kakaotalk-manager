package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.text.TextMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextMessageRepository extends JpaRepository<TextMessage, Long> {
  List<TextMessage> findAllByUserId(Long userId);
}
