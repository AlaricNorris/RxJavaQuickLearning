package com.alaric.norris.study.mvvmretrofit.beans;
public class Rating {
    private int max;

    private double average;

    private String stars;

    private int min;
    public int getMax () {
        return this.max;
    }
    public void setMax ( int max ) {
        this.max = max;
    }
    public double getAverage () {
        return this.average;
    }
    public void setAverage ( double average ) {
        this.average = average;
    }
    public String getStars () {
        return this.stars;
    }
    public void setStars ( String stars ) {
        this.stars = stars;
    }
    public int getMin () {
        return this.min;
    }
    public void setMin ( int min ) {
        this.min = min;
    }
    @Override
    public String toString () {
        return "Rating{" +
                "max=" + max +
                ", average=" + average +
                ", stars='" + stars + '\'' +
                ", min=" + min +
                '}';
    }
}