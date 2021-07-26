package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

boolean RunningGame = true;

        while (RunningGame == true) {
            int Zug = 0;
            int Winner = -1;
            int Spieler = 1;
            int[] Spielebrett = new int[9];
            for (int i = 0; i < Spielebrett.length; i++) {
                Spielebrett[i] = -1;
            }

            while (Winner == -1) {
                printBoard(Spielebrett);
                doTurn(Spieler);
                Spielebrett[playTurn(Spielebrett)] = Spieler;
                Winner = checkWinner(Spielebrett);
                if (Winner == -1) {
                    Spieler = changeTurn(Spieler);
                }
            }
            RunningGame = endGame(Spieler);
            }
        }






    // check if there is an Winner, if there is return int Value of Player else default Value
    public static int checkWinner (int [] board) {

        if (board[0] == board[1] && board[1] == board[2] && board[0] != -1) {
            return board[0];
        }
        else if (board[3] == board[4] && board[4] == board[5] && board[3] != -1) {
            return board[3];
        }
        else if (board[6] == board[7] && board[7] == board[8] && board[6] != -1) {
            return board[6];
        }
        else if (board[0] == board[3] && board[3] == board[6] && board[0] != -1) {
            return board[0];
        }

        else if (board[1] == board[4] && board[4] == board[7] && board[1] != -1) {
                return board[1];
        }

        else if (board[2] == board[5] && board[5] == board[8] && board[2] != -1) {
            return board[2];
        }

        else if (board[0] == board[4] && board[4] == board[8] && board[0] != -1) {
            return board[0];
        }

        else if (board[2] == board[4] && board[4] == board[6] && board[2] != -1) {
            return board[2];
        }
        else {return -1;}
    }





    //Methode zum ausfuehren des Spielzugs:

    private static int playTurn (int [] Currentfield) {
        Scanner sc = new Scanner(System.in);
        int fieldnumber = sc.nextInt() - 1;
        int [] Currentfield1 = Currentfield;
        if (Currentfield [fieldnumber] != 1 && Currentfield [fieldnumber] != 2) {
         return fieldnumber;}
        else {System.out.println("Falsche Eingabe!");return playTurn(Currentfield);}}



    //Methode um Spieler zu wechseln:

    private static int changeTurn(int player){
        if (player == 1){player = 2;}
        else if (player == 2){player = 1;}
        return player;}

    //Methode um den aktuellen Spieler feld auswaehlen zu lassen
    public static void doTurn(int Player) {
        if (Player == 1) {
            System.out.println("Spieler" + " " + Player + ". Sie sind dran!");
        } else if (Player == 2) {
            System.out.println("Spieler " + Player + ". Sie sind dran!");
        }
    }

    //Methode um das aktuelle Spielbrett auszugeben
    public static void printBoard (int [] board) {
        System.out.println("|"+board[0]+"|"+board[1]+"|"+board[2]+"|");
        System.out.println("|"+board[3]+"|"+board[4]+"|"+board[5]+"|");
        System.out.println("|"+board[6]+"|"+board[7]+"|"+board[8]+"|");
    }

    // Methode - Spielende
    public static boolean endGame (int Spieler ) {
        System.out.println("Spieler " + Spieler + ". Sie haben Gewonnen!");
        System.out.println("________________________________--------------");
        System.out.println("Eine neue Runde beginnen? Y - for Yes / N - No");
        Scanner sc1 = new Scanner(System.in);
        String Eingabe = sc1.nextLine();
        if (Eingabe.equals("n") || Eingabe.equals("N")) {
            System.out.println("Dann eben nicht...... ");
             return false;}
        else {return true;}
    }
}
