package com.dev.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
//@RequestMapping("/post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
//    private final List<PostDto> postList;

    private final PostService postService;

//    public PostController() {
//        postList = new ArrayList<>();
//    }
    public PostController(
            @Autowired PostService postService
    ) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
//        this.postList.add(postDto);
        this.postService.createPost(postDto);
    }

    @GetMapping("/read-all")
    public List<PostDto> readPostAll() {
        logger.info("read all");
//        return this.postList;
        return this.postService.readPostAll();
    }

    @GetMapping("/read-one")
    public PostDto readPostOne(@RequestParam("id") int id) {
        logger.info("in read one");
//        return this.postList.get(id);
        return this.postService.readPost(id);
    }

    @PostMapping("/update")
    public void updatePost(@RequestParam("id") int id,
                           @RequestBody PostDto postDto) {
//        PostDto targetPost = this.postList.get(id);
//
//        if(postDto.getTitle() != null) {
//            targetPost.setTitle(postDto.getTitle());
//        }
//        if(postDto.getContent() != null) {
//            targetPost.setTitle(postDto.getContent());
//        }
//        this.postList.set(id, targetPost);
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("/delete")
    public void deletePost(@RequestParam("id") int id) {
//        this.postList.remove(id);
        this.postService.deletePost(id);
    }
}
