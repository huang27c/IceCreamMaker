import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import objectdraw.ActiveObject;
import javax.swing.JComponent;

/**
 * this class is the model and view of the ice cream game model: add and remove
 * data view: paint the ice cream
 * 
 * @author Ching2 Huang
 *
 */
public class IceCreamCone extends JComponent, ActiveObject {

	// the list to store the value of ice creams
	private StackLL<String> flavorList;

	// The size of the cone
	private static final int CONE_WIDTH = 20;
	private static final int CONE_HEIGHT = CONE_WIDTH * 4;
	// the size of the scoop
	private static final int SCOOP_SIZE = 50;
	// over lap distance
	private static final int OVERLAP = 15;

	/**
	 * constructor initializes the flavorList
	 */
	public IceCreamCone() {
		// the list for flavors
		flavorList = new StackLL<String>();
	}

	/**
	 * paint the cone and the ice cream
	 */
	public void paint(Graphics g) {
		cone(g); // paint cone
		paintIceCream(flavorList, g); // paint ice cream
	}

	/**
	 * add data to flavorList stack
	 * 
	 * @param flavor
	 */
	public void add(String flavor) {
		flavorList.push(flavor);
	}

	/**
	 * remove data from the flavorList stack
	 */
	public void remove() {
		flavorList.pop();
	}

	/**
	 * paint the scoops of ice cream
	 * 
	 * @param flavorList
	 */
	private void paintIceCream(StackLL<String> list, Graphics g) {

		// temporary list to access the first added data in flavor list
		StackLL<String> tmp = new StackLL<String>();

		// while the list exist
		while (!list.isEmpty()) {
			// tmp stack add the last added ice cream in the flavor list
			tmp.push(list.pop());
		}

		// to keep track the number of scoop and reset the data
		int scoopNum = 1;

		// while tmp list exists, paint the scoop
		while (!tmp.isEmpty()) {
			// check what flavor to paint then paint the scoop
			// after painting, pop the data in the tmp list and push it back to
			// list
			// finally, update scoopNum
			switch (tmp.peek()) {
			case "vanilla":
				addScoop(g, Color.WHITE, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			case "strawberry":
				addScoop(g, Color.PINK, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			case "greenTea":
				addScoop(g, Color.GREEN, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			case "caramel":
				addScoop(g, Color.ORANGE, scoopNum);
				list.push(tmp.pop());
				scoopNum++;
				break;
			}
		}
	}

	/**
	 * paint a cone for the ice cream
	 * 
	 * @param g
	 */
	private void cone(Graphics g) {
		// the color of the cone
		Color coneColor = new Color(250, 180, 90);
		g.setColor(coneColor);
		g.fillPolygon(new int[] { this.getWidth() / 2,
				this.getWidth() / 2 - CONE_WIDTH,
				this.getWidth() / 2 + CONE_WIDTH },
				new int[] { this.getHeight(), this.getHeight() - CONE_HEIGHT,
						this.getHeight() - CONE_HEIGHT }, 3);
	}

	/**
	 * paint one fillOval for the scoop, pass in the color of the ice cream and
	 * the number of ice creams
	 * 
	 * @param g
	 * @param color
	 * @param scoopNumber
	 */
	private void addScoop(Graphics g, Color color, int n) {
		// xLoc is the x location of the scoop
		// number of scoops
		int xLoc = this.getWidth() / 2 - SCOOP_SIZE / 2;
		int yLoc = SCOOP_SIZE;
		// be able to change color for each flavor
		g.setColor(color);
		// paint the scoop
		g.fillOval(xLoc, yLoc, SCOOP_SIZE, SCOOP_SIZE);
		
		//To start the animation
		start();
	}
	
	/**
	* Cause the ball to move in a straight line and stop when it reaches the top of the ice-cream.
	*/
	public void run(){
        	//make the scoope animated
		// yLoc is the y location of the scoop. Increase by multiplying the
		// number of scoops
		int yLoc = this.getHeight() - CONE_HEIGHT - (SCOOP_SIZE - OVERLAP) * n;
        	while (g.getY() < yLoc) {
			// Move the ball a small amount
			g.move(0, 5);
			// Pause to allow the display to update and give the feeling of animation
			pause(DELAY_TIME);
		}
	}
	

	/**
	 * add a random flavor scoop
	 * 
	 * @param g
	 */
	private void addRandScoop(Graphics g) {
		// generate random number to decide flavor
		Random random = new Random();
		int randomFlavor = random.nextInt(4); // 0-3

		// check the number of randomFlavor
		switch (randomFlavor) {
		case 0:
			// vanilla
			addScoop(g, Color.WHITE, 1);
			break;
		case 1:
			// strawberry
			addScoop(g, Color.PINK, 1);
			break;
		case 2:
			// greenTea
			addScoop(g, Color.GREEN, 1);
			break;
		case 3:
			// caramel
			addScoop(g, Color.ORANGE, 1);
			break;
		}
	}
}
