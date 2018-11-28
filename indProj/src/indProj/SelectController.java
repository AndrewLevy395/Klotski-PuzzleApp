package indProj;

public class SelectController {
	Model model;

	public SelectController(Model model) {
		this.model = model;
	}
	
	
	public boolean selectPiece(int mouse_x, int mouse_y) {
		for (Piece piece : model.getPuzzle()) {
			//unselects piece
			if (piece.selected == true) {
				piece.selected = false;
				piece.setColor();
			}
			//checks if mouse is in boundary region of a piece
			if (piece.x <= mouse_x && mouse_x <= piece.x + piece.width) {
				if (piece.y <= mouse_y && mouse_y <= piece.y + piece.height) {
					piece.selected = true;
					piece.setColor();
					return piece.selected;
				}
			}
		}
		return false;
	}
}
