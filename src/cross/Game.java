package cross;

import java.util.Objects;

public class Game {
    int[][] board =
    {
        {2, 2, 2},
        {2, 2, 2},
        {2, 2, 2}
    };
    public byte player;
    byte ai_player;
    public byte turn = 0;

    public Game(String player) {
        if (Objects.equals(player, "X")){
            this.player = 0;
            this.ai_player = 1;
        } else {
            this.player = 1;
            this.ai_player = 0;
        }
    }

    public boolean move(int x, int y) {
        if (board[x][y] == 2) {
            if (turn == 0) {
                board[x][y] = 1;
                turn = 1;
            } else {
                board[x][y] = 0;
                turn = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    public void ai() {
        int x = (int) (Math.random() * 3);
        int y = (int) (Math.random() * 3);
        move(x, y);
    }

    public void show_board(){
        for (int[] ints : board) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    System.out.print("0 ");
                } else if (anInt == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public int is_finished() {
        if (board[0][0] == board[0][1] & board[0][0] == board[0][2] & board[0][0] == 0) {
            return 0;
        } else if (board[1][0] == board[1][1] & board[1][0] == board[1][2] & board[1][0] == 0) {
            return 0;
        } else if (board[2][0] == board[2][1] & board[2][0] == board[2][2] & board[2][0] == 0) {
            return 0;
        } else if (board[0][0] == board[1][1] & board[0][0] == board[2][2] & board[2][0] == 0) {
            return 0;
        } else if (board[0][2] == board[1][1] & board[0][2] == board[2][0] & board[2][0] == 0) {
            return 0;
        } else if (board[0][1] == board[1][1] & board[0][1] == board[2][1] & board[2][0] == 0){
            return 0;
        } else if (board[0][0] == board[0][1] & board[0][0] == board[0][2] & board[0][0] == 1) {
            return 1;
        } else if (board[1][0] == board[1][1] & board[1][0] == board[1][2] & board[1][0] == 1) {
            return 1;
        } else if (board[2][0] == board[2][1] & board[2][0] == board[2][2] & board[2][0] == 1) {
            return 1;
        } else if (board[0][0] == board[1][1] & board[0][0] == board[2][2] & board[2][0] == 1) {
            return 1;
        } else if (board[0][2] == board[1][1] & board[0][2] == board[2][0] & board[2][0] == 1) {
            return 1;
        } else if (board[0][1] == board[1][1] & board[0][1] == board[2][1] & board[2][0] == 1){
            return 0;
        } else {
            return 2;
        }
    }
}
