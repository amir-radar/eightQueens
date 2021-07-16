package kz.chessTasks.eightQueens.service;

import kz.chessTasks.eightQueens.Coordinate;
import kz.chessTasks.eightQueens.Position;
import kz.chessTasks.eightQueens.repo.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public boolean tryToSetQueens(BoardRepository board, int z, Coordinate coordinate){
        if (z==board.getN()) return true;
        int h = coordinate.getX();
        int g = coordinate.getY();
        for (int i = 0; i < board.getN(); i++) {
            if (checkPossibleLocations(board, z, i, h, g)) {
                board.getCells()[z][i] = 'F';      //repo
                if (tryToSetQueens(board, z + 1, coordinate)){
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

        //На этом поле уже установлена F
        if (x==h && y==g){ return true;}

        for (int i = 0; i < board.getN(); i++) {
            if ((board.getCells()[x][i] == 'F' || board.getCells()[i][y] == 'F')) return false;
        }

        //Разница между координатами
        int a;
        if (x>y) a=x-y; else a=y-x;
        //
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

    public Coordinate convertPositionToCoordinate(Position pos){
        Coordinate coordinate = new Coordinate();
        coordinate.setX(convertPositionCharsToInt(pos.getVert()));
        coordinate.setY(convertPositionCharsToInt(pos.getHoriz()));
        return coordinate;
    }

    public int convertPositionCharsToInt(char s){
        if (s == 'A' || s == '1')
            return 0;
        else if (s == 'B' || s == '2')
            return 1;
        else if (s == 'C' || s == '3')
            return 2;
        else if (s == 'D' || s == '4')
            return 3;
        else if (s == 'E' || s == '5')
            return 4;
        else if (s == 'F' || s == '6')
            return 5;
        else if (s == 'G' || s == '7')
            return 6;
        else //if (s == 'H' || s == '8')
            return 7;
        //else
        //Тут выводить ошибку
    }
}
