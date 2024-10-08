package com.kosta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.entity.Member;

// <T, ID> -> <객체, 기본키>
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	// name으로 해당 회원이 추가되는지 확인하기 위해 새로 추가
	Optional<Member> findByName(String name);

	// 검색어를 입력해서 검색이 되는지 확인하기 위해 추가
	List<Member> findByNameContains(String keyword);
}
