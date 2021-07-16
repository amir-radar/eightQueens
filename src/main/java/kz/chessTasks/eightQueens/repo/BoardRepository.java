package kz.chessTasks.eightQueens.repo;

import kz.chessTasks.eightQueens.service.BoardService;

public class BoardRepository {

    private final int N = 8;
    private char[][] cells = new char[N][N];

    public int getN() {
        return N;
    }

    public char[][] getCells() {
        return cells;
    }

    public void setCells(char[][] cells) {
        this.cells = cells;
    }

//    public static void main(String[] args) {
//        BoardRepository boardRepository = new BoardRepository();
//        BoardService boardService = new BoardService();
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                //coordinates[i][j] = 0;
//                boardRepository.getCells()[i][j] = '0';
//            }
//        }
//        int h = 4;
//        int g = 4;
//        boardRepository.getCells()[h][g] = 'F';
//        boardService.tryToSetQueens(boardRepository, 0, h, g);
//        boardRepository.printArray(boardRepository.getCells());
//    }

    //считать F из board
//    private String[] collectQueens(){
//        String[] array = new String[N];
//        for (int i = 0; i < cells.length; i++) {
//            for (int j = 0; j < cells[i].length; j++) {
//                if (cells[i][j] == 'F') {
//                    String s;
//                    s = String.valueOf(i) + String.valueOf(j);
//                    array[i] = s;
//                }
//            }
//        }
//        return array;
//    }

    //считать F из board
    private String[] collectQueens(){
        String[] array = new String[N];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == 'F') {
                    String s;
                    s = String.valueOf(i) + String.valueOf(j);
                    array[i] = s;
                }
            }
        }

        return array;
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
