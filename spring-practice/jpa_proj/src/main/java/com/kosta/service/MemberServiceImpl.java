package com.kosta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.entity.Member;
import com.kosta.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<Member> getAll() throws Exception {
		return memberRepository.findAll();
	}

	@Override
	public void insertMember(Member member) throws Exception {
		memberRepository.save(member);
	}

}
