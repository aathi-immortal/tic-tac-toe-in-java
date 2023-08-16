import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        int key;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("enter the board size:");

            int size = scan.nextInt();
            Box box = Box.getInstance();

            box.setSize(size);
            GameController controller = new GameController();

            Player player1 = new Player();
            Player player2 = new Player();
            player1.setSymbol("O");
            player2.setSymbol("X");
            System.out.println();
            while (true) {
                do {
                    System.out.println(new String(new char[100]).replace("\0", "-"));
                    box.displayTheBox();
                    box.displayTheKeyBox();
                    System.out.println("player 1  " + " ( " + player1.symbol + " )");
                    System.out.println("enter the value:");
                    key = scan.nextInt();
                } while (!controller.boardSetter(key, player1));
                if (controller.isGameOver(key).isMatchOver) {
                    System.out.println("Winner of the game is  " + player1.symbol);
                    break;
                }
                do {
                    System.out.println(new String(new char[100]).replace("\0", "-"));
                    box.displayTheBox();
                    box.displayTheKeyBox();
                    System.out.println("player 2  " + " ( " + player2.symbol + " )");
                    System.out.println("enter the value:");
                    key = scan.nextInt();
                } while (!controller.boardSetter(key, player2));
                if (controller.isGameOver(key).isMatchOver) {
                    System.out.println("Winner of the game is  " + player1.symbol);
                    break;
                }
            }
        }

    }
}
