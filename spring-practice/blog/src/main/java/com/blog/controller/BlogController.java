package com.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.Post;
import com.blog.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog/*")
public class BlogController {
	private final BlogService blogService;

	// 블로그 글 전체 리스트
	// 글 검색하기
	@GetMapping("/list")
	public String mainPage(@RequestParam(required = false, name = "keyword") String keyword,
			@RequestParam(required = false, name = "order") String order, Model model) throws Exception {
		List<Post> postList;

		if (keyword != null || order != null) {
			postList = blogService.searchAndOrder(keyword, order);
		} else {
			postList = blogService.getAllList();
		}
		model.addAttribute("list", postList);
		return "main";
	}

	// 글 작성하기
	@GetMapping("/post")
	public String postPage() throws Exception {
		return "form";
	}

	@PostMapping("/post")
	public String addPost(Post post) throws Exception {
		blogService.addPost(post);
		return "redirect:/blog/list";
	}

	// 블로그 글 detail page
	@GetMapping("/detail/{id}")
	public String detailPage(@PathVariable("id") Long id, Model model) throws Exception {
		try {
			Post post = blogService.findPostById(id);
			model.addAttribute("post", post);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "error";
		}
		return "detail";
	}

	// 글 삭제하기
	@DeleteMapping("/delete/{id}")
	public String deletePost(@PathVariable("id") Long id, Model model) {
		try {
			blogService.deletePostById(id);
			return "redirect:/blog/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	// 글 수정하기
	@GetMapping("/modify/{id}")
	public String modifyPage(@PathVariable("id") Long id, Model model) throws Exception {
		try {
			Post post = blogService.findPostById(id);
			model.addAttribute("post", post);
			return "form";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

	@PatchMapping("/modify")
	public String modifyPost(Post post, Model model) throws Exception {
		try {
			blogService.updatePost(post);
			return "redirect:/blog/detail/" + post.getId();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "error";
		}
	}

}
