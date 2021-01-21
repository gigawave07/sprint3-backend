package com.sprint3.backend.repository;

import com.sprint3.backend.entity.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface InstructionRepository extends JpaRepository<Instruction, Long> {

    // ------------------------ Vinh start -----------------------------------
    @Query(value = "select * from instruction where instruction.upload_date between :startDate and :endDate",
            nativeQuery = true)
    List<Instruction> findAllByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "delete from instruction where id = :instructionId", nativeQuery = true)
    @Modifying
    @Transactional
    void delete(@Param("instructionId") Long id);
    // ------------------------ Vinh end  -----------------------------------
}
