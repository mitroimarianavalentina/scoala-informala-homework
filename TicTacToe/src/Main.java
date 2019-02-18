
import java.util.Scanner;
    /**
     * This game is a childhood game known as Tic-Tac-Toe. Tic-Tac-Toe is a two-player game, "X" or "0", which marks one box
     * in a row with 3 lines and 3 columns. The player who manages first to score 3 adjacent horizontal, vertical, or
     * diagonal bibs wins the game.
     * This class is the main menu of the game where depending on the positions entered by the players, the methods from
     * the TicTacToe class are called.
     *
     */

    public class Main {
        public static void main(String[] args) {
            int col, row,x;
            x=2;

            // Create game and initialize it.
            // First player will be 'x'
            TicTacToe game = new TicTacToe();

            //Verify is the table is full.
            while (game.isTableFull() == false) {
                Scanner scan = new Scanner(System.in);
                if (x % 2 == 0) {
                    System.out.println("Player 'X', enter your move (row[1-3] column[1-3]):");
                    row = scan.nextInt();
                    col = scan.nextInt();

                    //Checking if the entered move is eligible(the position is empty/the position is already defined).
                    //If the move is eligible it will be saved and the player mark will be changed.
                    if(game.placeMark(row-1, col-1)){
                        x=x+1;
                        game.changePlayer();
                    }
                    game.printBoard();

                    //Is printing the winner
                    if (game.checkIfWin()) {
                        System.out.println("Player 'X' won!");
                        break;
                    }
                }
                else if(x%2==1){
                    System.out.println("Player 'O', enter your move (row[1-3] column[1-3]):");
                    row = scan.nextInt();
                    col = scan.nextInt();

                    //Checking if the entered move is eligible(the position is empty/the position is already defined).
                    //If the move is eligible it will be saved and the player mark will be changed.
                    if(game.placeMark(row-1, col-1)){
                        x=x+1;
                        game.changePlayer();
                    }
                    game.printBoard();

                    //Is printing the winner
                    if (game.checkIfWin()) {
                        System.out.println("Player 'O' won!");
                        break;
                    }
                }
            }
        }
    }



