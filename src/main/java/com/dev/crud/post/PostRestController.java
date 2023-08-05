package com.dev.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
//    private final List<PostDto> postList;
    private final PostService postService;

//    public PostRestController() {
//        this.postList = new ArrayList<>();
//    }
    public PostRestController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    // http://localhost:8080/post
    // POST /post
    // REQUEST_BODY
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    // http://localhost:8080/post
    // GET /post
    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postService.readPostAll();
    }

    // http://localhost:8080/post
    // GET /post/{id}
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post");
        return this.postService.readPost(id);
    }

    // http://localhost:8080/post
    // PUT /post/{id}
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ) {
        this.postService.updatePost(id, postDto);
    }

    // http://localhost:8080/post
    // DELETE /post/{id}
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }
}
