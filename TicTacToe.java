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

    // Check win
    public static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;

            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    // Check draw
    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {

            displayBoard();

            System.out.println("Player " + currentPlayer + " turn");
            System.out.print("Enter row and column (0-2): ");

            int row = input.nextInt();
            int col = input.nextInt();

            if (board[row][col] == '-') {

                board[row][col] = currentPlayer;

                if (checkWin(currentPlayer)) {
                    displayBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } 
                else if (checkDraw()) {
                    displayBoard();
                    System.out.println("Game is a draw!");
                    gameOver = true;
                } 
                else {
                    // Switch turn
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        input.close();
    }
}