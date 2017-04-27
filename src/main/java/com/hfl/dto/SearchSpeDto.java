package com.hfl.dto;

import org.springframework.data.jpa.domain.Specifications;

/**
 * Created by hfl on 2017-4-27.
 * 筛选条件的DTO对象
 */
public class SearchSpeDto {

    private String type;  /** 类型，and或者or */

    private Specifications spes;

    public SearchSpeDto(String type, Specifications spes) {
        this.type = type;
        this.spes = spes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Specifications getSpes() {
        return spes;
    }

    public void setSpes(Specifications spes) {
        this.spes = spes;
    }
}
