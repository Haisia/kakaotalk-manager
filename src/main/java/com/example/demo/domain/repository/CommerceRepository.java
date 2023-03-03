package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.commerce.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommerceRepository extends JpaRepository<Commerce, Long> {
}
