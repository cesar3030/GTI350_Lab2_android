
package log350.example.example6;

import java.util.ArrayList;

class ShapeContainer {
	public ArrayList< Shape > shapes = new ArrayList< Shape >();

	public Shape getShape( int index ) { return shapes.get(index); }

	public void addShape( ArrayList< Point2D > points /* in world space */ ) {
		Shape s = new Shape( points );
		shapes.add( s );
	}

	// returns -1 if no shape contains the given point
	public int indexOfShapeContainingGivenPoint( Point2D p /* in world space */ ) {
		for ( int i = 0; i < shapes.size(); ++i ) {
			Shape s = shapes.get(i);
			if ( s.contains(p) )
				return i;
		}
		return -1;
	}

	public void draw( GraphicsWrapper gw, int indexOfShapeToHighlight /* -1 for none */ ) {
		for ( int i = 0; i < shapes.size(); ++i ) {
			Shape s = shapes.get(i);
			s.draw(gw, i==indexOfShapeToHighlight );
		}
	}

	public AlignedRectangle2D getBoundingRectangle() {
		AlignedRectangle2D rect = new AlignedRectangle2D();
		for ( Shape s : shapes )
			rect.bound( s.getBoundingRectangle() );
		return rect;
	}

	/**
	 * Method that removes the shape at the given index of the list of shapes
	 * @param index
	 */
	public void removeShape(int index){
		shapes.remove(index);
	}

	/**
	 * Method that removes the shape at the given index of the list of shapes
	 * @param shape, the Shape Object needed to be delete
	 */
	public void removeShape(Shape shape){
		int index = shapes.indexOf(shape);
		shapes.remove(index);
	}
}

