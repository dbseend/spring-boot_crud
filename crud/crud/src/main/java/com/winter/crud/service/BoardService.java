package com.winter.crud.service;

import com.winter.crud.domain.Board;
import com.winter.crud.domain.BoardRepository;
import com.winter.crud.dto.request.BoardCreateRequest;
import com.winter.crud.dto.request.BoardUpdateRequest;
import com.winter.crud.dto.response.BoardAllResponse;
import com.winter.crud.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardResponse createPost(final BoardCreateRequest request) {

        if (request.getTitle().isEmpty() || request.getAuthor().isEmpty()
                || request.getContent().isEmpty()) { //제목, 작성자, 내용 중 하나라도 비어있는 경우
            return null;
        }

        LocalDateTime createAt = LocalDateTime.now();

        Board board = new Board(
                request.getTitle(),
                request.getAuthor(),
                request.getContent(),
                createAt,
                0,
                0
        );
        boardRepository.save(board);

        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getAuthor(),
                board.getContent(),
                board.getCreatedAt(),
                board.getViewCnt()
        );
    }

    public BoardAllResponse getAllPosts() {

        List<Board> boardList = boardRepository.findAll();

        List<BoardResponse> boardResponseList = boardList.stream()
                .map(BoardResponse::new)
                .toList();

        return new BoardAllResponse(boardResponseList, boardResponseList.size());
    }

    public BoardResponse getPost(Long postId) {

        Optional<Board> board = boardRepository.findById(postId);
        if (board.isEmpty()) { //id에 해당하는 게시물이 없는 경우
            return null;
        }

        board.get().updateViewCnt();
        boardRepository.save(board.get());

        return new BoardResponse(
                board.get().getId(),
                board.get().getTitle(),
                board.get().getAuthor(),
                board.get().getContent(),
                board.get().getCreatedAt(),
                board.get().getViewCnt()
        );
    }

    public BoardResponse updatePost(BoardUpdateRequest request) {

        Optional<Board> board = boardRepository.findById(request.getPostId());
        if (board.isEmpty()) { //id에 해당하는 게시물이 없는 경우
            return null;
        }

        board.get().update(request.getTitle(), request.getContent());
        boardRepository.save(board.get());

        return new BoardResponse(
                board.get().getId(),
                board.get().getTitle(),
                board.get().getAuthor(),
                board.get().getContent(),
                board.get().getCreatedAt(),
                board.get().getViewCnt()
        );
    }

    public BoardResponse deletePost(final Long postId) {

        Optional<Board> board = boardRepository.findById(postId);
        if (board.isEmpty()) { //id에 해당하는 게시물이 없는 경우
            return null;
        }

        boardRepository.delete(board.get());

        return new BoardResponse(
                board.get().getId(),
                board.get().getTitle(),
                board.get().getAuthor(),
                board.get().getContent(),
                board.get().getCreatedAt(),
                board.get().getViewCnt()
        );
    }
}
