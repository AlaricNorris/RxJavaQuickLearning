package com.alaric.norris.study.mvvm_mvp.bean;
import android.databinding.BaseObservable;
public class IPAddress extends BaseObservable {

    String City;
    String Country;
    String Province;

    public String getCity () {
        return City;
    }

    public void setCity ( String city ) {
        City = city;
    }

    public String getCountry () {
        return Country;
    }

    public void setCountry ( String country ) {
        Country = country;
    }

    public String getProvince () {
        return Province;
    }

    public void setProvince ( String province ) {
        Province = province;
    }

    public String toString () {

        return this.getCountry() + "\n" +
                this.getProvince() + "\n" +
                this.getCity() + "\n";

    }
}