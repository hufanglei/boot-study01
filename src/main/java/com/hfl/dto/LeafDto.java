package com.hfl.dto;

/**
 * Created by hfl on 2017-5-2.
 */
public class LeafDto {
    private String name;

    private String url;

    public LeafDto() {
    }

    public LeafDto(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }




}
