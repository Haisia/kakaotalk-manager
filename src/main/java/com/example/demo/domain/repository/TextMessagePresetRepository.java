package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.text.TextMessagePreset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TextMessagePresetRepository extends JpaRepository<TextMessagePreset, Long> {
  List<TextMessagePreset> findAllByUserId(Long userId);
}
