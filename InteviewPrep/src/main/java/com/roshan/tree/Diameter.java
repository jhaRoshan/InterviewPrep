package com.roshan.tree;

public class Diameter {

	public static int getDiameter(Node root) {
		
		Height h = new Height();
		return getDiameterUtil(root , h);
	}
	
	private static int getDiameterUtil(Node root, Height h) {

		
		if(root == null) {
			h.height = 0;
			return 0;
		}

		Height lh = new Height();
		Height rh = new Height();
		
		int ld = getDiameterUtil(root.left, lh);
		int rd = getDiameterUtil(root.right, rh);
		
		h.height = Math.max(lh.height, rh.height) +1;
		
		return Math.max(lh.height+rh.height+1 , Math.max(ld, rd));
		
	}

	public static void main(String[] args) {

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		
		n1.left = n2;
		n2.left = n3;
		n3.left = n4;
		n4.left = n5;
		n2.right = n6;
		n6.right = n7;
		n7.right = n8;
		n1.right = n9;
		n3.right = n10;
		n10.left = n11;
		
		
		System.out.println(getDiameter(n1));
		
	}

}


class Height{
	int height;
}
