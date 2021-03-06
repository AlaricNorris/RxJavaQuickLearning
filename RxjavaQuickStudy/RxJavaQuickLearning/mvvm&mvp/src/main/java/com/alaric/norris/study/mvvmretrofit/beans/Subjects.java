package com.alaric.norris.study.mvvmretrofit.beans;

import java.util.List;
public class Subjects {
    private Rating rating;

    private List< String > genres;

    private String title;

    private List< Casts > casts;

    private int collect_count;

    private String original_title;

    private String subtype;

    private List< Directors > directors;

    private String year;

    private Images images;

    private String alt;

    private String id;
    public Rating getRating () {
        return this.rating;
    }
    public void setRating ( Rating rating ) {
        this.rating = rating;
    }
    public List< String > getGenres () {
        return this.genres;
    }
    public void setGenres ( List< String > genres ) {
        this.genres = genres;
    }
    public String getTitle () {
        return this.title;
    }
    public void setTitle ( String title ) {
        this.title = title;
    }
    public List< Casts > getCasts () {
        return this.casts;
    }
    public void setCasts ( List< Casts > casts ) {
        this.casts = casts;
    }
    public int getCollect_count () {
        return this.collect_count;
    }
    public void setCollect_count ( int collect_count ) {
        this.collect_count = collect_count;
    }
    public String getOriginal_title () {
        return this.original_title;
    }
    public void setOriginal_title ( String original_title ) {
        this.original_title = original_title;
    }
    public String getSubtype () {
        return this.subtype;
    }
    public void setSubtype ( String subtype ) {
        this.subtype = subtype;
    }
    public List< Directors > getDirectors () {
        return this.directors;
    }
    public void setDirectors ( List< Directors > directors ) {
        this.directors = directors;
    }
    public String getYear () {
        return this.year;
    }
    public void setYear ( String year ) {
        this.year = year;
    }
    public Images getImages () {
        return this.images;
    }
    public void setImages ( Images images ) {
        this.images = images;
    }
    public String getAlt () {
        return this.alt;
    }
    public void setAlt ( String alt ) {
        this.alt = alt;
    }
    public String getId () {
        return this.id;
    }
    public void setId ( String id ) {
        this.id = id;
    }
    @Override
    public String toString () {
        return "Subjects{" +
                "rating=" + rating +
                ", genres=" + genres +
                ", title='" + title + '\'' +
                ", casts=" + casts +
                ", collect_count=" + collect_count +
                ", original_title='" + original_title + '\'' +
                ", subtype='" + subtype + '\'' +
                ", directors=" + directors +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}