package com.hfl.tools;

import org.springframework.data.domain.Sort;

/**
 * Created by hfl on 2017-4-27.
 * 单排序封装
 *
 */
public class SortTools {

    public static Sort basicSort() {
        return basicSort("desc", "id");
    }

    public static Sort basicSort(SortDto... dtos) {
        Sort result = null;
        for(int i=0; i<dtos.length; i++) {
            SortDto dto = dtos[i];
            if(result == null) {
                result = new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField());
            } else {
                result = result.and(new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField()));
            }
        }
        return result;
    }

    //这样封装的好处是：不用每次进行排序时都new个Sort对象作为参数传入；比较方便灵活的根据自己需求传入要排序的方式与字段。
    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }

}
