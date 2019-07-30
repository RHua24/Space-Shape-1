package spaceshapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;
	
	protected static final String DEFAULT_TEXT = " ";
	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;
	
	protected boolean _hasCarrierShape = false;
	
	protected CarrierShape _carrierShape = null;
	
	protected String _text;
	
	protected boolean _hasText = false;
	// ===
	
	protected List<Shape> _shapePath = new ArrayList<Shape>();

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT,DEFAULT_TEXT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT,DEFAULT_TEXT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT,DEFAULT_TEXT);
	
	}
	
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		this(x, y, deltaX, deltaY, width, height, DEFAULT_TEXT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	
	
	public Shape(String text) {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y, String text) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);	
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, String text) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT, text);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */

	public Shape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_text = text;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world. 
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
		}

		_x = nextX;
		_y = nextY;
		
	}

	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	public final void paint(Painter painter) {
		if (_text.equals(" ") == false) {
			text (painter);
		}
		paintShape(painter);
	}
	
	public abstract void paintShape (Painter painter);

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	public String getString () {
		return _text;
	}
	
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "spaceshapes.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}
	
	
	public CarrierShape parent() {
		if (_hasCarrierShape) {
			return _carrierShape;
		}
		else {
			return null;
		}
		
	}
	
	public List<Shape> path() {
		List<Shape> carrierShapeList = new ArrayList<Shape>();
		CarrierShape carrierShapeRoot = _carrierShape;
		carrierShapeList.add(this);
		
		
		
		//if (_hasCarrierShape) {
		//	_shapePath.add(_carrierShape);
		if (this._hasCarrierShape == false) {
			_shapePath = carrierShapeList;
			return _shapePath;
		}
		
		while (carrierShapeRoot._hasCarrierShape) {
			carrierShapeList.add(carrierShapeRoot);	
			carrierShapeRoot = carrierShapeRoot._carrierShape;
		}
		carrierShapeList.add(carrierShapeRoot);
		
		if (carrierShapeList.size() != 0) {
			for (int number = carrierShapeList.size() - 1; number >= 0; number--) {
				_shapePath.add(carrierShapeList.get(number));
			}
		}
		
		return _shapePath;
	}
	
	public void addText(String text) {
		this._text = text;
		_hasText = true;
	}
			
		
	
	public void text (Painter painter) {
			painter.drawCentredText(_text, this);
		
	}
		
	
}
