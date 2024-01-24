package com.winter.crud.controller;

import com.winter.crud.dto.request.BoardCreateRequest;
import com.winter.crud.dto.request.BoardUpdateRequest;
import com.winter.crud.dto.response.BoardAllResponse;
import com.winter.crud.dto.response.BoardResponse;
import com.winter.crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v0/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<BoardResponse> createPost(@RequestBody final BoardCreateRequest request) {

        BoardResponse response = boardService.createPost(request);

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("")
    public ResponseEntity<BoardAllResponse> createPost() {

        BoardAllResponse response = boardService.getAllPosts();

        return ResponseEntity.ok()
                .body(response);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BoardResponse> createPost(@PathVariable final Long postId) {

        BoardResponse response = boardService.getPost(postId);

        return ResponseEntity.ok()
                .body(response);
    }

    @PatchMapping("")
    public ResponseEntity<BoardResponse> updatePost(@RequestBody final BoardUpdateRequest request) {

        BoardResponse response = boardService.updatePost(request);

        return ResponseEntity.ok()
                .body(response);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<BoardResponse> deletePost(@PathVariable final Long postId) {

        BoardResponse response = boardService.deletePost(postId);

        return ResponseEntity.ok()
                .body(response);
    }
}
