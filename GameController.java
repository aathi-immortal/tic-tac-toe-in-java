public class GameController {
    // data are send from mainConsole to controller
    // with the help of controller we can decide
    // --> winner or draw(excute at each inputs)

    // --> wrong moves(exutes at each input)
    Box box = Box.getInstance();

    // private void checker() {

    // }

    // private boolean validMove(int value) {

    // if (value >= 0 && value <= box.getSize() && ) {

    // }
    // }

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
