package spaceshapes;

public class OvalShape extends Shape {
	public OvalShape() {
		super();
	}
	
	public OvalShape(int x, int y) {
		super(x,y);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY) {
		super(x,y,deltaX,deltaY);
	}
	

	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height) {
		super(x,y,deltaX,deltaY,width,height);
	}
	
	
	public OvalShape(String text) {
		super(text);
	}
	
	public OvalShape(int x, int y, String text) {
		super(x,y,text);
	}
	
	public OvalShape(int x, int y, int deltaX, int deltaY, String text) {
		super(x,y,deltaX,deltaY,text);
	}
	

	public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text) {
		super(x,y,deltaX,deltaY,width,height,text);
	}
	
	
	
	public void paintShape(Painter painter) {
		painter.drawOval(_x,_y,_width,_height);
	}
}
