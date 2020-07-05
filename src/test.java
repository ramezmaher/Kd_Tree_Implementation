import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;

public class test {

	public static void main(String[] args) {
		StdDraw.setCanvasSize();
        StdDraw.setXscale();
        StdDraw.setYscale();
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.015);

		KdTree t = new KdTree();
		Point2D p1 = new Point2D(0.5,0.5);
		Point2D p2 = new Point2D(0.4,0.4);
		Point2D p3 = new Point2D(0.7,0.6);
		Point2D p4 = new Point2D(0.1,0.2);
		Point2D p5 = new Point2D(0.8,0.3);
		Point2D p6 = new Point2D(0.9,0.1);
		Point2D p7 = new Point2D(0.3,0.2);
		
		t.insert(p1);
		t.insert(p2);
		t.insert(p3);
		t.insert(p4);
		t.insert(p5);
		t.insert(p6);
		t.insert(p7);
		
		System.out.println(t.size());
		
		t.draw();
		
		Point2D p = new Point2D(0.7,0.6);
		
		System.out.println(t.contains(p));
		
	}

}
