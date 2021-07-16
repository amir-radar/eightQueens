package kz.chessTasks.eightQueens;

public class Position {
    private char vert;
    private char horiz;

    public String coordinate;

    public String convertToMassiveCoordinate(String s){
        if (s.charAt(0) == 'A')
            coordinate = "0" + s.charAt(1);
        else if (s.charAt(0) == 'B')
            coordinate = "1" + s.charAt(1);
        else if (s.charAt(0) == 'C')
            coordinate = "2" + s.charAt(1);
        else if (s.charAt(0) == 'D')
            coordinate = "3" + s.charAt(1);
        else if (s.charAt(0) == 'E')
            coordinate = "4" + s.charAt(1);
        else if (s.charAt(0) == 'F')
            coordinate = "5" + s.charAt(1);
        else if (s.charAt(0) == 'G')
            coordinate = "6" + s.charAt(1);
        else if (s.charAt(0) == 'H')
            coordinate = "7" + s.charAt(1);
        //else
        //Тут выводить ошибку

        return coordinate;
    }

    public String convertToChessCoordinate(String s){
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
