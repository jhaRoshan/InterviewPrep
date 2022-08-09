package com.roshan.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static ArrayList<ArrayList<Integer>> permute(int[] numbers) {
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
		permutations.add(new ArrayList<Integer>());

		for (int i = 0; i < numbers.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<>();
			for (List<Integer> permutation : permutations) {
				for (int j = 0, n = permutation.size() + 1; j < n; j++) {
					ArrayList<Integer> temp = new ArrayList<Integer>(permutation);
					temp.add(j, numbers[i]);
					current.add(temp);
				}
			}
			permutations = new ArrayList<>(current);
		}
		return permutations;
	}

	/////////

	private static void permute(String str, int l, int r)
	{
		if (l == r) {
			System.out.println(str);
		}
		else
		{
			for (int i = l; i <= r; i++)
			{
				String temp = new String(str);
				temp = swap(temp,l,i);
				permute(temp, l+1, r);
			}
		}
	}

	public static String swap(String a, int i, int j)
	{
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i] ;
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	////////

	public static void main(String[] ars) {
		int[] num = {1,2,3};
		ArrayList<ArrayList<Integer>> permute = permute(num);
		System.out.println(permute);

		permute("abc" , 0 , "abc".length()-1);
	}
	
	
}