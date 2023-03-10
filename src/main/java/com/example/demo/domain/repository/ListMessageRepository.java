package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.list.ListMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListMessageRepository extends JpaRepository<ListMessage, Long> {
  List<ListMessage> findAllByUserId(Long userId);
}
