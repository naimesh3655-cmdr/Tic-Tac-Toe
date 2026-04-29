public class TicTacToe {

    static char[][] board = {
        {'X', 'X', 'X'},
        {'-', 'O', '-'},
        {'O', '-', 'O'}
    };

    // Display board
    public static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // UC9: Detect winner
    public static boolean checkWin(char symbol) {

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }

        // Check opposite diagonal
        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        displayBoard();

        if (checkWin('X')) {
            System.out.println("Player X wins!");
        } else if (checkWin('O')) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("No winner yet.");
        }
    }
}