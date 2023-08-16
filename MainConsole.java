import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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

            } while (!controller.boardSetter(scan.nextInt(), player1));

            do {
                System.out.println(new String(new char[100]).replace("\0", "-"));
                box.displayTheBox();
                box.displayTheKeyBox();
                System.out.println("player 2  " + " ( " + player2.symbol + " )");
                System.out.println("enter the value:");
            } while (!controller.boardSetter(scan.nextInt(), player2));

        }
    }
}
