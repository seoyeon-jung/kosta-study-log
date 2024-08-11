package com.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieDTO {
	private int id;
	private String title, summary, genre, director, actors, poster, release_date;

	public MovieDTO(String title, String summary, String genre, String director, String actors, String poster,
			String release_date) {
		this.title = title;
		this.summary = summary;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.poster = poster;
		this.release_date = release_date;
	}
}
