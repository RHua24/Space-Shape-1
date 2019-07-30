package spaceshapes;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Random;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */

public class GraphicsPainter implements Painter {
	// Delegate object.
	private Graphics _g;

	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}
	

	/**
	 * @see spaceshapes.Painter.drawRect
	 */
	public void drawRect(int x, int y, int width, int height) {
		//Random rand = new Random();
		//int r = rand.nextInt(255);
		//int g = rand.nextInt(255);
		//int b = rand.nextInt(255);
		//_g.setColor(new Color (r, g, b));
		_g.setColor(new Color(212, 212, 212));
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter.drawOval
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaeshapes.Painter.drawLine.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}


	@Override
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x, y, width, height);
		
	}


	@Override
	public Color getColor() {
		return _g.getColor();
	}


	@Override
	public void setColor(Color c) {
		_g.setColor(c);
	}


	@Override
	public void translate(int x, int y) {
		_g.translate(x, y);
	}


	@Override
	public void drawCentredText(String str, Shape shape) {
		/*int x;
		int y;
		if (shape._hasCarrierShape) {
			 x = shape._carrierShape._x + shape._x;
			 y = shape._carrierShape._y + shape._y;
		} else {
			 x = shape._x;
			 y = shape._y;
		}*/
		
		
		FontMetrics fontMetrics = _g.getFontMetrics();
		int width = (fontMetrics.stringWidth(str))/2;
		int xPoint = shape._x + shape._width/2 - width;
		int yPoint;
		if (fontMetrics.getAscent() > fontMetrics.getDescent()) {
			yPoint = (shape._y + shape._height/2) + (fontMetrics.getAscent() - fontMetrics.getDescent())/2;
		} else if (fontMetrics.getAscent() < fontMetrics.getDescent()) {
			yPoint = (shape._y + shape._height/2) - (fontMetrics.getDescent() - fontMetrics.getAscent())/2;
		} else {
			yPoint = (shape._y + shape._height/2);
		}
		
		
		_g.drawString(str, xPoint, yPoint);
		
	}
}
