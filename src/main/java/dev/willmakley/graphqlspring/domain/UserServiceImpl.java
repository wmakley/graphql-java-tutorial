package dev.willmakley.graphqlspring.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger( getClass() );
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(String fullName, String email, String gender, String dob,
                                 String presentAddress,
                                 String permanentAddress) {
        logger.debug( "createUser" );

        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(fullName);
        userEntity.setEmail(email);
        userEntity.setDob(dob);
        userEntity.setGender(gender);
        userEntity.setPresentAddress(presentAddress);
        userEntity.setPermanentAddress(permanentAddress);

        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findById(Integer id) {
        logger.debug( "findById" );
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        return userEntityOptional.orElse(null);
    }

    @Override
    public List<UserEntity> findAll() {
        logger.debug( "findAll" );
        return userRepository.findAll();
    }
}
