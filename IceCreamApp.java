import javax.swing.JFrame;

/**
 * This class show the game
 * 
 * @author Ching2 Huang
 *
 */

public class IceCreamApp {

	/**
	 * main method to show the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// the frame
		frame();
	}

	/**
	 * create a frame for the game
	 * 
	 * @return the frame
	 */
	private static JFrame frame() {
		JFrame frame = new JFrame("Ice Cream Cone Maker");
		frame.setSize(500, 500);

		frame.setResizable(false); // unable to resize the frame
		frame.setLocationRelativeTo(null);
		// default to the middle of the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// shut down the game when the window is closed
		frame.add(new IceCreamMaker());

		frame.setVisible(true);// make the frame visible

		return frame;
	}
}
