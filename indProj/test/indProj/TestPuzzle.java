package indProj;

import java.awt.Color;

import junit.framework.TestCase;

public class TestPuzzle extends TestCase {
	
	public void testWinPiece() {
		Model m = Model.initialize();
		final KlotskiApp app = new KlotskiApp(m);
		MoveController mc = new MoveController(app.model);
		
		assertTrue (app.model.puzzle.piecesSet[1].winPiece == false);
		assertTrue (app.model.puzzle.piecesSet[9].winPiece == true);
		assertTrue (app.model.puzzle.piecesSet[9].color == Color.RED);
		
		//put winpiece into winning position
		app.model.puzzle.piecesSet[9].x = 110;
		app.model.puzzle.piecesSet[9].y = 320;
		app.model.puzzle.piecesSet[9].selected = true;
		
		//move other peces out  of the way
		app.model.puzzle.piecesSet[0].x = 1110;
		app.model.puzzle.piecesSet[1].x = 1110;
		app.model.puzzle.piecesSet[2].x = 1110;
		app.model.puzzle.piecesSet[3].x = 1110;
		
		//move winpiece
		mc.move("down");
		
		//check to see if game is won
		assertTrue (app.model.gameover == true);
		

		
		app.model.gameover = true;
		
		//makes sure endScreen runs when game is over
		app.endScreen();
		
		app.model.gameover = false;
		
		//makes sure endScreen runs when game is not over
		app.endScreen();
	}
	
	public void testReset() {
		Model m = Model.initialize();
		ResetPuzzleController rpc = new ResetPuzzleController(m);
		//makes sure test resets
		assertTrue (rpc.resetPuzzle());
	}
	
	public void testMovement() {
		Model m = Model.initialize();
		final KlotskiApp app = new KlotskiApp(m);
		MoveController rpc = new MoveController(app.model);
		
		//see if piece is selected so that it can move
		assertTrue(rpc.move("right") == false);
		assertTrue(rpc.move("left") == false);
		assertTrue(rpc.move("up") == false);
		assertTrue(rpc.move("down") == false);
		
		m.puzzle.piecesSet[5].selected = true;
		
		//sees if pieces are selected so that they can move
		assertTrue(rpc.move("right") == true);
		assertTrue(rpc.move("left") == true);
		assertTrue(rpc.move("up") == true);
		assertTrue(rpc.move("down") == true);
		
		m.gameover = true;
		assertTrue(rpc.move("down") == false);
		
	}
	
	public void testSelect() {
		Model m = Model.initialize();
		SelectController sc = new SelectController(m);
		
		
		//see if piece is selected in speciic mouse area
		assertTrue(sc.selectPiece(101,50) == true);
		
		//select already selected piece
		m.puzzle.piecesSet[2].selected = true;
		assertTrue(sc.selectPiece(321,426) == true);
		
		//attempt to select nothing
		assertTrue(sc.selectPiece(0,0) == false);
	}
}
