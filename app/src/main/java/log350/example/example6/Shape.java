
package log350.example.example6;

import java.util.ArrayList;

class Shape {
	private ArrayList< Point2D > points = new ArrayList< Point2D >(); // in world space

	public Shape( ArrayList< Point2D > points ) {
		for ( Point2D p : points ) {
			this.points.add( p );
		}
	}

	public boolean contains( Point2D p /* in world space */ ) {
		return Point2DUtil.isPointInsidePolygon( points, p );
	}

	public void draw( GraphicsWrapper gw, boolean highlight ) {
		if ( highlight )
			gw.setColor( 1.0f, 0.5f, 0.5f, 0.9f );
		else
			gw.setColor( 1.0f, 1.0f, 1.0f, 0.6f );
		gw.fillPolygon( points );
	}

	public AlignedRectangle2D getBoundingRectangle() {
		AlignedRectangle2D rect = new AlignedRectangle2D();
		for ( Point2D p : points ) {
			rect.bound( p );
		}
		return rect;
	}

	public boolean isContainedInLassoPolygon( ArrayList< Point2D > polygonPoints ) {
		for ( Point2D p : points ) {
			if ( ! Point2DUtil.isPointInsidePolygon( polygonPoints, p ) )
				return false;
		}
		return true;
	}

	/**
	 * Method who apply a translation to all the points of a shape
	 * @param translation the Vector2D that represents the translation
	 */
	public void applyTranslation(Vector2D translation){

		for(Point2D point : points){

			//We calculate the coordinates after the translation
			float newX= point.x()+translation.x();
			float newY= point.y()+translation.y();

			//We apply the new coordinates to the point
			point.copy(newX,newY);
		}
	}

	public int getNumPoints() { return points.size(); }
	public ArrayList< Point2D > getPoints() { return points; }
}


