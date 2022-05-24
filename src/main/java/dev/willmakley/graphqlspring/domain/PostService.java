package dev.willmakley.graphqlspring.domain;

import java.util.List;
import java.util.Set;

public interface PostService {
    enum SubFetch {
        UserByUserId
    }

    PostEntity createPost(Integer userId, String title, String description, String postDate);
    PostEntity findByPostId(Integer postId);
    List<PostEntity> findByUserId(Integer userId);
    List<PostEntity> findAll( Set<SubFetch> subFetchSet );

    boolean deletePostById(Integer postId);
}
