public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

        // Initialize the board with '-'
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Display the empty Tic-Tac-Toe board
        System.out.println("Tic-Tac-Toe Board");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}