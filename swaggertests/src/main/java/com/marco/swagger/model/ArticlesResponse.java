package com.marco.swagger.model;

import java.io.Serializable;
import java.util.List;

public class ArticlesResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ArticleDto> articles;

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDto> articles) {
        this.articles = articles;
    }

}
