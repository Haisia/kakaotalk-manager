package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.list.ListMessagePreset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListMessagePresetRepository extends JpaRepository<ListMessagePreset, Long> {
  List<ListMessagePreset> findAllByUserId(Long userId);
}
