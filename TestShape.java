package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A class that implements test cases aimed at identifying bugs in the 
 * implementations of classes Shape and RectangleShape.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class TestShape {
	// Fixture object that is used by the tests.
	private MockPainter _painter;

	/**
	 * This method is called automatically by the JUnit test-runner immediately
	 * before each @Test method is executed. setUp() recreates the fixture so 
	 * that there no side effects from running individual tests.
	 */
	@Before
	public void setUp() {
		_painter = new MockPainter();
	}

	/**
	 * Test to perform a simple (non-bouncing) movement, and to ensure that a
	 * Shape's position after the movement is correct.
	 */
	@Test
	public void testSimpleMove() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(500, 500);
		shape.paint(_painter);
		
		OvalShape shape1 = new OvalShape(50, 30, 12, 15);
		shape1.paint(_painter);
		shape1.move(500, 500);
		shape1.paint(_painter);
		
		HexagonShape shape2 = new HexagonShape (10, 90, 10, 10, 30, 30);
		shape2.paint(_painter);
		shape2.move(500, 500);
		shape2.paint(_painter);
		
		HexagonShape shape3 = new HexagonShape (10, 90, 10, 10, 50, 50);
		shape3.paint(_painter);
		shape3.move(500, 500);
		shape3.paint(_painter);
		
		DynamicShape shape4 = new DynamicShape (100, 20, 12, 15);
		shape4.paint(_painter);
		shape4.move(500, 500);
		shape4.paint(_painter);
		
		
		assertEquals("(rectangle 100,20,25,35)(rectangle 112,35,25,35)(oval 50,30,25,35)(oval 62,45,25,35)"
				+ "(line 10,105,25,90)(line 25,90,40,105)(line 40,105,25,120)(line 25,120,10,105)"
				+ "(line 20,115,35,100)(line 35,100,50,115)(line 50,115,35,130)(line 35,130,20,115)"
				+ "(line 10,115,30,90)(line 30,90,40,90)(line 40,90,60,115)(line 60,115,40,140)"
				+ "(line 40,140,30,140)(line 30,140,10,115)(line 20,125,40,100)(line 40,100,50,100)"
				+ "(line 50,100,70,125)(line 70,125,50,150)(line 50,150,40,150)(line 40,150,20,125)"
				+ "(rectangle 100,20,25,35)(rectangle 112,35,25,35)",
				_painter.toString());
		
	
		
	}
	

	
	/**
	 * Test to perform a bounce movement off the right-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffRight() {
		RectangleShape shape = new RectangleShape(100, 20, 12, 15);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
		shape.move(135, 10000);
		shape.paint(_painter);
	
		OvalShape shape1 = new OvalShape(100, 20, 15, 20, 30, 35);
		shape1.paint(_painter);
		shape1.move(135, 10000);
		shape1.paint(_painter);
		shape1.move(135, 10000);
		shape1.paint(_painter);
		
		HexagonShape shape2 = new HexagonShape(100, 20, 10, 10, 30, 30);
		shape2.paint(_painter);
		shape2.move(135, 10000);
		shape2.paint(_painter);
		shape2.move(135, 10000);
		shape2.paint(_painter);
		
		HexagonShape shape3 = new HexagonShape(100, 20, 10, 10, 50, 50);
		shape3.paint(_painter);
		shape3.move(135, 10000);
		shape3.paint(_painter);
		shape3.move(135, 10000);
		shape3.paint(_painter);
		
		DynamicShape shape4 = new DynamicShape (100, 20, 12, 15);
		shape4.paint(_painter);
		shape4.move(135, 10000);
		shape4.paint(_painter);
		shape4.move(135, 10000);
		shape4.paint(_painter);
		
		assertEquals("(rectangle 100,20,25,35)(rectangle 110,35,25,35)"
				+ "(rectangle 98,50,25,35)(oval 100,20,30,35)(oval 105,40,30,35)"
				+ "(oval 90,60,30,35)"
				+"(line 100,35,115,20)(line 115,20,130,35)(line 130,35,115,50)(line 115,50,100,35)"
				+ "(line 105,45,120,30)(line 120,30,135,45)(line 135,45,120,60)(line 120,60,105,45)"
				+ "(line 95,55,110,40)(line 110,40,125,55)(line 125,55,110,70)(line 110,70,95,55)"
				+ "(line 100,45,120,20)(line 120,20,130,20)(line 130,20,150,45)(line 150,45,130,70)"
				+ "(line 130,70,120,70)(line 120,70,100,45)(line 85,55,105,30)(line 105,30,115,30)"
				+ "(line 115,30,135,55)(line 135,55,115,80)(line 115,80,105,80)(line 105,80,85,55)"
				+ "(line 75,65,95,40)(line 95,40,105,40)(line 105,40,125,65)(line 125,65,105,90)"
				+ "(line 105,90,95,90)(line 95,90,75,65)"
				+ "(rectangle 100,20,25,35)(fill Color (255,0,0))(filled rectangle 110,35,25,35)"
				+ "(fill Color (255,0,0))(filled rectangle 98,50,25,35)", _painter.toString());
		
	}

	/**
	 * Test to perform a bounce movement off the left-most boundary and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffLeft() {
		RectangleShape shape = new RectangleShape(10, 20, -12, 15);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		shape.move(10000, 10000);
		shape.paint(_painter);
		OvalShape shape1 = new OvalShape(10, 20, -15, 20);
		shape1.paint(_painter);
		shape1.move(10000, 10000);
		shape1.paint(_painter);
		shape1.move(10000, 10000);
		shape1.paint(_painter);
		
		HexagonShape shape2 = new HexagonShape(10, 20, -15, 20, 30, 30);
		shape2.paint(_painter);
		shape2.move(10000, 10000);
		shape2.paint(_painter);
		shape2.move(10000, 10000);
		shape2.paint(_painter);
		
		HexagonShape shape3 = new HexagonShape(10, 20, -15, 20, 50, 50);
		shape3.paint(_painter);
		shape3.move(10000, 10000);
		shape3.paint(_painter);
		shape3.move(10000, 10000);
		shape3.paint(_painter);
		
		DynamicShape shape4 = new DynamicShape (10, 20, -12, 15);
		shape4.paint(_painter);
		shape4.move(10000, 10000);
		shape4.paint(_painter);
		shape4.move(10000, 10000);
		shape4.paint(_painter);
		
		assertEquals("(rectangle 10,20,25,35)(rectangle 0,35,25,35)"
				+ "(rectangle 12,50,25,35)(oval 10,20,25,35)(oval 0,40,25,35)"
				+ "(oval 15,60,25,35)"
				+"(line 10,35,25,20)(line 25,20,40,35)(line 40,35,25,50)(line 25,50,10,35)"
				+ "(line 0,55,15,40)(line 15,40,30,55)(line 30,55,15,70)(line 15,70,0,55)"
				+ "(line 15,75,30,60)(line 30,60,45,75)(line 45,75,30,90)(line 30,90,15,75)"
				+ "(line 10,45,30,20)(line 30,20,40,20)(line 40,20,60,45)(line 60,45,40,70)"
				+ "(line 40,70,30,70)(line 30,70,10,45)(line 0,65,20,40)(line 20,40,30,40)"
				+ "(line 30,40,50,65)(line 50,65,30,90)(line 30,90,20,90)(line 20,90,0,65)"
				+ "(line 15,85,35,60)(line 35,60,45,60)(line 45,60,65,85)(line 65,85,45,110)"
				+ "(line 45,110,35,110)(line 35,110,15,85)"
				+ "(rectangle 10,20,25,35)(fill Color (255,0,0))(filled rectangle 0,35,25,35)"
				+ "(fill Color (255,0,0))(filled rectangle 12,50,25,35)", _painter.toString());
	}

	/**
	 * Test to perform a bounce movement off the bottom right corner and to
	 * ensure that the Shape's position after the movement is correct.
	 */
	@Test
	public void testShapeMoveWithBounceOffBottomAndRight() {
		RectangleShape shape = new RectangleShape(10, 90, -12, 15);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		shape.move(125, 135);
		shape.paint(_painter);
		
		OvalShape shape1 = new OvalShape(10, 90, -20, 20);
		shape1.paint(_painter);
		shape1.move(125, 135);
		shape1.paint(_painter);
		shape1.move(125, 135);
		shape1.paint(_painter);
		
		HexagonShape shape2 = new HexagonShape(10, 90, -20, 20, 30, 30);
		shape2.paint(_painter);
		shape2.move(125, 135);
		shape2.paint(_painter);
		shape2.move(125, 135);
		shape2.paint(_painter);
		
		HexagonShape shape3 = new HexagonShape(10, 90, -20, 20, 50, 50);
		shape3.paint(_painter);
		shape3.move(125, 135);
		shape3.paint(_painter);
		shape3.move(125, 135);
		shape3.paint(_painter);
		
		DynamicShape shape4 = new DynamicShape (10, 90, -12, 15);
		shape4.paint(_painter);
		shape4.move(125, 135);
		shape4.paint(_painter);
		shape4.move(125, 135);
		shape4.paint(_painter);
		
		assertEquals("(rectangle 10,90,25,35)(rectangle 0,100,25,35)"
				+ "(rectangle 12,85,25,35)(oval 10,90,25,35)(oval 0,100,25,35)"
				+ "(oval 20,80,25,35)"
				+ "(line 10,105,25,90)(line 25,90,40,105)(line 40,105,25,120)(line 25,120,10,105)"
				+ "(line 0,120,15,105)(line 15,105,30,120)(line 30,120,15,135)(line 15,135,0,120)"
				+ "(line 20,100,35,85)(line 35,85,50,100)(line 50,100,35,115)(line 35,115,20,100)"
				+ "(line 10,115,30,90)(line 30,90,40,90)(line 40,90,60,115)(line 60,115,40,140)"
				+ "(line 40,140,30,140)(line 30,140,10,115)(line 0,110,20,85)(line 20,85,30,85)"
				+ "(line 30,85,50,110)(line 50,110,30,135)(line 30,135,20,135)(line 20,135,0,110)"
				+ "(line 20,90,40,65)(line 40,65,50,65)(line 50,65,70,90)(line 70,90,50,115)"
				+ "(line 50,115,40,115)(line 40,115,20,90)"
				+ "(rectangle 10,90,25,35)(rectangle 0,100,25,35)(rectangle 12,85,25,35)",_painter.toString());
	}
	
	@Test
	public void testShapeBounceOffTopRight () {
		DynamicShape shape = new DynamicShape (115, 5, 10, -10, 30, 30);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		
		
	assertEquals("(rectangle 115,5,30,30)(rectangle 125,0,30,30)(fill Color (255,0,0))(filled rectangle 130,10,30,30)",_painter.toString());
	}
	
	@Test
	public void testShapeBounceOffTopLeft () {
		DynamicShape shape = new DynamicShape (15, 5, -10, -10, 30, 30);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		
		assertEquals("(rectangle 15,5,30,30)(rectangle 5,0,30,30)(fill Color (255,0,0))(filled rectangle 0,10,30,30)",_painter.toString());
		
	}
	
	@Test
	public void testShapeBounceOffBottomRight () {
		DynamicShape shape = new DynamicShape (111, 115, 10, 10, 30, 30);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		
		assertEquals("(rectangle 111,115,30,30)(rectangle 121,120,30,30)(fill Color (255,0,0))(filled rectangle 130,110,30,30)",_painter.toString());
	}
	
	@Test
	public void testShapeBounceOffBottomLeft () {
		DynamicShape shape = new DynamicShape (15, 115, -10, 10, 30, 30);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		shape.move(160, 150);
		shape.paint(_painter);
		
		assertEquals("(rectangle 15,115,30,30)(rectangle 5,120,30,30)(fill Color (255,0,0))(filled rectangle 0,110,30,30)",_painter.toString());
		
	}
	
	
}
