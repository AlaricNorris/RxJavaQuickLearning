package com.alaric.norris.study.retrofitstudy;

/**
 * @Project CommonProject
 * @Packate com.micky.commonproject.data.model
 * @Description
 * @Author Micky Liu
 * @Email mickyliu@126.com
 * @Date 2015-12-21 16:40
 * @Version 0.1
 */
public class IpInfo {
    public String country;
    public String country_id;
    public String area;
    public String area_id;
    public String ip;

    @Override
    public String toString () {
        return "IpInfo{" +
                "country='" + country + '\'' +
                ", country_id='" + country_id + '\'' +
                ", area='" + area + '\'' +
                ", area_id='" + area_id + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
