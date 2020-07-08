package com.marco.swagger.model;

import java.io.Serializable;

public class ArticleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
