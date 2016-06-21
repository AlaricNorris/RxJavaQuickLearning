package com.alaric.norris.study.mvvmretrofit.beans;
import java.util.List;
public class Movie {
    private int count;

    private int start;

    private int total;

    private List< Subjects > subjects;

    private String title;
    public int getCount () {
        return this.count;
    }
    public void setCount ( int count ) {
        this.count = count;
    }
    public int getStart () {
        return this.start;
    }
    public void setStart ( int start ) {
        this.start = start;
    }
    public int getTotal () {
        return this.total;
    }
    public void setTotal ( int total ) {
        this.total = total;
    }
    public List< Subjects > getSubjects () {
        return this.subjects;
    }
    public void setSubjects ( List< Subjects > subjects ) {
        this.subjects = subjects;
    }
    public String getTitle () {
        return this.title;
    }
    public void setTitle ( String title ) {
        this.title = title;
    }
    @Override
    public String toString () {
        return "Movie{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", subjects=" + subjects +
                ", title='" + title + '\'' +
                '}';
    }
}