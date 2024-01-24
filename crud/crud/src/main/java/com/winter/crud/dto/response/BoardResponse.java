package com.winter.crud.dto.response;

import com.winter.crud.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {

    private Long id;

    private String title;

    private String author;

    private String content;

    private LocalDateTime createdAt;

    private Integer viewCnt;
    
    public BoardResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
        this.content = board.getContent();
        this.createdAt = board.getCreatedAt();
        this.viewCnt = board.getViewCnt();
    }
}
