package com.feign.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feign.practice.client.PostClient;
import com.feign.practice.dto.Post;

@RestController
public class PostController {

	@Autowired
	private PostClient postClient;
	 
	@GetMapping("/posts")
	public List<Post> getPosts() {
		return postClient.getPosts();
	}
	
	@PostMapping("/posts")
	public Post savePosts(@RequestBody Post posts) {
		return postClient.savePosts(posts);
	}
	
	@GetMapping("/posts/{id}")
	public Post getById(@PathVariable Integer id) {
		return postClient.getById(id);
	}
	
	@PutMapping("/posts/{id}")
	public Post editPost(@PathVariable Integer id, @RequestBody Post post) {
		return postClient.editPost(id, post);
	}
	
	@DeleteMapping("/posts/{id}")
	public String deletePost(@PathVariable Integer id) {
		postClient.deletePost(id);
		return "deleted";
	}
}
