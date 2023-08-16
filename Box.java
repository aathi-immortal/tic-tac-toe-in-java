import java.util.*;

/**
 * Box
 */
public class Box {
    public String[][] values;
    int size, row, col;

    private static Box object = null;

    private Box() {

    }

    private void setValuesEmpty() {
        row = (int) Math.sqrt(size);
        col = (int) Math.sqrt(size);

        values = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                values[i][j] = "-";
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        setValuesEmpty();
    }

    public static Box getInstance() {
        if (object == null)

            object = new Box();

        return object;
    }

    void displayTheBox() {
        System.out.println("\t\t\t\tgame bord !!!");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("\t\t" + values[i][j] + "\t\t");
            }
            System.out.println("\n\n\n");

        }
        System.out.println();
    }

    void displayTheKeyBox() {
        System.out.println("\t\t\t\thelp bord !!!");
        for (int i = 0; i < size; i++) {
            if ((i % (int) Math.sqrt(size)) == 0)
                System.out.println("\n\n\n");
            System.out.print("\t\t" + (i + 1) + "\t\t");
        }
        System.out.println();
    }

}