import java.util.Objects;
import java.util.Scanner;
import cross.Game;

public class Main {
    public static void main(String[] args){
        boolean running = true;

        // Главный цикл
        while (running) {

            // Определение класса игры
            Scanner in = new Scanner(System.in);
            System.out.print("Выберете, за кого будете играть: ");
            String player = in.nextLine();
            Game game = new Game(player);

            // Цикл игры
            while (true) {
                if (game.turn == game.player) {
                    game.show_board();
                    System.out.println("Ваш ход: ");
                    int x = Integer.parseInt(in.nextLine());
                    int y = Integer.parseInt(in.nextLine());
                    if (!game.move(x - 1, y -1 )) {
                        System.out.print("Некорректный ввод. Попробуйте еще раз");
                    }
                    continue;
                } else {
                    game.ai();
                }
                if (game.is_finished() == 0) {
                    System.out.println("Победили X!");
                    break;
                } else if (game.is_finished() == 1) {
                    System.out.println("Победили 0!");
                    break;
                }
            }

            // Обновление цикла
            System.out.print("Сыграем еще раз?");
            String repeat = in.nextLine();
            if (Objects.equals(repeat, "Нет")) {
                System.out.println("Спасибо за игру!");
                running = false;
            }

        }
    }
}
