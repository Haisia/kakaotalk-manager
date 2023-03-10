package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.commerce.CommerceMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommerceMessageRepository extends JpaRepository<CommerceMessage, Long> {
  List<CommerceMessage> findAllByUserId(Long userId);
}
