package com.marco.swagger.model;

import java.io.Serializable;

public class InsertArticleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String desc;

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
