package dev.willmakley.graphqlspring.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
    List<PostEntity> findAllByUserId(Integer userId);

    @Query( "select p from PostEntity p join fetch p.userByUserId" )
    List<PostEntity> findAllIncludingUsers();
}
