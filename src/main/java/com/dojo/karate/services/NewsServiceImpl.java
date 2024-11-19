package com.dojo.karate.services;

import com.dojo.karate.dtos.NewsDto;
import com.dojo.karate.entities.News;
import com.dojo.karate.repositories.INewsRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements InewsService{

    private INewsRepository newsRepository;
    private ModelMapper modelMapper;

    public NewsServiceImpl(INewsRepository newsRepository, IModelMapperProvider modelMapperProvider){
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapperProvider.getModelMapper();
    }
    @Override
    public List<NewsDto> getAllNews() {
        List<News> newsList = this.newsRepository.getAllNews();
        List<NewsDto> newsDtos = new ArrayList<>();
        for(News news: newsList){
            NewsDto newsDto = this.modelMapper.map(news, NewsDto.class);
            newsDtos.add(newsDto);
        }
        return newsDtos;
    }

    @Override
    public NewsDto getSingleNewsById(Integer id) {
        News news = this.newsRepository.getNewsById(id);
        NewsDto newsDto = this.modelMapper.map(news, NewsDto.class);
        return newsDto;
    }

    @Override
    public NewsDto createNews(NewsDto newsDto) {
        News news = this.modelMapper.map(newsDto, News.class);
        this.newsRepository.createNews(news);
        return newsDto;
    }

    @Override
    public void updateNews(NewsDto newsDto) {
        News news = this.modelMapper.map(newsDto, News.class);
        this.newsRepository.updateNews(news);
    }

    @Override
    public void deleteNews(Integer newsId) {
        //News news = this.modelMapper.map(newsDto, News.class);
        this.newsRepository.deleteNews(newsId);
    }
}
