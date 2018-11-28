package indProj;

public class ResetPuzzleController {
	
	Model model;
	
	public ResetPuzzleController(Model model) {
		this.model = model;
	}
	
	//resets puzzle piece locations and makes game win condition false again
	public boolean resetPuzzle() {
		model.initPuzzle();
		model.gameover = false;
		return true;
	}
}
