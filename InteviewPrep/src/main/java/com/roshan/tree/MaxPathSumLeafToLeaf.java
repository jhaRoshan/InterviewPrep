package com.roshan.tree;

public class MaxPathSumLeafToLeaf {

	public static int getMaxPathSum(Node root) {

		Result r = new Result();
		 getMaxSumUtil(root, r);
		 return r.value;
	}

	private static int getMaxSumUtil(Node node, Result r) {
		if (node == null) {
			return 0;
		}

		if (node.left == null && node.right == null) {
			return node.data;
		}

		int lsum = getMaxSumUtil(node.left, r);
		int rsum = getMaxSumUtil(node.right, r);

		if (node.left != null && node.right != null) {
			r.value = Math.max(r.value, lsum + rsum + node.data);
			return Math.max(lsum, rsum) + node.data;
		}

		return (node.left == null) ? rsum + node.data : lsum + node.data;

	}

	public static void main(String[] args) {
        Node root = new Node(-15); 
        root.left = new Node(5); 
        root.right = new Node(6); 
        root.left.left = new Node(-8); 
        root.left.right = new Node(1); 
        root.left.left.left = new Node(2); 
        root.left.left.right = new Node(6); 
        root.right.left = new Node(3); 
        root.right.right = new Node(9); 
        root.right.right.right = new Node(0); 
        root.right.right.right.left = new Node(4); 
        root.right.right.right.right = new Node(-1); 
        root.right.right.right.right.left = new Node(10); 
        System.out.println("Max pathSum of the given binary tree is "
                + getMaxPathSum(root)); 

	}

}

class Result {
	int value;
}
