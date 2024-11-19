package com.dojo.karate.services;

import com.dojo.karate.dtos.NewsDto;
import com.dojo.karate.entities.News;

import java.util.List;

public interface InewsService {

    List<NewsDto> getAllNews();
    NewsDto getSingleNewsById(Integer id);
    NewsDto createNews(NewsDto news);
    void updateNews(NewsDto newsDto);
    void deleteNews(Integer newsid);
}
