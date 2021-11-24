package com.skewdev.cinephilia.entity;

import javax.persistence.*;

@Entity
public class Movie {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String title;
    @Column(name = "release_date")
    private String releaseDate;
    private String overview;

    public Movie() {
    }

    public Movie(String title, String releaseDate, String overview) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String release_date) {
        this.releaseDate = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }
}
