package com.kosta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.entity.Member;
import com.kosta.repository.MemberRepository;

@Service
public class IMemberService implements MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public List<Member> getAllMembers() throws Exception {
		return memberRepository.findAll();
	}

	@Override
	public void insertMember(Member member) throws Exception {
		memberRepository.save(member);
	}

	@Override
	public void deleteMemberById(int id) throws Exception {
		memberRepository.deleteById(id);
	}

	@Override
	public Member getMemberById(int id) throws Exception {
		Optional<Member> optMember = memberRepository.findById(id);
		Member member = optMember.orElseThrow(() -> new Exception("없는 아이디입니다."));
		return member;
	}

	@Override
	public void updateMemberName(Member member) throws Exception {
		Member originMember = getMemberById(member.getId()); // 기존 멤버를 가져오기
		originMember.setName(member.getName());
		memberRepository.save(originMember);

	}

	@Override
	public List<Member> searchMember(String keyword) throws Exception {
		return memberRepository.findByNameContains(keyword);
	}

}
