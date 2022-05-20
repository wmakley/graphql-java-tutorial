package dev.willmakley.graphqlspring.domain;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryResolver implements GraphQLQueryResolver {
    private final UserService userService;

    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    public List<UserEntity> userAll() {
        return userService.findAll();
    }
    public UserEntity userById(Integer id) {
        return userService.findById(id);
    }
}
