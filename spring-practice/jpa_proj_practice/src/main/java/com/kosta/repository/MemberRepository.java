package com.kosta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	// name으로 해당 회원이 추가되는지 확인
	Optional<Member> findByName(String name);

	// 검색어를 입력해서 검색되는지 확인
	List<Member> findByNameContains(String keyword);
}
