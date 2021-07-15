package kz.chessTasks.eightQueens.service;

import kz.chessTasks.eightQueens.Board;
import kz.chessTasks.eightQueens.Position;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public char[][] takeCoordinates(Position position){
        Board board = new Board();
        char[][] s = new char[2][board.N];

        String pos = position.convertToMassiveCoordinate(position.coordinate);
        int x = pos.charAt(0) - '0';
        int y = pos.charAt(1) - '0';

        board.insertQueen(x,y);
        return s;
    }
}
