package com.sprint3.backend.controllers;

import com.sprint3.backend.entity.News;
import com.sprint3.backend.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsController {
    @Autowired
    NewsService newsService;

    /**
     * Quoc Controller
     */
    @GetMapping("/listAllNews")
    public List<News> getAllNews(){
        List<News> listNews = this.newsService.findAllNews();
        return listNews;
    }
    @GetMapping("/newsById/{newsId}")
    public News getNewsById(@PathVariable("newsId") Long id ){
        return this.newsService.findById(id);
    }
    /**
     * Quoc end Controller
     */

}
