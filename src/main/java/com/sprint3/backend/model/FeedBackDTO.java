package com.sprint3.backend.model;

public class FeedBackDTO {
    private int id;
    private String title;
    private String content;
    private String studentName;
    private Long studentId;
    private Long interactonId;

    public Long getInteractonId() {
        return interactonId;
    }

    public void setInteractonId(Long interactonId) {
        this.interactonId = interactonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
