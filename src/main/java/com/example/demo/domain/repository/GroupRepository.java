package com.example.demo.domain.repository;

import com.example.demo.domain.dto.GroupDto;
import com.example.demo.domain.entity.Group;
import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends GroupCustomRepository, JpaRepository<Group, Long> {
  Optional<Group> findByIdAndUserId(Long id, Long userId);
  List<Group> findAllByUserId(Long userId);

}
