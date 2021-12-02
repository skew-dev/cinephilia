package com.skewdev.cinephilia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reviews")
public class Review {
    @Id
    private String id;

    @JsonProperty("author_id")
    private String authorId;

    @JsonProperty("movie_id")
    private Long movieId;

    private String content;

    public Review() {
    }

    public Review(String authorId, Long movieId, String content) {
        this.authorId = authorId;
        this.movieId = movieId;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", authorId='" + authorId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
