public class Board {

    // If empty -> cell is null
    // If O -> cell is False
    // If 1 -> cell is True
    private char boardMatrix[][];

    public Board() {
        boardMatrix = new char[3][3];
    }

    public char[][] getBoardFlags() {
        return boardMatrix;
    }

    public void setBoardFlags(char[][] boardFlags) {
        this.boardMatrix = boardFlags;
    }

    public String getNthRow(short row) {
        char rowValues[] = {boardMatrix[row][0], boardMatrix[row][1], boardMatrix[row][2]};
        return new String(rowValues);
    }

    public String getNthCol(short col) {
        char colValues[] = {boardMatrix[0][col], boardMatrix[1][col], boardMatrix[2][col]};
        return new String(colValues);
    }

    public String getCorner(boolean isRight) {
        char cornerValues[] = {boardMatrix[0][0], boardMatrix[1][1], boardMatrix[2][2]};

        if (isRight) {
            cornerValues[0] = boardMatrix[2][0];
            cornerValues[2] = boardMatrix[0][2];
        }
        return new String(cornerValues);
    }

    public void printBoard() {
        System.out.println(getNthRow((short) 0).replace('\u0000', '-'));
        System.out.println(getNthRow((short) 1).replace('\u0000', '-'));
        System.out.println(getNthRow((short) 2).replace('\u0000', '-'));
    }

    public boolean isFUll() {
        for (char[] rows : boardMatrix) {
            for (char cell : rows) {
                if (cell == '\u0000')
                    return false;
            }
        }
        return true;
    }
}
