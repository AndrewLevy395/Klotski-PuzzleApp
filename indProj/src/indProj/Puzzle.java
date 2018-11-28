package indProj;

public class Puzzle {
	Piece[] piecesSet;
	int moves;

	public Puzzle(Piece[] piecesSet) {
		this.piecesSet = piecesSet;
	}

	//sets the initial puzzle
	public Puzzle initialPuzzle() {
		moves = 0;
		for (int i = 1; i <= 10; i++) {
			Piece piece = new Piece(i);
			piece.pieceNum = i;
			piece.winPiece = false;
			piece.selected = false;
			//sets height and width
			if (i <= 4) {
				piece.height = 100;
				piece.width = 100;
			} else if (i <= 8) {
				piece.height = 205;
				piece.width = 100;
			} else if (i <= 9) {
				piece.height = 100;
				piece.width = 205;
			} else {
				piece.height = 205;
				piece.width = 205;
				piece.winPiece = true;
			}

			//sets x and y coordinates
			int xCord = 0;
			int yCord = 0;
			switch (i) {
			case 1:
				xCord = 110;
				yCord = 320;
				break;
			case 2:
				xCord = 215;
				yCord = 320;
				break;
			case 3:
				xCord = 320;
				yCord = 425;
				break;
			case 4:
				xCord = 5;
				yCord = 425;
				break;
			case 5:
				xCord = 320;
				yCord = 215;
				break;
			case 6:
				xCord = 5;
				yCord = 215;
				break;
			case 7:
				xCord = 320;
				yCord = 5;
				break;
			case 8:
				xCord = 5;
				yCord = 5;
				break;
			case 9:
				xCord = 110;
				yCord = 215;
				break;
			case 10:
				xCord = 110;
				yCord = 5;
				break;

			}
			piece.x = xCord;
			piece.y = yCord;

			//set color and places pieces into puzzle
			piece.setColor();
			piecesSet[i - 1] = piece;
		}

		Puzzle initPuzzle = new Puzzle(piecesSet);
		return initPuzzle;
	}

}
