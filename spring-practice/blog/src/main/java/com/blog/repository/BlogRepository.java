package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.Post;

@Repository
public interface BlogRepository extends JpaRepository<Post, Long> {

	List<Post> findByTitleContainsOrContentContainsOrderByTitleDesc(String keyword, String keyword2);

	List<Post> findByTitleContainsOrContentContainsOrderByTitleAsc(String keyword, String keyword2);

}
