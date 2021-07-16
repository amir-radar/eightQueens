package kz.chessTasks.eightQueens.repo;

import kz.chessTasks.eightQueens.Position;

import java.util.List;

public class BoardRepository {

    private final int N = 8;
    private char[][] cells = new char[N][N];
    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public int getN() {
        return N;
    }

    public char[][] getCells() {
        return cells;
    }

    public void setCells(char[][] cells) {
        this.cells = cells;
    }


    public void printArray(char[][] array){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }

    public void fillArray(BoardRepository board){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = '0';
            }
        }
    }
}
