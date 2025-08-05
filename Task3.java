import java.util.Scanner;

public class Task3 {

    // Main method with input handling
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];

        System.out.println("Enter the Sudoku puzzle row by row (use 0 for empty cells):");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        if (solveSudoku(board)) {
            System.out.println("Sudoku Solved:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }

    // Solve using backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = 0; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // puzzle is complete
    }

    // Check if placing a number is valid
    public static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Print the Sudoku board
    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
