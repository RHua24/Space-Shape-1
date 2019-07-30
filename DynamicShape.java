package spaceshapes;

import java.awt.Color;


public class DynamicShape extends Shape {
	protected boolean _touched;
	protected boolean _toRed;
	protected boolean _isRed;
	protected int _hasChecked = 0;
	
	Color red = new Color(0,128,0);
	Color white = new Color(212,212,212);

	public DynamicShape() {
		super();
	}

	public DynamicShape(int x, int y) {
		super(x,y);
	}
		

	public DynamicShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	
	
	public DynamicShape (String text){
		super(text);
	}



	public DynamicShape(int x, int y, String text) {
		super(x,y,text);
	}


	public DynamicShape(int x, int y, int deltaX, int deltaY, String text) {
		super(x,y,deltaX,deltaY, text);
	}
	
	
	
	public DynamicShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height, text);
	}
	

	
	public void move(int width, int height) {
		
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_touched = true;
			_toRed = true;
			_hasChecked = 1;
			//return;
			
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_touched = true;
			_toRed = true;
			_hasChecked = 1;
			//return;
			
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;	
			_touched = true;
			_toRed = false;
			_hasChecked = 1;
			//return;
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_touched = true;
			_toRed = false;
			_hasChecked = 1;
			//return;
		}
		
		
		_x = nextX;
		_y = nextY;
		
		if (_hasChecked == 0) {
		_touched = false;
		}
	
	}
	
	


	@Override
	public void paintShape(Painter painter) {
		if (_touched == false && _isRed == false) {
			painter.drawRect(_x,_y,_width,_height);
			return;
		}
		else if (_touched == false && _isRed == true) {
			painter.setColor(red);
			painter.fillRect(_x,_y,_width,_height);
			painter.setColor(white);
			return;
		}
		else if (_touched == true && _toRed == true) {
			painter.setColor(red);
			painter.fillRect(_x,_y,_width,_height);
			painter.setColor(white);
			_isRed = true;
			return;
		}
		else if (_touched == true && _toRed != true) {
			painter.drawRect(_x,_y,_width,_height);
			_isRed = false;
			return;
		}
	}
		
		
		
	
	
}
