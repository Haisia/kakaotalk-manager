package com.example.demo.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FeedMessageCustomRepositoryImpl implements FeedMessageCustomRepository{
  private final EntityManager em;
  private final JPAQueryFactory jpaQueryFactory;
//  public List<feedMessage> findByUserId(Long userId){
//    jpaQueryFactory.select(Projections.constructor(FeedObject.class, content, itemContent, social, button)){
//    return null;
//  }

}
