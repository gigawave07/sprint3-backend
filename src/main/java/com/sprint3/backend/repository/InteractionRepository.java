package com.sprint3.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.Interaction;


@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Long> {
}
