public class GameController {
    // data are send from mainConsole to controller
    // with the help of controller we can decide
    // --> winner or draw(excute at each inputs)

    // --> wrong moves(exutes at each input)
    Box box = Box.getInstance();

    Winner isGameOver(int key) {
        int[] array_position = convertor(key);
        int row = array_position[0];
        int col = array_position[1];
        // x direction
        if (statusInX(row, col)) {
            return new Winner(true);
        } else if (statusInY(row, col)) {
            return new Winner(true);
        } else if (statusInDiagonal(row, col)) {
            return new Winner(true);
        } else if (statusInDiagonalOpposite(row, col)) {
            return new Winner(true);
        }
        return new Winner(false);

    }

    // opposite diagonal
    private boolean statusInDiagonalOpposite(int r, int c) {
        int row = r;
        int col = c;
        // digonal direction condition upward
        if (row + col != (box.row - 1))
            return false;
        while (row > 0) {
            if (!box.values[row][col].equals(box.values[row - 1][col + 1])) {
                return false;
            }
            row--;
            col++;
        }
        row = r;
        col = c;
        // downward
        while (col > 0) {
            if (!box.values[row][col].equals(box.values[row + 1][col - 1])) {
                return false;
            }
            row++;
            col--;
        }
        return true;

    }

    public boolean statusInX(int r, int c) {
        int row = r;
        int col = c;
        // x direction condition upward
        while (row > 0) {
            if (!box.values[row][col].equals(box.values[row - 1][col])) {
                return false;
            }
            row--;
        }
        row = r;
        col = c;
        // x direction condition downward
        System.out.println(row + " " + box.row);
        while (row < box.row - 1) {
            if (!box.values[row][col].equals(box.values[row + 1][col])) {
                return false;
            }
            row++;
        }
        return true;
    }

    public boolean statusInY(int r, int c) {
        int row = r;
        int col = c;
        // y direction condition left
        while (col > 0) {
            if (!box.values[row][col].equals(box.values[row][col - 1])) {
                return false;
            }
            col--;
        }
        row = r;
        col = c;
        // y direction condition downward
        while (col < box.col - 1) {
            if (!box.values[row][col].equals(box.values[row][col + 1])) {
                return false;
            }
            col++;
        }
        return true;
    }

    public boolean statusInDiagonal(int r, int c) {
        int row = r;
        int col = c;
        // digonal direction condition upward
        if (row != col)
            return false;
        while (row > 0) {
            if (!box.values[row][col].equals(box.values[row - 1][col - 1])) {
                return false;
            }
            row--;
            col--;
        }
        row = r;
        col = c;
        // downward
        while (row < box.row - 1) {
            if (!box.values[row][col].equals(box.values[row + 1][col + 1])) {
                return false;
            }
            row++;
            col++;
        }
        return true;
    }

    public boolean boardSetter(int value, Player player) {
        try {
            int[] rowCol;
            rowCol = convertor(value);

            if (box.values[rowCol[0]][rowCol[1]] != "-")
                throw new Exception();
            box.values[rowCol[0]][rowCol[1]] = player.getSymbol();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("wrong choice try again");
            return false;
        }
        return true;
    }

    private int[] convertor(int value) {
        int[] array = new int[2];

        array[0] = (int) value / (box.row);
        if (value % box.row == 0) {
            array[0] -= 1;
        }

        array[1] = value - (box.row * array[0]) - 1;
        return array;
    }
}
