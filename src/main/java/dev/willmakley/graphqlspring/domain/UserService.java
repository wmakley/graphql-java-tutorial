package dev.willmakley.graphqlspring.domain;

import java.util.List;

public interface UserService {
    UserEntity createUser(String fullName, String email, String gender, String dob,
                                 String presentAddress,
                                 String permanentAddress);

    UserEntity findById(Integer id);

    List<UserEntity> findAll();
}
