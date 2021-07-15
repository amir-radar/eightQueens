package kz.chessTasks.eightQueens;

public class Board {
    public final int N = 8;
    private char[][] cells = new char[N][N];

//    public static void main(String[] args) {
//        Board board = new Board();
//        for (int i = 0; i < 8; i++){
//            for (int j = 0; j < 8; j++){
//                board.cells[i][j] = '0';
//            }
//        }
//
//        board.cells[2][6] = 'F';
//
//        board.purchaseQueens(0);
//
//        //System.out.println(board.checkPurchase(0, 2));
//
//        board.printArray(board.cells);
//
//    }

    public String[] insertQueen(int x, int y){
        cells[x][y] = 'F';
        purchaseQueens(0);
        return collectQueens();
    }

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

    private boolean purchaseQueens(int z){
        if (z==N) return true;
        for (int i = 0; i < N; i++)
            if (checkPurchase(z, i)){
                cells[z][i] = 'F';
                if (purchaseQueens(z + 1)){
                    return true;
                }
                cells[z][i] = '0';
            }
        return false;
    }

    private boolean checkPurchase(int x, int y){
        for (int z = 0; z < x; z++){
            if(!checkPurchaseHorizontallyAndVertically(x, y)) return false;
            if(!checkPurchaseDiagonallyDown(x, y)) return false;
            if(!checkPurchaseDiagonallyUp(y, x)) return false;
        }
        return true;
    }

    private boolean checkPurchaseHorizontallyAndVertically(int x, int y){
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][x] == 'F' || cells[y][i] == 'F') {
                return false;
            }
        }
        return true;
    }

    private boolean checkPurchaseDiagonallyDown(int x, int y){
        //Разница между координатами
        int a;
        if (x>y) a=x-y; else a=y-x;

        if (y>x) {
            for (int i = a; i < N; i++) {
                if (cells[i - a][i] == 'F')
                    return false;
            }
        } else {
            for (int i = 0; i < N - a; i++)
                if (cells[i + a][i] == 'F')
                    return false;
        }
        return true;
    }

    private boolean checkPurchaseDiagonallyUp(int x, int y){
        /*
        Перепроверить, так как может быть отрицательное значение
         */
        int b;
        b=x+y-(N-1);

        if (x+y > N-1) {
            for (int i = b; i < N; i++)
                if (cells[i][x + y - i] == 'F')
                    return false;
        } else {
            for (int i = 0; i < x + y; i++)
                if (cells[i][x + y - i] == 'F')
                    return false;
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
