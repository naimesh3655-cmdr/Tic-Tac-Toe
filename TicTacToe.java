import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
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

    // Update board
    public static void updateBoard(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Check valid move
    public static boolean isValidMove(int row, int col) {
        return board[row][col] == '-';
    }

    // Computer random move
    public static void computerRandomMove() {
        Random random = new Random();

        int slot, row, col;

        do {
            slot = random.nextInt(9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (!isValidMove(row, col));

        updateBoard(row, col, 'O');
        System.out.println("Computer placed O in slot " + slot);
    }

    // Check winner
    public static boolean checkWin(char symbol) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol)
                return true;

            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol)
                return true;
        }

        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol)
            return true;

        return false;
    }

    // UC10: Check draw
    public static boolean checkDraw() {

        boolean emptyFound = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == '-') {
                    emptyFound = true;
                }
            }
        }

        if (!emptyFound && !checkWin('X') && !checkWin('O')) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {

            displayBoard();

            // Player move
            System.out.print("Enter row and column (0-2): ");
            int row = input.nextInt();
            int col = input.nextInt();

            if (isValidMove(row, col)) {

                updateBoard(row, col, 'X');

                if (checkWin('X')) {
                    displayBoard();
                    System.out.println("Player X wins!");
                    gameOver = true;
                }
                else if (checkDraw()) {
                    displayBoard();
                    System.out.println("Game is a draw!");
                    gameOver = true;
                }
                else {

                    // Computer move
                    computerRandomMove();

                    if (checkWin('O')) {
                        displayBoard();
                        System.out.println("Computer wins!");
                        gameOver = true;
                    }
                    else if (checkDraw()) {
                        displayBoard();
                        System.out.println("Game is a draw!");
                        gameOver = true;
                    }
                }

            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        input.close();
    }
}