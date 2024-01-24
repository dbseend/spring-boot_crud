package com.winter.crud.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequest {

    private Long postId;

    private String title;

    private String content;
}
