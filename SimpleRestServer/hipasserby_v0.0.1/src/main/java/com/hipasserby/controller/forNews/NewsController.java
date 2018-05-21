package com.hipasserby.controller.forNews;

import com.hipasserby.entity.News;
import com.hipasserby.request.FindOneByIdRequest;
import com.hipasserby.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/all")
    public List<News> getAllNews(){
        return newsService.findAll();
    }

    @PostMapping("/one")
    public News getOneNews(FindOneByIdRequest findOneByIdRequest){
        return newsService.findOne(findOneByIdRequest.getId());
    }

    @PutMapping("/create")
    public boolean createNews(News news){
        return newsService.save(news);
    }
}
