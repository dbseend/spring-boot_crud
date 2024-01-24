package com.winter.crud.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime createdAt;

    private Integer viewCnt;

    @Builder
    public Board(String title, String author, String content, LocalDateTime createdAt, Integer viewCnt, Integer recommendCnt) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
        this.viewCnt = viewCnt;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateViewCnt() {
        this.viewCnt++;
    }
}
