import java.security.InvalidParameterException;

public class TicTacToe {
    private Board gameBoard;

    public TicTacToe() {
        this.gameBoard = new Board();
    }

    //Given character matrix , check if any character exist in cell at given location
    private void checkPositionEmpty(char board[][], POSITION y, POSITION x) throws CellNotEmptyException {
        char cellValue = board[y.getValue()][x.getValue()];
        if (cellValue != '\u0000')
            throw new CellNotEmptyException(y.toString() + " " + x.toString() + " cell already filled with " + cellValue);
    }

    //Mark cell at given location with given mark
    public void markCellAt(POSITION y, POSITION x, char markWith) throws CellNotEmptyException {

        //Get current gameboard
        char currentBoard[][] = gameBoard.getBoardFlags();

        //Check if given cell is empty, if it is not, it will throw an exception
        checkPositionEmpty(currentBoard, y, x);

        //Mark Cell
        currentBoard[y.getValue()][x.getValue()] = markWith;

        //Print info to console
        System.out.println(y.toString() + " " + x.toString() + " marked with " + markWith);
    }


    //Check game's state (O wins, X wins, Tie or game is still alive)
    public STATE checkState() {

        //Check all row, col and corners and find winner if exists
        char winner = StringOperation.checkCharWithAllSameInAnyString(
                new String[]{
                        gameBoard.getNthRow((short) 0),
                        gameBoard.getNthRow((short) 1),
                        gameBoard.getNthRow((short) 2),
                        gameBoard.getNthCol((short) 0),
                        gameBoard.getNthCol((short) 1),
                        gameBoard.getNthCol((short) 2),
                        gameBoard.getCorner(false),
                        gameBoard.getCorner(true)
                }
        );

        return winner == 'O' ? STATE.O_WON :
               winner == 'X' ? STATE.X_WON :
          gameBoard.isFUll() ? STATE.TIE : STATE.ALIVE;
    }

    // Set gameboard using string like "OXOXOXOXO"
    public void setGameBoardByString(String arr) throws InvalidParameterException{

        if(arr.length()>9)
            throw new InvalidParameterException("String length must be greather than 9");

        try {
            markCellAt(POSITION.TOP, POSITION.LEFT, arr.charAt(0));
            markCellAt(POSITION.TOP, POSITION.MIDDlE, arr.charAt(1));
            markCellAt(POSITION.TOP, POSITION.RIGHT, arr.charAt(2));
            markCellAt(POSITION.MIDDlE, POSITION.LEFT, arr.charAt(3));
            markCellAt(POSITION.MIDDlE, POSITION.MIDDlE, arr.charAt(4));
            markCellAt(POSITION.MIDDlE, POSITION.RIGHT, arr.charAt(5));
            markCellAt(POSITION.BOTTOM, POSITION.LEFT, arr.charAt(6));
            markCellAt(POSITION.BOTTOM, POSITION.MIDDlE, arr.charAt(7));
            markCellAt(POSITION.BOTTOM, POSITION.RIGHT, arr.charAt(8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Board getGameBoard() {
        return gameBoard;
    }
}
