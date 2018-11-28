package indProj;

public class Main {
	public static void main(String[] args) {
	    Model m = Model.initialize();
	    final KlotskiApp app = new KlotskiApp(m);
	    app.setVisible(true);
	}
}
