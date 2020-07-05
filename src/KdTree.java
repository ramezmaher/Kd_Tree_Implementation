import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {
	
	private class Node {
		
		private Point2D val;
		private Node left;
		private Node right;
		private int size;
		private boolean type;
		
		public Node(Point2D p,boolean T) {
			val = p;
			left = null;
			right = null;
			size = 1;
			type = T;
		}
		
	}
	
	private Node root;
	
	public KdTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public int size() {
		if(root == null)
			return 0;
		else return root.size;	
	}
	
	public void insert(Point2D p) {
		if(p == null)
			throw new IllegalArgumentException();
		if(root == null) {
			root = new Node(p,true);
			return;
		}
		insertion(root,p,true,null);
	}
	
	private boolean isLeft(Node n,Point2D p) {
		return p.x() < n.val.x();
	}
	
	private boolean isDown(Node n,Point2D p) {
		return p.y() < n.val.y();
	}
	
	private void insertion(Node n,Point2D p,boolean t,Node parent) {
		if(n == null)
		{
			Node node = new Node(p,t);
			if(t) {
				//parent horizontal
				if(isDown(parent,p)) 
					parent.left = node;
				else 
					parent.right = node;
			}
			else {
				//parent vertical
				if(isLeft(parent,p)) 
					parent.left = node;
				else 
					parent.right = node;
			}
			return;
		}
		if(t)
		{
			if(isLeft(n,p)) 
				insertion(n.left,p,!t,n);
			else
				insertion(n.right,p,!t,n);
		}
		else
		{
			if(isDown(n,p)) 
				insertion(n.left,p,!t,n);
			else
				insertion(n.right,p,!t,n);
		}
		n.size = n.size+1;
		return;
	}
	
	public boolean contains(Point2D p) {
		if(p == null)
			throw new IllegalArgumentException();
		return contains(root,true,p);
	} 
	
	private boolean contains(Node n,boolean t,Point2D p) {
		if(n == null)
			return false;
		if(n.val.equals(p))
			return true;
		
		if(t) {
			if(isLeft(n,p)) 
				return contains(n.left,!t,p);
			else 
				return contains(n.right,!t,p);
		}
		else {
			if(isDown(n,p))
				return contains(n.left,!t,p);
			else 
				return contains(n.right,!t,p);
		}
	}
	
	public void draw() {
		draw(root);
	}
	
	private void draw(Node n) {
		if(n == null)
			return;
		n.val.draw();
		draw(n.left);
		draw(n.right);
		
	}
	
	public Iterable<Point2D> range(RectHV rect){
		return null;
	}   
	public Point2D nearest(Point2D p) {
		return null;   
	}       
	
}
