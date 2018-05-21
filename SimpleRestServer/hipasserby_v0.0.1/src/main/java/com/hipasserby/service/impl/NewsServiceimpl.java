package com.hipasserby.service.impl;

import com.hipasserby.entity.News;
import com.hipasserby.repository.NewsRepository;
import com.hipasserby.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceimpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void delete(Integer id) {
        newsRepository.delete(id);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findOne(Integer id) {
        return newsRepository.findOne(id);
    }

    @Override
    public boolean save(News news) {
        newsRepository.save(news);
        return true;
    }
}
