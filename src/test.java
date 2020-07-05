import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class test {

	public static void main(String[] args) {
		 int N = 100;

	        StdDraw.setCanvasSize();

	        StdDraw.setXscale();
	        StdDraw.setYscale();

	        KdTree mySet = new KdTree();

	        for (int i = 1; i <= N; i++) {
	            double x = ((double) StdRandom.uniform(100))/100.0;
	            double y = ((double) StdRandom.uniform(100))/100.0;

	            Point2D point = new Point2D(x, y);
	            //System.out.println("Inserted point is: " + point.toString());
	            mySet.insert(point);
	        }
	        //Draw all the points
	        mySet.draw();

	    /*    //draw the reference point 
	        StdDraw.setPenRadius(0.015);
	        Point2D p = new Point2D(0.5, 0.5);
	        StdDraw.setPenColor(StdDraw.PINK);
	        p.draw();

	        
	        //draw the nearest neighbor
	        System.out.println("The size of the set is " + mySet.size());
	        System.out.println("The p point is " + p.toString());
	        Point2D nearestP = mySet.nearest(p);
	        System.out.println("The closest point to p is " + nearestP.toString());
	        StdDraw.setPenColor(StdDraw.PINK);
	        nearestP.draw();*/

	        //draw point within a range
	        RectHV myRect = new RectHV(0.1, 0.1, 0.4, 0.4);
	        StdDraw.setPenColor(StdDraw.GREEN);
	        StdDraw.setPenRadius(0.005);
	        StdDraw.rectangle(0.25, 0.25, 0.15, 0.15);

	        StdDraw.setPenRadius(0.015);
	        Iterable<Point2D> rangeSet = mySet.range(myRect);
	        for (Point2D point : rangeSet) {
	            point.draw();
	            System.out.println("Point inside range is " + point.toString());
	        }
		
	}

}
