package com.roshan.tree;

public class LCS {

	private static boolean isV1 = false;
	private static boolean isV2 = false;
	
	public static Node getLCS(Node root , int v1, int v2 ) {
		
		if(root == null) return null;
		
		if(root.data == v1) {
			isV1 = true;
			return root;
		}
		
		if(root.data == v2) {
			isV2 = true;
			return root;
		}
		
		Node llca = getLCS(root.left, v1, v2);
		Node rlca = getLCS(root.right, v1, v2);
		
		if(llca != null && rlca != null) return root;
		
		return llca !=null?llca:rlca;
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		root.right.right = new Node(7);

		root.left.left = new Node(11);
		root.left.left.right = new Node(12);
		root.left.left.right.right = new Node(13);
		
//		System.out.println(getLCS(root, 12, 4).data);
//		System.out.println(getLCS(root, 12, 5).data);
//		System.out.println(getLCS(root, 11, 2).data);
		System.out.println(getLCS(root, 12, 12).data + " , isV1:"+isV1 +" isV2:"+isV2 );
	}

}
