package indProj;

public class MoveController {
	Model model;
	boolean movement;

	public MoveController(Model model) {
		this.model = model;
	}

	public boolean move(String direction) {
		movement = false;
		int xmovement = 0;
		int ymovement = 0;
		boolean available = true;
		//iterate through puzzle
		for (Piece piece : model.getPuzzle()) {
			//check to see if piece is selected and if game is over and then determine direction and movement
			if (piece.selected == true && model.gameover == false) {
				if (direction == "right") {
					xmovement = 105;
					movement = true;
				} else if (direction == "left") {
					xmovement = -105;
					movement = true;
				} else if (direction == "up") {
					ymovement = -105;
					movement = true;
				} else if (direction == "down") {
					ymovement = 105;
					movement = true;
				}

				//if the win piece goes through the slot the game becomes over
				if (piece.winPiece == true) {
					if (piece.x == 110 && piece.y + ymovement == 425) {
						model.gameover = true;
					}
				}

				//iterate through puzzle again and compare with each piece in previous for loop to see if moved piece overlaps
				// with another piece (not including itself)
				for (Piece pieceCheck : model.getPuzzle()) {
					if (pieceCheck.pieceNum != piece.pieceNum) {
						if ((pieceCheck.x <= piece.x + xmovement + piece.width
								&& piece.x + xmovement + piece.width <= pieceCheck.x + pieceCheck.width)
								|| (pieceCheck.x <= piece.x + xmovement
										&& piece.x + xmovement <= pieceCheck.x + pieceCheck.width)) {
							if ((pieceCheck.y <= piece.y + ymovement + piece.height
									&& piece.y + ymovement + piece.height <= pieceCheck.y + pieceCheck.height)
									|| (pieceCheck.y <= piece.y + ymovement
											&& piece.y + ymovement <= pieceCheck.y + pieceCheck.height)) {
								available = false;
							}
						}
					}
					if (piece.y + piece.height + ymovement >= 530 || piece.y + ymovement <= -100) {
						available = false;
					} else if (piece.x + piece.width + xmovement >= 425 || piece.x + xmovement <= -100) {
						available = false;
					}
				}
				// if a move is available then move the piece and increment total moves
				if (available == true || model.gameover == true) {
					piece.x = piece.x + xmovement;
					piece.y = piece.y + ymovement;
					model.puzzle.moves += 1;
				}
			}
		}
		return movement;
	}

}
