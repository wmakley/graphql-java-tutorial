package dev.willmakley.graphqlspring.domain;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostQueryResolver implements GraphQLQueryResolver {
    private PostService postService;

    public PostQueryResolver(PostService postService) {
        this.postService = postService;
    }

    public List<PostEntity> postAll() {
        return postService.findAll();
    }

    public PostEntity postByPostId(Integer id) {
        return postService.findByPostId(id);
    }

    public List<PostEntity> postByUserId(Integer userId) {
        return postService.findByUserId(userId);
    }
}
