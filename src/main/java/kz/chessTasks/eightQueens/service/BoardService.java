package kz.chessTasks.eightQueens.service;

import kz.chessTasks.eightQueens.Board;
import kz.chessTasks.eightQueens.Position;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public String[] takeCoordinates(Position position){
        Board board = new Board();

        String pos = position.convertToMassiveCoordinate(position.coordinate);
        int x = pos.charAt(0) - '0';
        int y = pos.charAt(1) - '0';

        String[] coordinates = board.insertQueen(x,y);
        return coordinates;
    }

    public Position[] sendCoordinates(String[] s){
        Position pos = new Position();
        Board board = new Board();
        Position[] positions = new Position[board.N];
        for (int i = 0; i < board.N; i++)
            positions[i].coordinate = s[i];
        return positions;
    }
}
