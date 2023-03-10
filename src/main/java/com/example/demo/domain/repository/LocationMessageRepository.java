package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.location.LocationMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationMessageRepository extends JpaRepository<LocationMessage, Long> {
  List<LocationMessage> findAllByUserId(Long userId);
}
