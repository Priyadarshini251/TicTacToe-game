import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon && !isBoardFull()) {
            printBoard();
            System.out.print("Player " + currentPlayer + ", choose a cell (1-9): ");
            int move = scanner.nextInt();
            if (makeMove(move)) {
                gameWon = checkWin();
                if (!gameWon) {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        printBoard();
        if (gameWon) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        scanner.close();
    }

    static void printBoard() {
        System.out.println();
        for (char[] row : board) {
            System.out.println(" " + row[0] + " | " + row[1] + " | " + row[2]);
            if (row != board[2]) {
                System.out.println("---|---|---");
            }
        }
        System.out.println();
    }

    static boolean makeMove(int cell) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == (char) ('0' + cell)) {
                    board[i][j] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }

    static boolean checkWin() {
        // Check rows, columns and diagonals
        for (int i = 0; i < 3; i++)
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;

        for (int j = 0; j < 3; j++)
            if (board[0][j] == currentPlayer &&
                board[1][j] == currentPlayer &&
                board[2][j] == currentPlayer)
                return true;

        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }

    static boolean isBoardFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell >= '1' && cell <= '9')
                    return false;
        return true;
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
