package com.hipasserby.service;

import com.hipasserby.entity.News;
import com.hipasserby.request.FindOneByIdRequest;

import java.util.List;

public interface NewsService {

    void delete(Integer id);

    List<News> findAll();

    News findOne(Integer id);

    boolean save(News news);

}
