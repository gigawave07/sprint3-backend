package com.sprint3.backend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "thesis_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThesisDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "first_progress_file", columnDefinition = "VARCHAR(250)")
    private String firstProgressFile;

    @Column(name = "second_progress_file", columnDefinition = "VARCHAR(250)")
    private String secondProgressFile;

    @Column(name = "fisrt_file_url", columnDefinition = "TEXT")
    private String firstFileUrl;

    @Column(name = "second_file_url", columnDefinition = "TEXT")
    private String secondFileUrl;

    @Column(name = "first_description", columnDefinition = "VARCHAR(250)")
    private String firstDescription;

    @Column(name = "second_description", columnDefinition = "VARCHAR(250)")
    private String secondDescription;

    @Column(name = "percent", columnDefinition = "DOUBLE")
    private Double percent;

    @Column(name = "first_submit_date", columnDefinition = "DATETIME")
    private LocalDateTime firstSubmitDate;

    @Column(name = "second_submit_date", columnDefinition = "DATETIME")
    private LocalDateTime secondSubmitDate;

    @Column(name = "first_comment", columnDefinition = "VARCHAR(250)")
    private String firstComment;

    @Column(name = "second_comment", columnDefinition = "VARCHAR(250)")
    private String secondComment;


    // relationship

    @ManyToOne
    @JoinColumn(name = "check_thesis_id", referencedColumnName = "id", columnDefinition = "BIGINT")
    private CheckThesis checkThesis;
}
