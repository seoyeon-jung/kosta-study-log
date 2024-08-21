package com.kosta.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kosta.entity.Article;

@DataJpaTest // JPA 관련 테스트
@AutoConfigureTestDatabase(replace = Replace.NONE) // 실제 DB 사용
public class BlogRepositoryTest {
	@Autowired
	private BlogRepository blogRepository;

	// 테스트 코드 패턴 : Given(주고) - When(테스트) - Then (검증)

	@Test
	@DisplayName("게시글 추가 테스트")
	public void saveArticleTest() {
		// given
		Article article = Article.builder().title("TEST Title").content("TEST content").build();

		// when
		Article savedArticle = blogRepository.save(article);

		// then
		assertThat(savedArticle).isNotNull();
		assertThat(savedArticle.getId()).isNotNull();
		assertThat(savedArticle.getTitle()).isEqualTo("TEST Title");
		assertThat(savedArticle.getContent()).isEqualTo("TEST content");
	}

	@Test
	@DisplayName("게시글 전체 조회 테스트")
	public void findAllTest() {
		// given
		Article article1 = Article.builder().title("제목1").content("내용1").build();
		Article article2 = Article.builder().title("내용2").content("내용2").build();
		blogRepository.save(article1);
		blogRepository.save(article2);

		// when
		List<Article> articleList = blogRepository.findAll();

		// then
		assertThat(articleList).isNotNull();
		assertThat(articleList.size()).isGreaterThanOrEqualTo(2);
		assertThat(articleList.stream().anyMatch(article -> article.getTitle().equals("제목1"))).isTrue();
		assertThat(articleList.stream().anyMatch(article -> article.getContent().equals("내용2"))).isTrue();
	}

	@Test
	@DisplayName("특정 게시물 조회(ID)")
	public void findByIdTest() {
		// given
		Article article = Article.builder().title("새로운 글 제목").content("새로운 글 내용").build();
		Article savedArticle = blogRepository.save(article);

		// when
		Article foundArticle = blogRepository.findById(savedArticle.getId()).get();

		// then
		assertThat(foundArticle).isNotNull();
		assertThat(foundArticle.getId()).isEqualTo(savedArticle.getId());
		assertThat(foundArticle.getTitle()).isEqualTo(savedArticle.getTitle());
		assertThat(foundArticle.getContent()).isEqualTo(savedArticle.getContent());
	}

	@Test
	@DisplayName("특정 게시물 삭제(ID)")
	public void deleteArticleTest() {
		// given
		int originalSize = blogRepository.findAll().size();
		Article article = Article.builder().title("삭제할 글 제목").content("삭제할 글 내용").build();
		Article savedArticle = blogRepository.save(article);

		// when
		blogRepository.deleteById(savedArticle.getId());
		int newSize = blogRepository.findAll().size();

		// then
		assertThat(originalSize).isEqualTo(newSize);
	}

	@Test
	@DisplayName("특정 게시물 수정")
	public void updateArticleTest() {
		// given
		Article article = Article.builder().title("수정할 글 제목").content("수정할 글 내용").build();
		Article savedArticle = blogRepository.save(article);

		// when
		Article foundArticle = blogRepository.findById(savedArticle.getId()).get();
		foundArticle.setTitle("변경된 글 제목");
		foundArticle.setContent("변경된 글 내용");

		// then
		Article changedArticle = blogRepository.findById(savedArticle.getId()).get();
		assertThat(foundArticle.getTitle()).isEqualTo(changedArticle.getTitle());
		assertThat(foundArticle.getContent()).isEqualTo(changedArticle.getContent());
	}

	@Test
	@DisplayName("제목 또는 내용에서 검색")
	public void searchByTitleOrContentTest() {
		// given
		Article article1 = Article.builder().title("에스파 - supernova").content("슈슈슈 슈퍼노바").build();
		blogRepository.save(article1);
		Article article2 = Article.builder().title("난 그게 좋던데").content("에스파 넥스트레벨").build();
		blogRepository.save(article2);

		// when
		List<Article> result = blogRepository.findByTitleContainsOrContentContains("에스파", "에스파");

		// then
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(2);
	}
}
