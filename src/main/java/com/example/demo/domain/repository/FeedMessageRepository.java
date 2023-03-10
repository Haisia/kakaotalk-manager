package com.example.demo.domain.repository;

import com.example.demo.domain.entity.message.feed.FeedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FeedMessageRepository extends JpaRepository<FeedMessage,Long>, FeedMessageCustomRepository {
  List<FeedMessage> findAllByUserId(Long userId);
  Optional<FeedMessage> findByIdAndUserId(Long id, Long userId);

}
