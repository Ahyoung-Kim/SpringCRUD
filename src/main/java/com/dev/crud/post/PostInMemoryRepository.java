package com.dev.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostInMemoryRepository implements PostRepository {
    private static final Logger logger = LoggerFactory.getLogger(PostInMemoryRepository.class);
    private final List<PostDto> postList;

    public PostInMemoryRepository() {
        this.postList = new ArrayList<>();
    }

    @Override
    public List<PostDto> findAll() {
        return this.postList;
    }

    @Override
    public PostDto findById(int id) {
        return this.postList.get(id);
    }

    @Override
    public boolean save(PostDto dto) {
        return this.postList.add(dto);
    }

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }

    @Override
    public boolean update(int id, PostDto dto) {
        PostDto targetPost = this.postList.get(id);

        if(dto.getTitle() != null) {
            targetPost.setTitle(dto.getTitle());
        }
        if(dto.getContent() != null) {
            targetPost.setContent(dto.getContent());
        }

        this.postList.set(id, targetPost);
        return true;
    }
}
