package kz.chessTasks.eightQueens.controller;

import kz.chessTasks.eightQueens.Board;
import kz.chessTasks.eightQueens.Position;
import kz.chessTasks.eightQueens.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cells")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping
    public Position[] sendCoordinate(@RequestBody Position position) {
        boardService.takeCoordinates(position);

        return null;
    }
}