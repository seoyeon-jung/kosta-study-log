package com.kosta;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.kosta.entity.Member;
import com.kosta.repository.MemberRepository;

@DataJpaTest // JPA test임을 지정 (transactional을 포함하고 있음)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실제 DB로 테스트한다는 의미
public class MemberRepositoryTest {
	@Autowired
	MemberRepository memberRepository;

	@DisplayName("전체 회원 조회")
	@Sql("/data.sql") // 테스트 실행 전에 SQL문 실행
	@Test
	public void getAllMembers() {
		List<Member> allMembers = memberRepository.findAll();
		for (Member m : allMembers) {
			System.out.println(m);
		}
		assertThat(allMembers.size()).isEqualTo(3);
	}

	@DisplayName("특정 회원 조회")
	@Sql("/data.sql")
	@Test
	public void getMemberById() {
		Optional<Member> optionalMember = memberRepository.findById(2);
		Member member = optionalMember.get();
		System.out.println(member);
		assertThat(member.getName()).isEqualTo("도우너");
	}

	@DisplayName("회원 추가")
	@Sql("/data.sql")
	@Test
	public void insertMember() {
		Member member = new Member();
		member.setId(8);
		member.setName("카리나");
		Member savedMember = memberRepository.save(member);
		System.out.println(savedMember);
		assertThat(member).isEqualTo(memberRepository.findByName("카리나").get());
	}

	@DisplayName("특정 회원 삭제")
	@Sql("/data.sql")
	@Test
	public void deleteMember() {
		memberRepository.deleteById(3);
		assertThat(memberRepository.count()).isEqualTo(2);
	}

	@DisplayName("특정 회원 이름 수정")
	@Sql("/data.sql")
	@Test
	// @Transactional // 업데이트 기능을 위해 사용한다 (여기서는 굳이 쓰지 않아도 DateJpaTest에 포함되어있다)
	public void updateMemberName() {
		Member member = memberRepository.findById(3).get();
		member.setName("고길동");

		assertThat(memberRepository.findByName("고길동").get()).isEqualTo(member);
	}
}
