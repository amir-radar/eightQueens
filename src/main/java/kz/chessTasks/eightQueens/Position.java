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

    public String coordinate;

    public String convertToPosition(String s){
        System.out.println(s);
        if (s.charAt(0) == '0')
            coordinate = "A" + s.charAt(1);
        else if (s.charAt(0) == '1')
            coordinate = "B" + s.charAt(1);
        else if (s.charAt(0) == '2')
            coordinate = "C" + s.charAt(1);
        else if (s.charAt(0) == '3')
            coordinate = "D" + s.charAt(1);
        else if (s.charAt(0) == '4')
            coordinate = "E" + s.charAt(1);
        else if (s.charAt(0) == '5')
            coordinate = "F" + s.charAt(1);
        else if (s.charAt(0) == '6')
            coordinate = "G" + s.charAt(1);
        else if (s.charAt(0) == '7')
            coordinate = "H" + s.charAt(1);
        //else
        //Тут выводить ошибку

        return coordinate;
    }
}
