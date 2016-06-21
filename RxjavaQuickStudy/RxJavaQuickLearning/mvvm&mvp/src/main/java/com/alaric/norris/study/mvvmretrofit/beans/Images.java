package com.alaric.norris.study.mvvmretrofit.beans;
public class Images {
    private String small;

    private String large;

    private String medium;
    public String getSmall () {
        return this.small;
    }
    public void setSmall ( String small ) {
        this.small = small;
    }
    public String getLarge () {
        return this.large;
    }
    public void setLarge ( String large ) {
        this.large = large;
    }
    public String getMedium () {
        return this.medium;
    }
    public void setMedium ( String medium ) {
        this.medium = medium;
    }
    @Override
    public String toString () {
        return "Images{" +
                "small='" + small + '\'' +
                ", large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}