package com.feign.practice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.feign.practice.dto.Post;

@FeignClient(url="https://jsonplaceholder.typicode.com", name="Post-Client")
public interface PostClient {

	@GetMapping("/posts")
	public List<Post> getPosts();
	
	@PostMapping("/posts")
	public Post savePosts(Post posts);

	@GetMapping("/posts/{id}")
	public Post getById(@PathVariable Integer id);
	
	@PutMapping("/posts/{id}")
	public Post editPost(@PathVariable Integer id, Post post);

	@DeleteMapping("/posts/{id}")
	public void deletePost(@PathVariable Integer id);
}
