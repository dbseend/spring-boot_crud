package com.winter.crud.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateRequest {

    private String title;

    private String author;

    private String content;
}
