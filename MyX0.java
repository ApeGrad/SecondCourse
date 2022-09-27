package SecondLessonMassives;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyX0 {
    public static boolean isWin = false;
    public static String player;
    public static String player2;
    public static String currentPlayer;
    static String[] players = {"Борич", "Катюха"};

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int random = (int) (Math.random() * 2 + 1);
        if (random == 1) {
            player = players[0];
            currentPlayer = player;

        } else {
            player2 = players[1];
            currentPlayer = player2;
        }

        System.out.println("Введите номер на поле, чтобы походить: ");
        char [][] field = {{'1','2','3'},
                           {'4','5','6'},
                           {'7','8','9'}};

        char symbol;
        int userAction=0;
        while(true){
            checkMove(currentPlayer);
            System.out.println("Ходит " + currentPlayer);
            if(userAction % 2 == 0){
                symbol = 'X';
            }
            else {
                symbol='O';
            }
            printNewField(field);
            int number = 0;
            try {
                number = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                System.out.println("Только цифры!");
            }
            if(Arrays.deepToString(field).contains(Integer.toString(number)) && number < 10 && number > 0){
                switch (number){
                    case 1:
                        field[0][0] = symbol;
                        break;
                    case 2:
                        field[0][1] = symbol;
                        break;
                    case 3:
                        field[0][2] = symbol;
                        break;
                    case 4:
                        field[1][0] = symbol;
                        break;
                    case 5:
                        field[1][1] = symbol;
                        break;
                    case 6:
                        field[1][2] = symbol;
                        break;
                    case 7:
                        field[2][0] = symbol;
                        break;
                    case 8:
                        field[2][1] = symbol;
                        break;
                    case 9:
                        field[2][2] = symbol;
                        break;
                }
            } else {
                System.out.println("Введите оставшееся число на поле: ");
                continue;
            }
            checkForWin(field);
            if(isWin){
                if(currentPlayer.equals(players[1])){
                    System.out.println(currentPlayer + " выиграла!");
                    printNewField(field);
                    break;
                }
            }
            if(isWin){
                System.out.println(currentPlayer + " выиграл!");
                printNewField(field);
                break;
            }
            userAction++;
        }
    }

    public static void printNewField(char[][]field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if(j!=2) {
                    System.out.print(field[i][j] + "|");
                }
                else {
                    System.out.print(field[i][j]);
                }
                }
                System.out.println();
            }
        }

    public static void checkForWin(char[][]field){
        for (int i = 0; i < field.length; i++) {
            if(field[i][0]==field[i][1] && field[i][0]==field[i][2]||
                field[0][i]==field[1][i] && field[0][i]==field[2][i]||
                field[0][0]==field[1][1] && field[0][0]==field[2][2]||
                field[2][0]==field[1][1] && field[2][0]==field[0][2]) {
                isWin = true;
                break;
            }
        }
    }
    static String checkMove(String player) {

        while (true) {
            if(currentPlayer.equals(players[0])){
                player = players[1];
                currentPlayer = player;
            } else if(currentPlayer.equals(players[1])){
                player = players[0];
                currentPlayer = player;
            }
            return currentPlayer;

        }
    }
}
