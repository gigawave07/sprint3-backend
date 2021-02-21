package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.News;
import com.sprint3.backend.repository.NewsRepository;
import com.sprint3.backend.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;
    @Override
    public List<News> findAllNews() {
        return this.newsRepository.findAllNewsSort();
    }

    @Override
    public News findById(Long id) {
        return this.newsRepository.findById(id).orElse(null);
    }
}
