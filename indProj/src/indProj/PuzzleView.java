package indProj;

import java.awt.*;


import javax.swing.JPanel;

public class PuzzleView extends JPanel {
	int xSize;
	int ySize;
	Model model;
	

	public PuzzleView(int xSize, int ySize, Model model) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.model = model;
	}

	//paints puzzle, pieces, and slot to screen
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillRect(0, 0, xSize, ySize);
		g.setColor(Color.BLACK);
		g.fillRect(105, 525, 215, 5);
		for (Piece piece : model.getPuzzle()) {
			g.setColor(piece.color);
			g.fillRect(piece.x, piece.y, piece.width, piece.height);
		}
		repaint();

	}
}