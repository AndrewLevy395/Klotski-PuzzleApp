package indProj;

import java.awt.*;

public class Piece {
	boolean selected;
	int pieceNum;
	boolean winPiece;
	int height;
	int width;
	int x;
	int y;
	Color color;
	
	public Piece(int pieceNum) {
		this.pieceNum = pieceNum;
	}	
	
	//sets color of piece
	public void setColor() {

		if(winPiece == true) {
			color = Color.RED;
		}
		if(selected == true) {
			color = Color.BLUE;
		}
		else if(winPiece == false){
			color = Color.GRAY;
		}
	}
	

}
