public class TicTacToe {

    // Method to validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Check row and column bounds
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
            {'-', '-', '-'},
            {'-', 'X', '-'},
            {'-', '-', '-'}
        };

        int row = 1;
        int col = 1;

        if (isValidMove(board, row, col)) {
            System.out.println("Move Accepted");
        } else {
            System.out.println("Move Rejected");
        }
    }
}