package com.sprint3.backend.repository;

import com.sprint3.backend.entity.PeriodOfTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodOfTimeRepository extends JpaRepository<PeriodOfTime, Long> {
}
