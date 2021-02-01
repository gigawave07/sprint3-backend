package com.sprint3.backend.repository;

import com.sprint3.backend.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News,Long> {
    @Query(value ="select * from project3_thesis_management.news order by create_date desc ",nativeQuery = true)
    List<News> findAllNewsSort();

}
