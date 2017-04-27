package com.hfl.tools;

import com.hfl.dto.SearchDto;
import com.hfl.dto.SearchSpeDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

/**
 * Created by hfl on 2017-4-27.
 * 筛选功能对象
 */
public class SearchTools {

    public static Specification buildSpecification(SearchSpeDto... speDtos) {
        Specifications result = null;
        for(SearchSpeDto dto : speDtos) {
            if(result==null) {
                result = Specifications.where(dto.getSpes());
            } else {
                if("and".equalsIgnoreCase(dto.getType())) {
                    result = result.and(dto.getSpes());
                } else {
                    result = result.or(dto.getSpes());
                }
            }
        }
        return result;
    }

    public static SearchSpeDto buildSpeDto(String type, SearchDto... searchDtos) {
        SearchSpeDto speDtos = null;
        Specifications result = null;
        for(SearchDto dto : searchDtos) {
            if(result==null) {
                result = Specifications.where(new BaseSearch(dto));
            } else {
                if("and".equalsIgnoreCase(dto.getType())) {
                    result = result.and(new BaseSearch(dto));
                } else {
                    result = result.or(new BaseSearch(dto));
                }
            }
        }
        speDtos = new SearchSpeDto(type, result);
        return speDtos;
    }

}
