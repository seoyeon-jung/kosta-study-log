package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
