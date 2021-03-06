package com.hfl.model;

/**
 * Created by hfl on 2017-5-2.
 * 创建表头信息
 * 表头信息用于自动生成表头结构及排序
 */
public class ExcelHeader implements Comparable<ExcelHeader>{

    /**
     * excel的标题名称
     */
    private String title;
    /**
     * 每一个标题的顺序
     */
    private int order;
    /**
     * 对应方法名称
     */
    private String methodName;

    public int compareTo(ExcelHeader o) {
        return order>o.order?1:(order<o.order?-1:0);
    }

    public ExcelHeader(String title, int order, String methodName) {
        super();
        this.title = title;
        this.order = order;
        this.methodName = methodName;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}

