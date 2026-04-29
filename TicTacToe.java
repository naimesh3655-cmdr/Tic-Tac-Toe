#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

char board[3][3] = {
    {'-', '-', '-'},
    {'-', '-', '-'},
    {'-', '-', '-'}
};

// Method to place symbol on board
void updateBoard(int row, int col, char symbol) {
    board[row][col] = symbol;
}

// Method to display board
void displayBoard() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
}

// Method to check valid move
bool isValidMove(int row, int col) {
    return board[row][col] == '-';
}

// UC7: Computer random valid move
void computerRandomMove() {
    int slot, row, col;

    do {
        slot = rand() % 9 + 1;   // Generate slot 1–9
        row = (slot - 1) / 3;
        col = (slot - 1) % 3;
    } while (!isValidMove(row, col));

    updateBoard(row, col, 'O');
    cout << "Computer placed O in slot " << slot << endl;
}

int main() {
    srand(time(0));

    int row = 1;
    int col = 1;
    char symbol = 'X';

    cout << "Before Player Move:" << endl;
    displayBoard();

    updateBoard(row, col, symbol);

    cout << "After Player Move:" << endl;
    displayBoard();

    computerRandomMove();

    cout << "After Computer Move:" << endl;
    displayBoard();

    return 0;
}