package com.roshan.inter.prep;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/snake-ladder-problem-2/

public class SnakeAndLadder {

	public static int getMinDiceThrows(int[] moves, int n) {

		boolean[] visited = new boolean[n + 1];

		Item it = new Item();
		it.cellNum = 1;
		it.d = 0;

		Queue<Item> queue = new LinkedList<>();
		queue.add(it);
		visited[1] = true;

		while (!queue.isEmpty()) {
			Item item = queue.poll();

			if (item.cellNum == n) {
				return item.d;
			}

			for (int i = 1; i < 7; i++) {
				int currentCellNum = item.cellNum + i;
				if (currentCellNum <= n) {
					int cellNum = moves[item.cellNum + i];
					if (cellNum == -1)
						cellNum = item.cellNum + i;

					if (!visited[cellNum]) {
						Item linkedItem = new Item();
						linkedItem.cellNum = cellNum;
						linkedItem.d = item.d + 1;
						visited[cellNum] = true;
						queue.add(linkedItem);
					}
				}

			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// Let us construct the board given in above diagram
		int N = 30;
		int moves[] = new int[N + 1];
		for (int i = 0; i < N + 1; i++)
			moves[i] = -1;

		// Ladders
		moves[3] = 22;
		moves[5] = 8;
		moves[11] = 26;
		moves[20] = 29;

		// Snakes
		moves[27] = 1;
		moves[21] = 9;
		moves[17] = 4;
		moves[19] = 7;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
	}

}

class Item {

	int cellNum;
	int d;// min dice throw
}
