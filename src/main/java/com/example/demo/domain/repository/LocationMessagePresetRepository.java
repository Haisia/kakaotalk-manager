package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.location.LocationMessagePreset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationMessagePresetRepository extends JpaRepository<LocationMessagePreset, Long> {
  List<LocationMessagePreset> findAllByUserId(Long userId);
}
