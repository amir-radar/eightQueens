package kz.chessTasks.eightQueens.controller;

import kz.chessTasks.eightQueens.Coordinate;
import kz.chessTasks.eightQueens.Position;
import kz.chessTasks.eightQueens.repo.BoardRepository;
import kz.chessTasks.eightQueens.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cells")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping(value = "/sendPosition")
    public ArrayList<Position> sendCoordinate(@RequestBody Position position) {
        BoardRepository board1 = new BoardRepository();
        Coordinate coordinate =  boardService.convertPositionToCoordinate(position);
        //board1.fillArray(board1);
        boardService.setFirstQueen(board1, coordinate);
        boardService.tryToSetQueens(board1, 0, coordinate);
        //board1.printArray(board1.getCells());

        return boardService.collectPositions(board1);
    }
}