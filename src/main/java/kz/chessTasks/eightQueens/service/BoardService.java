package kz.chessTasks.eightQueens.service;

import kz.chessTasks.eightQueens.repo.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    BoardRepository boardRepository;


    //    public String[] takeCoordinates(Position position){
//        Board board = new Board();
//
//        String pos = position.convertToMassiveCoordinate(position.coordinate);
//        int x = pos.charAt(0) - '0';
//        int y = pos.charAt(1) - '0';
//        System.out.println(x + " " + y);
//
//        String[] coordinates = board.insertQueen(x,y);
//        return coordinates;
//    }

    public boolean tryToSetQueens(BoardRepository board, int z, int h, int g){
        if (z==board.getN()) return true;
        for (int i = 0; i < board.getN(); i++) {
                if (checkPossibleLocations(board, z, i, h, g)) {
                    board.getCells()[z][i] = 'F';      //repo
                    if (tryToSetQueens(board, z + 1, h, g)) {
                        return true;
                    }
                    if(z != h && i != g) {
                        board.getCells()[z][i] = '0';   //repo
                    }
                }
        }
        return false;
    }

    private boolean checkPossibleLocations(BoardRepository board, int x, int y, int h, int g){
        if (x==h && y==g){ return true;}

        for (int i = 0; i < board.getN(); i++) {
            if ((board.getCells()[x][i] == 'F' || board.getCells()[i][y] == 'F')) return false;
        }

        //Разница между координатами
        int a;
        if (x>y) a=x-y; else a=y-x;
        if (x<y) {
            for (int i = 0; i < board.getN()-a; i++) {
                if (board.getCells()[i][i+a] == 'F') return false;
            }
        } else {
            for (int i = a; i < board.getN(); i++) {
                if (board.getCells()[i][i - a] == 'F') return false;
            }
        }

        int b;
        b=x+y;
        if (x+y < board.getN()) {
            for (int i = 0; i < b+1; i++) {
                if (board.getCells()[i][b - i] == 'F') return false;
            }
        } else {
            for (int i = b - board.getN()+1; i < board.getN(); i++) {
                if (board.getCells()[i][b - i] == 'F') return false;
            }
        }

        return true;
    }

    private void printArray(char[][] array){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
