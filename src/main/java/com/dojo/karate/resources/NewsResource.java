package com.dojo.karate.resources;

import com.dojo.karate.dtos.NewsDto;
import com.dojo.karate.repositories.INewsRepository;
import com.dojo.karate.repositories.NewsRepositoryImpl;
import com.dojo.karate.services.InewsService;
import com.dojo.karate.services.ModelMapperProvider;
import com.dojo.karate.services.NewsServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/news")
public class NewsResource {

    private INewsRepository newsRepository;
    private InewsService newsService;
    private ModelMapperProvider modelMapperProvider;

    public NewsResource(){
        this.newsRepository = new NewsRepositoryImpl();
        this.modelMapperProvider = new ModelMapperProvider();
        this.newsService = new NewsServiceImpl(this.newsRepository, this.modelMapperProvider);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public NewsDto getSingleNewsById(@PathParam("id") Integer newsId){
        return this.newsService.getSingleNewsById(newsId);
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public List<NewsDto> getAllNews(){
        return this.newsService.getAllNews();
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public NewsDto createNews(NewsDto newsDto){
        NewsDto createdNews = this.newsService.createNews(newsDto);
        return createdNews;
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public NewsDto updateNews(@PathParam("id") Integer newsId, NewsDto newsDto){
        System.out.println("mise à jour...");
        newsDto.setNewsId(newsId);
        this.newsService.updateNews(newsDto);
        return newsDto;
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteNews(@PathParam("id") Integer newsId){
        System.out.println("suppression...");
        this.newsService.deleteNews(newsId);
    }
}
