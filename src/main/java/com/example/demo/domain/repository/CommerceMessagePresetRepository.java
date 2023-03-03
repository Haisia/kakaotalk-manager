package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.commerce.CommerceMessagePreset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommerceMessagePresetRepository extends JpaRepository<CommerceMessagePreset, Long> {
  List<CommerceMessagePreset> findAllByUserId(Long userId);
}
