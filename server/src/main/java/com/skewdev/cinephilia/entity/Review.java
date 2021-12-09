package com.skewdev.cinephilia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Document("reviews")
public class Review {
    @Id
    private String id;

    @JsonProperty(value = "movie_id", access = JsonProperty.Access.READ_ONLY)
    private Long movieId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Author author;

    @NotBlank
    private String content;

    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private Date createdAt;

    @JsonProperty(value = "updated_at", access = JsonProperty.Access.READ_ONLY)
    private Date updatedAt;

    public Review() {
        createdAt = new Date();
        updatedAt = createdAt;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", movieId=" + movieId +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
