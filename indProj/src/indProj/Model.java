package indProj;


public class Model {
	Puzzle puzzle;
	Piece[] emptyPiecesSet;
	boolean gameover;
	
	public Model() {
		
	}
	
	//create model, initialize it's puzzle, and return it
	public static Model initialize() {
		Model m = new Model();
		m.initPuzzle();
		return m;
	}
	
	//create empty set of pieces and make an new puzle out of it
	public void initPuzzle() {
		emptyPiecesSet = new Piece[10];
		puzzle = new Puzzle(emptyPiecesSet).initialPuzzle();
	}
	
	//return the piecesSet
	public Piece[] getPuzzle() {
		return puzzle.piecesSet;
	}
}
