import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.TreeSet;

public class PointSET {
	private TreeSet<Point2D> set;
	public PointSET() {
		set = new TreeSet<Point2D>();
	}  
	public boolean isEmpty() {
		if(set.size()==0)
			return true;
		return false;
	}                  
	public int size() {
		return set.size();
	}                          
	public void insert(Point2D p) {
		if(p == null)
			throw new IllegalArgumentException();
		set.add(p);
	}              
	public boolean contains(Point2D p) {
		if(p == null)
			throw new IllegalArgumentException();
		return set.contains(p);
	}            
	public void draw() {
		for (Point2D p:set)
			p.draw();
	}                         
	public Iterable<Point2D> range(RectHV rect){
		if(rect == null)
			throw new IllegalArgumentException();
		TreeSet<Point2D> ans = new TreeSet<Point2D>();
		for (Point2D p: set) {
			if(rect.contains(p))
				ans.add(p);
		}
		return ans;
	}             
	public Point2D nearest(Point2D p) {
		if(p == null)
			throw new IllegalArgumentException();
		double min = Double.MAX_VALUE;
		Point2D ans = null;
		for (Point2D q: set)
		{
			if (q.distanceTo(p) < min) {
				min = q.distanceTo(p);
				ans = q;
			}
		}
		return ans;
	}
}
