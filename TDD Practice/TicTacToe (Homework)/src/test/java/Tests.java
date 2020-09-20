import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {

    private static TicTacToe game;

    //Set game from start before each tests.
    @BeforeEach
    public void setup() {
        game = new TicTacToe();
    }

    //Check game board after each test
    @AfterEach
    public void tableView() {
        System.out.println();
        game.getGameBoard().printBoard();
    }

    @Test
    public void check_if_0_vertically_wins() throws Exception {

        //Arrange
        game.markCellAt(POSITION.TOP, POSITION.MIDDlE, 'O');
        game.markCellAt(POSITION.MIDDlE, POSITION.MIDDlE, 'O');
        game.markCellAt(POSITION.BOTTOM, POSITION.MIDDlE, 'O');

        //Act
        STATE state = game.checkState();

        //Assert
        assertEquals(STATE.O_WON, state);

    }

    @Test
    public void check_if_X_vertically_wins() throws Exception {

        //Arrange
        game.markCellAt(POSITION.TOP, POSITION.MIDDlE, 'X');
        game.markCellAt(POSITION.MIDDlE, POSITION.MIDDlE, 'X');
        game.markCellAt(POSITION.BOTTOM, POSITION.MIDDlE, 'X');

        //Act
        STATE state = game.checkState();

        //Assert
        assertEquals(STATE.X_WON, state);

    }

    @Test
    public void check_if_0_horizontally_wins() throws Exception {

        //Arrange
        game.markCellAt(POSITION.MIDDlE, POSITION.RIGHT, 'O');
        game.markCellAt(POSITION.MIDDlE, POSITION.MIDDlE, 'O');
        game.markCellAt(POSITION.MIDDlE, POSITION.LEFT, 'O');

        //Act
        STATE state = game.checkState();

        //Assert
        assertEquals(STATE.O_WON, state);
    }

    @Test
    public void check_if_X_horizontally_wins() throws Exception {

        //Arrange
        game.markCellAt(POSITION.MIDDlE, POSITION.RIGHT, 'X');
        game.markCellAt(POSITION.MIDDlE, POSITION.MIDDlE, 'X');
        game.markCellAt(POSITION.MIDDlE, POSITION.LEFT, 'X');

        //Act
        STATE state = game.checkState();

        //Assert
        assertEquals(STATE.X_WON, state);
    }

    @Test
    public void check_if_O_crosswise_wins() throws Exception {
        //Arrange
        game.markCellAt(POSITION.TOP, POSITION.RIGHT, 'O');
        game.markCellAt(POSITION.MIDDlE, POSITION.MIDDlE, 'O');
        game.markCellAt(POSITION.BOTTOM, POSITION.LEFT, 'O');

        //Act
        STATE state = game.checkState();

        //Assert
        assertEquals(STATE.O_WON, state);
    }

    @Test
    public void check_if_X_crosswise_wins() throws Exception {

        //Arrange
        game.markCellAt(POSITION.TOP, POSITION.RIGHT, 'X');
        game.markCellAt(POSITION.MIDDlE, POSITION.MIDDlE, 'X');
        game.markCellAt(POSITION.BOTTOM, POSITION.LEFT, 'X');

        //Act
        STATE state = game.checkState();

        //Assert
        assertEquals(STATE.X_WON, state);
    }

    @Test
    public void it_should_throw_CellNotEmptyException_when_try_to_mark_same_cell() {
        Exception exception = assertThrows(CellNotEmptyException.class, () -> {
            //Arrange
            game.markCellAt(POSITION.TOP, POSITION.RIGHT, 'X');

            //Act
            game.markCellAt(POSITION.TOP, POSITION.RIGHT, 'X');
        });

        //Assert
        assertEquals("TOP RIGHT cell already filled with X", exception.getMessage());


    }

    @Test
    public void assert_if_game_not_finished_yet() throws Exception {

        //Arrange
        game.markCellAt(POSITION.TOP, POSITION.RIGHT, 'X');
        game.markCellAt(POSITION.TOP, POSITION.MIDDlE, 'O');

        //Assert
        assertEquals(STATE.ALIVE, game.checkState());

    }

    @Test
    public void check_the_state_when_the_game_is_tie() throws Exception{

        //Arrange
        game.setGameBoardByString("OXO" +
                "OOX" +
                "XOX");

        //Assert
        assertEquals(STATE.TIE, game.checkState());

    }

    @Test
    public void it_should_return_InvalidParameterException_when_given_string_is_longer_than_board(){
        //Arrange
        String setTo =  "OXO"+
                        "OOX"+
                        "XO X ";
        //Act
        Exception exception = assertThrows(InvalidParameterException.class, () -> {
            game.setGameBoardByString(setTo);
        });

        //Assert
        assertEquals("String length must be greather than 9", exception.getMessage());

    }

}
