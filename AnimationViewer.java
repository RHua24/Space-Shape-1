package spaceshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Simple GUI program to show an animation of shapes in a confined space. Class AnimationViewer is
 * a special kind of GUI component (JPanel), and as such an instance of 
 * AnimationViewer can be added to a JFrame object. A JFrame object is a 
 * window that can be closed, minimised, and maximised. The state of an
 * AnimationViewer object comprises a list of Shapes and a Timer object. An
 * AnimationViewer instance subscribes to events that are published by a Timer.
 * In response to receiving an event from the Timer, the AnimationViewer iterates 
 * through a list of Shapes requesting that each Shape paints and moves itself.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
@SuppressWarnings("serial")
public class AnimationViewer extends JPanel implements ActionListener {
	// Frequency in milliseconds for the Timer to generate events.
	private static final int DELAY = 20;

	// Collection of Shapes to animate.
	private List<Shape> _shapes;

	private Timer _timer = new Timer(DELAY, this);

	/**
	 * Creates an AnimationViewer instance with a list of Shape objects and 
	 * starts the animation.
	 * @throws IllegalAccessException 
	 */
	public AnimationViewer() {
		this.setBackground(Color.BLACK);
		_shapes = new ArrayList<Shape>();
	
		// Populate the list of Shapes.
		/*RectangleShape rectangleShape = new RectangleShape(110, 15, 3, 3, 10, 10);
		OvalShape ovalShape = new OvalShape (130, 40, 2, 2, 10, 10);
		
		CarrierShape test = new CarrierShape (100, 10, 3, 3, 200, 200);
		CarrierShape test2 = new CarrierShape(105, 15, 2, 2, 100, 100);
		CarrierShape test3 = new CarrierShape(120, 30, 2, 2, 50, 50);
		test2.add(rectangleShape);
		test3.add(ovalShape);
		test2.add(test3);
		test.add(test2);
		
		_shapes.add(test);*/
		
		
		DynamicShape vincent = new DynamicShape(10, 10, 4, 5, 30, 30, "Vincent: Liziiiiii!!!!");
		//HexagonShape hexagon = new HexagonShape(40, 40, 1, 1, 20, 20);
		CarrierShape lizi = new CarrierShape (65, 65, 4, 5, 30, 30, "Lizi");
		//OvalShape h = new OvalShape(66, 66, 2, 2, 10, 10, "Nooo");
		//lizi.add(h);
		
		CarrierShape c = new CarrierShape(10,10,1,1,350,350);
		//_shapes.add(c);
		CarrierShape c2 = new CarrierShape(5,5,1,1,400, 400);
		//RectangleShape ranran = new RectangleShape(20, 15, 0, 0, 30, 30, "Ran");
		RectangleShape duoduo = new RectangleShape(60, 15, 0, 0, 30, 30, "Duo");
		DynamicShape hi = new DynamicShape(21,16,1,1,5,5);
		
		
		CarrierShape ranran = new CarrierShape(20, 15, 0, 0, 30, 30, "Ran");
		ranran.add(hi);
		//CarrierShape c4 = new CarrierShape(35,34,1,1,100,100);
		c.add(vincent);
		c.add(lizi);
		c.add(ranran);
		c.add(duoduo);
		DynamicShape oval = new DynamicShape(5, 50, 2, 3, 10, 10);
		OvalShape oval1 = new OvalShape(5, 200, 3, 2, 10, 10);
		//OvalShape oval2 = new OvalShape(340, 100, 2, 3, 10, 10);
	//	OvalShape oval3 = new OvalShape(340, 200, 3, 2, 10, 10);
		
		CarrierShape c1 = new CarrierShape(15,15,2,2,150,100);
		CarrierShape c3 = new CarrierShape(20,20,2,2,100,50);
		HexagonShape yo = new HexagonShape (22,22,4,4,50, 40, "hahahahaha");
		c3.add(yo);
		c1.add(c3);
		c2.add(c);
		c2.add(c1);
		c2.add(oval);
		c2.add(oval1);
		//c2.add(oval2);
		//c2.add(oval3);
		

		/*c4.addText("I'm smallest carriershape");
		c3.add(c4);
		c2.add(c3);
		c.addText("I'm largest");
		c.add(c2);
		c.add(ovalShape);*/
		
		_shapes.add(c2);
		// Start the animation.
		_timer.start();
	}

	/**
	 * Called by the Swing framework whenever this AnimationViewer object
	 * should be repainted. This can happen, for example, after an explicit 
	 * repaint() call or after the window that contains this AnimationViewer 
	 * object has been opened, exposed or moved.
	 * 
	 */
	public void paintComponent(Graphics g) {
		// Call inherited implementation to handle background painting.
		super.paintComponent(g);
		
		// Calculate bounds of animation screen area.
		int width = getSize().width;
		int height = getSize().height;
		
		// Create a GraphicsPainter that Shape objects will use for drawing.
		// The GraphicsPainter delegates painting to a basic Graphics object.
		Painter painter = new GraphicsPainter(g);
		
		// Progress the animation.
		for(Shape s : _shapes) { 
		
			s.paint(painter);
			s.move(width, height);
		}
	}

	/**
	 * Notifies this AnimationViewer object of an ActionEvent. ActionEvents are
	 * received by the Timer.
	 */
	public void actionPerformed(ActionEvent e) {
		// Request that the AnimationViewer repaints itself. The call to 
		// repaint() will cause the AnimationViewer's paintComponent() method 
		// to be called.
		repaint();
	}
	
	
	/**
	 * Main program method to create an AnimationViewer object and display this
	 * within a JFrame window.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation viewer");
				frame.add(new AnimationViewer());
		
				// Set window properties.
				frame.setSize(500,500);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
