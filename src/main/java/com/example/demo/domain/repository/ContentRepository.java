package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.common.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {

}
