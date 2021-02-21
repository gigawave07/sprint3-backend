package com.sprint3.backend.repository;

import com.sprint3.backend.model.ProgressDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprint3.backend.entity.ProgressThesis;

@Repository
public interface ProgressThesisRepository extends JpaRepository<ProgressThesis, Long> {

    /**
     * Lấy tên Đề tài để hiển thị
     */
    @Query(nativeQuery = true, value = "select thesis.statement as nameThesis\n, progress_thesis.comment as comment,  progress_thesis.status as status, progress_thesis.mark as mark, progress_thesis.submit_date as dateSubmit " +
            "from check_thesis\n" +
            "join thesis on check_thesis.thesis_id = thesis.id\n" +
            "join student_group on check_thesis.student_group_id = student_group.id\n" +
            "join student on student_group.id = student.group_id\n" +
            "join progress_thesis on check_thesis.id = progress_thesis.check_thesis_id\n"+
            "where check_thesis.status = true and student.id = ? and progress_thesis.progress = ?;")
    public ProgressDTO getNameThesisByIdStudent(Long idStudent, Long progressThesis);
}
