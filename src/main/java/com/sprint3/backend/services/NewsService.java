package com.sprint3.backend.services;

import com.sprint3.backend.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAllNews();
    News findById(Long id);
}
