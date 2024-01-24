package com.winter.crud.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardAllResponse {

    private List<BoardResponse> boardResponseList;

    private Integer size;

}
