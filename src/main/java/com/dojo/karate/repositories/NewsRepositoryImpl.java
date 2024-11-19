package com.dojo.karate.repositories;

import com.dojo.karate.EntityManagerHolder;
import com.dojo.karate.entities.News;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class NewsRepositoryImpl implements INewsRepository{


    @Override
    public List<News> getAllNews() {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<News> query = entityManager.createQuery("SELECT n FROM News n", News.class);
        return query.getResultList();
    }

    @Override
    public News getNewsById(Integer newsId) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        News news = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            news = entityManager.find(News.class, newsId);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return news;
    }

    @Override
    public News createNews(News news) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(news);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return news;
    }

    @Override
    public void updateNews(News news) {

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(news);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    @Override
    public void deleteNews(Integer newsId) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            News news = entityManager.find(News.class, newsId);
            entityManager.remove(news);
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
