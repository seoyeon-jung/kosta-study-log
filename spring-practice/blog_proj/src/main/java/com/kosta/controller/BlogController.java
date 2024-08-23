package com.kosta.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.entity.Article;
import com.kosta.entity.User;
import com.kosta.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/blog/*")
@RequiredArgsConstructor
public class BlogController {
	private final BlogService blogService;

	// 블로그 글 추가
	@GetMapping("/add")
	public String addPage() throws Exception {
		return "/blog/form";
	}

	@PostMapping("/add")
	public String addArticle(Article article, @AuthenticationPrincipal User user) throws Exception {
		blogService.save(article, user);
		return "redirect:/blog/list";
	}

	// 블로그 글 전체 리스트
	@GetMapping("/list")
	public String listPage(@RequestParam(required = false, name = "keyword") String keyword,
			@RequestParam(required = false, name = "order") String order, Model model) throws Exception {
		List<Article> articleList;

		if (keyword != null || order != null) {
			articleList = blogService.searchAndOrder(keyword, order);
		} else {
			articleList = blogService.findAll();
		}
		model.addAttribute("list", articleList);

		return "/blog/list";
	}

	// 블로그 글 디테일 페이지
	@GetMapping("/detail/{id}")
	public String detailPage(@PathVariable("id") Long id, Model model) {
		try {
			Article article = blogService.findById(id);
			model.addAttribute("article", article);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", e.getMessage());
			return "error";
		}
		return "/blog/detail";
	}

	// 블로그 글 삭제
	@DeleteMapping("/delete/{id}")
	public String deleteArticle(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal User user) {
		try {
			blogService.deleteById(id, user);
			return "redirect:/blog/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", e.getMessage());
			return "error";
		}
	}

	// 블로그 글 수정
	@GetMapping("/modify/{id}")
	public String modifyPage(@PathVariable("id") Long id, Model model) {
		try {
			Article article = blogService.findById(id);
			model.addAttribute("article", article);
			return "/blog/form";
		} catch (Exception e) {
			model.addAttribute("errMsg", e.getMessage());
			return "error";
		}
	}

	@PatchMapping("/modify")
	public String modifyArticle(Article article, Model model, @AuthenticationPrincipal User user) {
		try {
			blogService.update(article, user);
			return "redirect:/blog/detail/" + article.getId();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errMsg", e.getMessage());
			return "error";
		}
	}
}
