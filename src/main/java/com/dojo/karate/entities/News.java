package com.dojo.karate.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="news_id")
    private Integer newsId;

    @Column(name="created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
