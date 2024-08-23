package com.kosta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kosta.entity.Article;
import com.kosta.entity.User;
import com.kosta.repository.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
	private final BlogRepository blogRepository;

	@Override
	public Article save(Article article, User user) {
		article.setCreator(user);
		return blogRepository.save(article);
	}

	@Override
	public List<Article> findAll() {
		return blogRepository.findAll();
	}

	@Override
	public Article findById(Long id) throws Exception {
		Optional<Article> optArticle = blogRepository.findById(id);
		Article article = optArticle.orElseThrow(() -> new Exception("ID가 없습니다"));
		return article;
	}

	@Override
	public void deleteById(Long id, User user) throws Exception {
		Article article = findById(id);
		User creator = article.getCreator(); // creator : 작성자 / user : 로그인한 사용자
		if (user.getId().equals(creator.getId())) {
			// 삭제 가능
			blogRepository.deleteById(article.getId());
		} else {
			throw new Exception("본인이 작성한 글만 삭제할 수 있습니다.");
		}
	}

	@Override
	public Article update(Article article, User user) throws Exception {
		Article originArticle = findById(article.getId());
		User creator = originArticle.getCreator();
		if (!user.getId().equals(creator.getId())) {
			// 수정 권한 없음
			throw new Exception("본인이 작성한 글만 수정할 수 있습니다.");
		}
		originArticle.setTitle(article.getTitle());
		originArticle.setContent(article.getContent());

		Article updatedArticle = blogRepository.save(originArticle);
		return updatedArticle;
	}

	@Override
	public List<Article> searchAndOrder(String keyword, String order) {
		// 정렬 기준만 체크
		if (order.equals("desc")) {
			// 내림차순 결과 반환
			return blogRepository.findByTitleContainsOrContentContainsOrderByTitleDesc(keyword, keyword);
		}
		// 오름차순 결과 반환
		return blogRepository.findByTitleContainsOrContentContainsOrderByTitleAsc(keyword, keyword);
	}

}
