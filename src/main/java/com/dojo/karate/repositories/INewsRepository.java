package com.dojo.karate.repositories;

import com.dojo.karate.entities.News;

import java.util.List;

public interface INewsRepository {

    List<News> getAllNews();
    News getNewsById(Integer id);

    News createNews(News news);

    void updateNews(News news);

    void deleteNews(Integer newsId);
}
