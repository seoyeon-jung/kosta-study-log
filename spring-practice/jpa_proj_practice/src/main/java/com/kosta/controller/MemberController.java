package com.kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.entity.Member;
import com.kosta.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;

	// 전체 멤버 리스트
	@GetMapping("/list")
	public ModelAndView mainPage() throws Exception {
		ModelAndView mav = new ModelAndView("member/list");
		List<Member> memberList = ms.getAllMembers();
		mav.addObject("list", memberList);
		return mav;
	}

	// 멤버 추가
	@GetMapping("/add")
	public ModelAndView addPage() throws Exception {
		ModelAndView mav = new ModelAndView("member/add");
		return mav;
	}

	@PostMapping("/add")
	public String addMember(Member member) throws Exception {
		ms.insertMember(member);
		return "redirect:/list";
	}

	// 멤버 삭제
	@GetMapping("/delete/{id}")
	public String deleteMember(@PathVariable("id") int id) throws Exception {
		ms.deleteMemberById(id);
		return "redirect:/list";
	}

	// 멤버 수정
	@GetMapping("/modify/{id}")
	public String modifyPage(@PathVariable("id") int id, Model model) throws Exception {
		Member member = ms.getMemberById(id);
		model.addAttribute("member", member);
		return "member/add";
	}

	@PostMapping("/modify")
	public String modifyMemberName(Member member) throws Exception {
		ms.updateMemberName(member);
		return "redirect:/list";
	}

	// 멤버 검색하기
	@GetMapping("/search")
	public String searchName(@RequestParam("keyword") String keyword, Model model) throws Exception {
		List<Member> searchResult = ms.searchMember(keyword);
		model.addAttribute("list", searchResult);
		return "member/list";
	}

	// 멤버 정보 보여주기
	@GetMapping("/detail/{id}")
	public ModelAndView detailPage(@PathVariable("id") int id) throws Exception {
		ModelAndView mav = new ModelAndView("member/detail");
		Member member = ms.getMemberById(id);
		mav.addObject("member", member);
		return mav;
	}
}
