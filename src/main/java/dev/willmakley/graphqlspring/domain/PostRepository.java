package dev.willmakley.graphqlspring.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findAllByUserId(Integer userId);
}
