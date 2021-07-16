package kz.chessTasks.eightQueens;

public class Position {
    private char horiz; //A, B, C ...
    private char vert;  //1, 2, 3 ...

    public char getHoriz() {
        return horiz;
    }

    public char getVert() {
        return vert;
    }

    public void setHoriz(char horiz) {
        this.horiz = horiz;
    }

    public void setVert(char vert) {
        this.vert = vert;
    }
}
