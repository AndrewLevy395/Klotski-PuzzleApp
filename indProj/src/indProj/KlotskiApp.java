package indProj;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class KlotskiApp extends JFrame {

	private JPanel contentPane;
	Model model;
	PuzzleView puzzleView;
	JLabel count = new JLabel();
	JLabel won = new JLabel();

	public KlotskiApp(Model model) {
		this.model = model;

		// set screen window using JPanel
		setTitle("Klotski Puzzle");
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// set reset button
		JButton btnNewButton = new JButton("Reset Puzzle");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(15, 15, 215, 103);
		contentPane.add(btnNewButton);

		// set move ount text
		JTextPane txtpnMoveCount = new JTextPane();
		txtpnMoveCount.setFocusable(false);
		txtpnMoveCount.setBackground(SystemColor.menu);
		txtpnMoveCount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnMoveCount.setText("MOVE COUNT:");
		txtpnMoveCount.setBounds(278, 16, 128, 26);
		contentPane.add(txtpnMoveCount);

		// set puzzle view
		PuzzleView panel = new PuzzleView(425, 530, model);
		panel.setForeground(Color.WHITE);
		panel.setBounds(15, 131, 425, 530);
		contentPane.add(panel);

		// initially set move count to screen
		calculate();

		// check arrow keys and WASD keys for press. if so move in that direction
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int kc = e.getKeyCode();
				if (kc == KeyEvent.VK_UP || kc == KeyEvent.VK_W) {
					new MoveController(model).move("up");
					calculate();
				} else if (kc == KeyEvent.VK_RIGHT || kc == KeyEvent.VK_D) {
					new MoveController(model).move("right");
					calculate();
				} else if (kc == KeyEvent.VK_DOWN || kc == KeyEvent.VK_S) {
					new MoveController(model).move("down");
					calculate();
				} else if (kc == KeyEvent.VK_LEFT || kc == KeyEvent.VK_A) {
					new MoveController(model).move("left");
					calculate();
				} else if (kc == KeyEvent.VK_R) {
					new ResetPuzzleController(model).resetPuzzle();
					calculate();
				}

				endScreen();
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

		});

		// check mouse location for selection and select piece
		panel.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent me) {
			}

			public void mouseReleased(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
			}

			public void mouseExited(MouseEvent me) {
			}

			public void mouseClicked(MouseEvent me) {
				int mouse_x = me.getX();
				int mouse_y = me.getY();
				new SelectController(model).selectPiece(mouse_x, mouse_y);
			}
		});

		// check mouse for button press and reset if clicked
		btnNewButton.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent me) {
			}

			public void mouseReleased(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
			}

			public void mouseExited(MouseEvent me) {
			}

			public void mouseClicked(MouseEvent me) {
				new ResetPuzzleController(model).resetPuzzle();
				calculate();
				endScreen();
			}
		});

		contentPane.add(count);
	}

	//calculate move count and print to screen
	public void calculate() {
		count.setFocusable(false);
		count.setFont(new Font("Tahoma", Font.PLAIN, 30));
		count.setText(Integer.toString(model.puzzle.moves));
		count.setBounds(330, 50, 128, 26);

	}

	//determine if game is won and print to screen
	public void endScreen() {
		contentPane.add(won);
		won.setFocusable(false);
		won.setFont(new Font("Tahoma", Font.PLAIN, 30));
		won.setText("YOU WIN!");
		won.setBounds(275, 80, 328, 40);
		if (model.gameover == false) {
			contentPane.remove(won);
			contentPane.revalidate();
			contentPane.repaint();
		}
	}
}
