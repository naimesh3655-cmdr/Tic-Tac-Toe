import java.util.Random;

public class TicTacToe {

    // Method to place symbol on board
    public static void updateBoard(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Method to display board
    public static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to check valid move
    public static boolean isValidMove(char[][] board, int row, int col) {
        return board[row][col] == '-';
    }

    // UC7: Computer random valid move
    public static void computerRandomMove(char[][] board) {
        Random random = new Random();

        int slot, row, col;

        do {
            slot = random.nextInt(9) + 1; // Generate slot 1–9
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (!isValidMove(board, row, col));

        updateBoard(board, row, col, 'O');
        System.out.println("Computer placed O in slot " + slot);
    }

    public static void main(String[] args) {

        char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
        };

        int row = 1;
        int col = 1;
        char symbol = 'X';

        System.out.println("Before Player Move:");
        displayBoard(board);

        updateBoard(board, row, col, symbol);

        System.out.println("After Player Move:");
        displayBoard(board);

        computerRandomMove(board);

        System.out.println("After Computer Move:");
        displayBoard(board);
    }
}
