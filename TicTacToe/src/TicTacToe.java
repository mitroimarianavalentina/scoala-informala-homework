public class TicTacToe {
    private char[][] position;
    private char optionsPlayer;

    /**
     * constructor of the class
     * call for the @method setTheTableEmpty() to set te empty table
     */
    public TicTacToe() {
        position = new char[3][3];
        optionsPlayer = 'X';
        setTheTableEmpty();
    }

    /**
     * method to make the TicTacToe table empty
     */
    public void setTheTableEmpty() {
        for (int i = 0; i < this.position.length; i++) {
            for (int j = 0; j < this.position.length; j++)
                position[i][j] = ' ';
        }
    }

    // Print the current board (may be replaced by GUI implementation later)
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(position[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
    }

    // Loop through rows and see if any are winners.
    private boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(position[i][0], position[i][1], position[i][2]) == true) {
                return true;
            }
        }
        return false;
    }

    // Loop through columns and see if any are winners.
    private boolean checkCol() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(position[0][i], position[1][i], position[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagonal() {
        return ((checkRowCol(position[0][0], position[1][1], position[2][2]) == true)) ||
                ((checkRowCol(position[0][2], position[1][1], position[2][0]) == true));
    }

    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean checkIfWin() {
        return (checkRow() || checkCol() || checkDiagonal());
    }

    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isTableFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (position[i][j] == ' ') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {
        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (position[row][col] == ' ') {
                    position[row][col] = optionsPlayer;
                    return true;
                } else {
                    int row1 = row + 1;
                    int col1 = col + 1;
                    System.out.println("This move at (" + row1 + "," + col1 + ") is not valid. Try again...");
                }
            } else System.out.println("The value entered for column have to be between 1-3!!");

        } else System.out.println("The value entered for row have to be between 1-3!!");
        return false;
    }

    // Change player marks back and forth.
    public void changePlayer() {
        if (optionsPlayer == 'X') {
            optionsPlayer = 'O';
        } else {
            optionsPlayer = 'X';
        }
    }

}

