package dev.willmakley.graphqlspring.domain;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

@Service
public class PostQueryResolver implements GraphQLQueryResolver {
    private final PostService postService;

    public PostQueryResolver(PostService postService) {
        this.postService = postService;
    }

    public List<PostEntity> postAll( DataFetchingEnvironment environment) {
        DataFetchingFieldSelectionSet s = environment.getSelectionSet();
        List<Specification<PostEntity>> specifications = new ArrayList<>();
        if (s.contains("userByUserId")) {
            return postService.findAll( EnumSet.of( PostService.SubFetch.UserByUserId ) );
        }
        return postService.findAll( Collections.emptySet() );
    }

    public PostEntity postByPostId(Integer id) {
        return postService.findByPostId(id);
    }

    public List<PostEntity> postByUserId(Integer userId) {
        return postService.findByUserId(userId);
    }
}
