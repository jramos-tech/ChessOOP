import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import chess.Main;

class MainTest {

    @Test
    void testGetPiece_blackRookCount() {
        Main main = new Main();
        assertNotNull(main.getPiece("black", 0));
        assertNotNull(main.getPiece("black", 1));
    }

    @Test
    void testGetPiece_whiteQueen() {
        Main main = new Main();
        assertNotNull(main.getPiece("white", 6));
        assertNull(main.getPiece("white", 6));
    }

    @Test
    void testRandomPiece_black() {
        Main main = new Main();
        for (int i = 0; i < 8; i++) {
            assertNotNull(main.randomPiece("black"));
        }
    }

    @Test
    void testRandomPiece_white() {
        Main main = new Main();
        for (int i = 0; i < 8; i++) {
        	pieces.Piece p = main.randomPiece("white");
            assertNotNull(p, "Random white piece should not be null");
        }
    }

    @Test
    void testBoardSetup_standard() {
        Main main = new Main();
        main.chess960 = false;
        main.boardsetup();
        assertNotNull(main.boardState[0][0].getpiece(), "Black rook should be in position 0,0");
        assertNotNull(main.boardState[7][0].getpiece(), "White rook should be in position 7,0");
        for (int j = 0; j < 8; j++) {
            assertNotNull(main.boardState[1][j].getpiece(), "Black pawn should be on row 1");
            assertNotNull(main.boardState[6][j].getpiece(), "White pawn should be on row 6");
        }
    }

    @Test
    void testBoardSetup_chess960() {
        Main main = new Main();
        main.chess960 = true;
        main.boardsetup();
        assertNotNull(main.boardState[0][0].getpiece(), "Black piece should be in position 0,0");
        assertNotNull(main.boardState[7][0].getpiece(), "White piece should be in position 7,0");
    }
}
