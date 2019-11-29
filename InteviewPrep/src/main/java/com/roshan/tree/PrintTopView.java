package com.roshan.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class PrintTopView {

	public static List<Node> getTopView(Node root) {
		List<Node> retVal = new ArrayList<Node>();
		Map<Integer, Node> map = new TreeMap<>();
		getTopViewUtil(root, map, 0);

		for (Entry<Integer, Node> entry : map.entrySet()) {
			retVal.add(entry.getValue());
		}
		return retVal;
	}

	public static List<Node> getTopViewBFS(Node root) {
		List<Node> retVal = new ArrayList<Node>();
		Map<Integer, Node> map = new TreeMap<>();
		getTopViewBFS(root, map);

		for (Entry<Integer, Node> entry : map.entrySet()) {
			retVal.add(entry.getValue());
		}
		return retVal;
	}

	private static void getTopViewBFS(Node node, Map<Integer, Node> map) {
		Queue<Node> queue = new LinkedList<>();
		Queue<Integer> position = new LinkedList<>();
		queue.add(node);
		position.add(0);

		while (!queue.isEmpty()) {
			int pos = position.poll();
			Node elem = queue.poll();

			if (!map.containsKey(pos)) {
				map.put(pos, elem);
			}

			if (elem.left != null) {
				queue.add(elem.left);
				position.add(pos - 1);	
			}

			if (elem.right != null) {
				queue.add(elem.right);
				position.add(pos + 1);
			}
		}
	}

	private static void getTopViewUtil(Node node, Map<Integer, Node> map, int pos) {
		if (node == null) {
			return;
		}
//		if(map.get(pos) == null) {
//			map.put(pos, node);
//		}
		getTopViewUtil(node.left, map, pos - 1);
		getTopViewUtil(node.right, map, pos + 1);
		map.put(pos, node);
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

		System.out.println("Following are nodes in top view of Binary Tree\n");
		List<Node> list = getTopView(root);
		for (Node node : list) {
			System.out.print(node.data + " ");
		}

		System.out.println();

		list = getTopViewBFS(root);
		for (Node node : list) {
			System.out.print(node.data + " ");
		}
	}

}
