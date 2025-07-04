import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static char[][] board = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("======================================");
            System.out.println("      Welcome to Tic Tac Toe Game     ");
            System.out.println("======================================");
            System.out.println("You are 'X' and the computer is 'O'\n");

            int round = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("How many rounds do you want to play? (1 or 3): ");
                    round = scanner.nextInt();
                    if (round == 1 || round == 3) {
                        validInput = true;
                    } else {
                        System.out.println("Please choose either 1 or 3.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number (1 or 3).");
                    scanner.next(); // Clear invalid input
                }
            }

            playGame(round);

            System.out.print("Do you want to play again? (yes/no): ");
            scanner.nextLine(); // clear newline
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("yes");
        }

        System.out.println("Thanks for playing! Goodbye!");
    }

    public static void initializeBoard() {
        char number = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = number++;
            }
        }
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static void playGame(int round) {
        int playerWins = 0;
        int computerWins = 0;
        int currentRound = 1;

        while (currentRound <= round) {
            System.out.println("\n===== Round " + currentRound + " =====");
            initializeBoard();
            printBoard();

            while (true) {
                playerMove();
                if (checkWinner('X')) {
                    System.out.println("🎉 You won Round " + currentRound + "!");
                    playerWins++;
                    break;
                }

                if (isBoardFull()) {
                    System.out.println("It's a draw in Round " + currentRound + "!");
                    break;
                }

                computerMove();
                if (checkWinner('O')) {
                    System.out.println("💻 Computer won Round " + currentRound + "!");
                    computerWins++;
                    break;
                }

                if (isBoardFull()) {
                    System.out.println("It's a draw in Round " + currentRound + "!");
                    break;
                }
            }

            currentRound++;
        }

        System.out.println("\n========== Game Over ==========");
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);

        if (playerWins > computerWins) {
            System.out.println("🏆 You are the overall winner!");
        } else if (playerWins < computerWins) {
            System.out.println("💻 Computer is the overall winner!");
        } else {
            System.out.println("🤝 It's an overall draw!");
        }
    }

    public static void playerMove() {
        int position, row, col;
        boolean valid = false;
        char symbol = 'X';


        while (!valid) {
            System.out.print("Choose a position (1-9): ");

            try {


                position = scanner.nextInt();

                if (position < 1 || position > 9) {
                    System.out.println("Please choose a number between 1 and 9.");
                    continue;
                }

                row = (position - 1) / 3;
                col = (position - 1) % 3;

                if (isValidMove(row, col)) {
                    board[row][col] = symbol;
                    valid = true;
                } else {
                    System.out.println("Position already taken. Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        printBoard();
    }

    public static void computerMove() {
        int position, row, col;
        boolean valid = false;
        char symbol = 'O';

        System.out.println("Computer Turn:");

        do {
            position = random.nextInt(9) + 1;
            row = (position - 1) / 3;
            col = (position - 1) % 3;

            if (isValidMove(row, col)) {
                board[row][col] = symbol;
                valid = true;
            }
        } while (!valid);

        printBoard();
    }

    public static boolean isValidMove(int row, int col) {
        return board[row][col] != 'X' && board[row][col] != 'O';
    }

    public static boolean checkWinner(char symbol) {
        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] + board[i][1] + board[i][2]) == symbol * 3 ||
                    (board[0][i] + board[1][i] + board[2][i]) == symbol * 3)
                return true;
        }
        // Diagonals
        if ((board[0][0] + board[1][1] + board[2][2]) == symbol * 3 ||
                (board[0][2] + board[1][1] + board[2][0]) == symbol * 3)
            return true;

        return false;
    }

    public static boolean isBoardFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell != 'X' && cell != 'O')
                    return false;
        return true;
    }
}