package com.sprint3.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "instruction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "file_name", columnDefinition = "VARCHAR(250)")
    private String fileName;

    @Column(name = "file_url", columnDefinition = "TEXT")
    private String fileUrl;

    @Column(name = "description", columnDefinition = "VARCHAR(250)")
    private String description;

    @Column(name = "upload_date", columnDefinition = "DATETIME")
    private LocalDateTime uploadDate = LocalDateTime.now();

    @Column(name = "path", columnDefinition = "VARCHAR(255)")
    private String pathFile;
}
