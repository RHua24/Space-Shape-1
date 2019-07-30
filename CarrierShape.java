package spaceshapes;

import java.util.ArrayList;

public class CarrierShape extends Shape {

	protected ArrayList<Shape> _childrenList = new ArrayList<Shape>();

	public CarrierShape (){
		super();
	}



	public CarrierShape(int x, int y) {
		super(x,y);
	}


	public CarrierShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	
	
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	public CarrierShape (String text){
		super(text);
	}



	public CarrierShape(int x, int y, String text) {
		super(x,y,text);
	}


	public CarrierShape(int x, int y, int deltaX, int deltaY, String text) {
		super(x,y,deltaX,deltaY, text);
	}
	
	
	
	public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}
	
	
	
	
	public void move(int width, int height){
		//Firstly use move method in the parent class to complete movement of the CarrierShape itself.
		super.move(width, height);

		//Then move the Shapes inside the CarrierShape if there is one
		if (_childrenList.size() != 0) {
			for (Shape shape: _childrenList) {
		//Set the height and width of the Shapes by using the CarrierShape's boundaries. 
				shape.move(_width, _height);
				
				
			}
		}
	}
		
		
		
			
		
	
	
	@Override
	public void paintShape(Painter painter) {
		//draw carrierShape first
		painter.drawRect(_x,_y,_width,_height);
		//Then translate the coordination to the carrierShape's to ensure the shapes not go over the boundaries. 
		painter.translate(_x, _y);
		if (_childrenList.size() != 0) {
			for (Shape shape: _childrenList) {
				
				shape.paint(painter);

			
				
			}
		}
		//translate back in order to perform next paint. 
		painter.translate(-_x, -_y);
		
		
	}
	
	
	void add(Shape shape) throws IllegalArgumentException {
		//check if the shape is already a child within a carrierShape instance. 
		if (shape._hasCarrierShape == true) {
				throw new IllegalArgumentException();
			}
		
		//check if the shape does not fit whitn the bounds. 
		else if (shape._x < this._x || shape._x + shape._width > this._x + this._width ||shape._y < this._y || shape._y + shape._height > this._y + this._height) {
			throw new IllegalArgumentException();
		}
	
		_childrenList.add(shape);
		shape._hasCarrierShape = true;
		shape._carrierShape = this;
	}
	
	
	
	void remove(Shape shape) {
		
				_childrenList.remove(shape);
				shape._hasCarrierShape = false;
				shape._carrierShape = null;
			
	}
	
	public Shape shapeAt(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= _childrenList.size()) {
			throw new IndexOutOfBoundsException();
		}
		return _childrenList.get(index);
		
	}
	
	public int shapeCount() {
		return _childrenList.size();
		
	}
	
	public int indexOf (Shape shape) {
		for(Shape existShape: _childrenList) {
			if(existShape.equals(shape)) {
				return _childrenList.indexOf(shape);
			}
		}
		return -1;
		
	}
	
	public boolean contains(Shape shape) {
		for(Shape existShape: _childrenList) {
			if(existShape.equals(shape)) {
				return true;
			}
		}
		return false;
	}

}
