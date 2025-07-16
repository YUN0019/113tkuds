

public class TicTacToeGame {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    /**
     * 初始化 5x5 的井字遊戲棋盤
     */
    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    /**
     * 列印棋盤，包含行列座標
     */
    static void printBoard(char[][] board) {
        System.out.println("\n=== 5x5 井字遊戲 ===");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col]);
                if (col < SIZE - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 放置棋子
     */
    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.printf("無效座標：(%d, %d)\n", row, col);
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.printf("位置 (%d, %d) 已被佔用\n", row, col);
            return false;
        }
        board[row][col] = player;
        System.out.printf("玩家 %c 在位置 (%d, %d) 放置棋子\n", player, row, col);
        return true;
    }

    /**
     * 檢查是否有玩家獲勝（5 連線）
     */
    static char checkWinner(char[][] board) {
        // 檢查每一格，往四個方向檢查 5 連線
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char player = board[row][col];
                if (player == EMPTY) continue;
                // 檢查橫向
                if (col + 4 < SIZE &&
                    player == board[row][col+1] &&
                    player == board[row][col+2] &&
                    player == board[row][col+3] &&
                    player == board[row][col+4]) {
                    return player;
                }
                // 檢查縱向
                if (row + 4 < SIZE &&
                    player == board[row+1][col] &&
                    player == board[row+2][col] &&
                    player == board[row+3][col] &&
                    player == board[row+4][col]) {
                    return player;
                }
                // 檢查主對角線
                if (row + 4 < SIZE && col + 4 < SIZE &&
                    player == board[row+1][col+1] &&
                    player == board[row+2][col+2] &&
                    player == board[row+3][col+3] &&
                    player == board[row+4][col+4]) {
                    return player;
                }
                // 檢查反對角線
                if (row + 4 < SIZE && col - 4 >= 0 &&
                    player == board[row+1][col-1] &&
                    player == board[row+2][col-2] &&
                    player == board[row+3][col-3] &&
                    player == board[row+4][col-4]) {
                    return player;
                }
            }
        }
        return EMPTY;
    }

    /**
     * 檢查棋盤是否已滿
     */
    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;
        printBoard(board);
        while (true) {
            System.out.printf("玩家 %c 輸入 row col：", currentPlayer);
            int row, col;
            if (sc.hasNextInt()) {
                row = sc.nextInt();
            } else {
                System.out.println("請輸入數字");
                sc.next();
                continue;
            }
            if (sc.hasNextInt()) {
                col = sc.nextInt();
            } else {
                System.out.println("請輸入數字");
                sc.next();
                continue;
            }
            if (!placePiece(board, row, col, currentPlayer)) {
                continue;
            }
            printBoard(board);
            char winner = checkWinner(board);
            if (winner != EMPTY) {
                System.out.printf("\n玩家 %c 獲勝！\n", winner);
                break;
            } else if (isBoardFull(board)) {
                System.out.println("\n平手！");
                break;
            }
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }
        sc.close();
    }
}


