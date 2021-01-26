package com.sprint3.backend.repository;

import com.sprint3.backend.entity.PeriodOfTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PeriodOfTimeRepository extends JpaRepository<PeriodOfTime, Long> {
    @Query(value = "select * from period_of_time order by start_date asc", nativeQuery = true)
    List<PeriodOfTime> findAll();

    @Query(value = "select * from period_of_time where :date >= start_date and :date <= end_date", nativeQuery = true)
    PeriodOfTime findByDate(@Param("date") String date);
}
