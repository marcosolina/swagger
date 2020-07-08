package com.marco.swagger.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marco.swagger.model.ArticleDto;
import com.marco.swagger.model.ArticlesResponse;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/articles")
@RestController
public class MainController {
    private static Map<Integer, ArticleDto> articles = new HashMap<Integer, ArticleDto>();
    private static int counterId;

    @PostMapping
    @ApiOperation(value = "It stores the new article", code = 201)
    public ResponseEntity<Void> insert(@RequestBody ArticleDto article) {
        counterId++;
        article.setId(counterId);
        articles.put(counterId, article);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "It returns the article with the matching id", code = 200)
    public ResponseEntity<ArticleDto> get(@PathVariable("id") Integer id) {
        ArticleDto dto = articles.get(id);
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ApiOperation(value = "It returns the list of available articles", code = 200)
    public ResponseEntity<ArticlesResponse> getAll() {

        Set<Entry<Integer, ArticleDto>> set = articles.entrySet();
        List<ArticleDto> list = new ArrayList<ArticleDto>();

        for (Entry<Integer, ArticleDto> entry : set) {
            list.add(entry.getValue());
        }

        ArticlesResponse resp = new ArticlesResponse();
        resp.setArticles(list);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping()
    @ApiOperation(value = "It updates the article", code = 200)
    public ResponseEntity<ArticleDto> update(@RequestBody ArticleDto article) {
        ArticleDto dto = articles.get(article.getId());
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        articles.put(article.getId(), article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "It deletes the article", code = 204)
    public ResponseEntity<ArticleDto> delete(@PathVariable("id") Integer id) {
        ArticleDto dto = articles.get(id);
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        articles.remove(id);
        return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
    }
}
