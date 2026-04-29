#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

char board[9] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

void displayBoard() {
    cout << endl;
    for (int i = 0; i < 9; i += 3) {
        cout << board[i] << " | " << board[i + 1] << " | " << board[i + 2] << endl;
        if (i < 6)
            cout << "--+---+--" << endl;
    }
    cout << endl;
}

bool isValidMove(int slot) {
    return slot >= 1 && slot <= 9 && board[slot - 1] == ' ';
}

void computerRandomMove() {
    int slot;

    do {
        slot = rand() % 9 + 1;   // Generate random slot 1–9
    } while (!isValidMove(slot)); // Loop until valid

    board[slot - 1] = 'O';       // Place computer symbol
    cout << "Computer placed O in slot " << slot << endl;
}

int main() {
    srand(time(0)); // Seed random number generator

    displayBoard();
    computerRandomMove();
    displayBoard();

    return 0;
}