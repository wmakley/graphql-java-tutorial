package dev.willmakley.graphqlspring.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final Logger logger = LoggerFactory.getLogger( getClass() );
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public PostServiceImpl(
        UserRepository userRepository,
        PostRepository postRepository
    ) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public PostEntity createPost(Integer userId, String title, String description, String postDate) {
        logger.debug( "createPost" );

        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        if(!userEntityOptional.isPresent()){
            throw new RuntimeException("Invalid user provided");
        }

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(title);
        postEntity.setDescription(description);
        postEntity.setPublishedDate(postDate);
        postEntity.setUserId(userEntityOptional.get().getId());

        return postRepository.save(postEntity);
    }

    @Override
    public PostEntity findByPostId(Integer postId) {
        logger.debug( "findByPostId" );
        Optional<PostEntity> postEntityOptional = postRepository.findById(postId);
        return postEntityOptional.orElse(null);
    }

    @Override
    public List<PostEntity> findByUserId(Integer userId) {
        logger.debug( "findByUserId" );
        return postRepository.findAllByUserId(userId);
    }

    @Override
    public List<PostEntity> findAll() {
        logger.debug( "findAll" );
        return postRepository.findAll();
    }

    @Override
    public boolean deletePostById(Integer postId) {
        logger.debug( "deletePostById" );
        Optional<PostEntity> postEntityOptional = postRepository.findById(postId);
        if (!postEntityOptional.isPresent()){
            throw new RuntimeException("Invalid post id provided");
        }
        postRepository.delete(postEntityOptional.get());
        return true;
    }

}
