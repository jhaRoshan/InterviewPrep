package com.roshan.tree;

import java.util.ArrayList;
import java.util.List;

public class ShortestUniquePrefix { 
	
	static final int MAX = 256; 
	
	static final int MAX_WORD_LEN = 500; 
	
	
	class TrieNode 
	{ 
		TrieNode[] child = new TrieNode[MAX]; 
		int freq;  
		TrieNode() { 
			freq =1; 
			for (int i = 0; i < MAX; i++) 
				child[i] = null; 
		}
	}
	
	
	 TrieNode root; 
	
	// Method to insert a new string into Trie 
	void insert(String str) 
	{ 
		int len = str.length(); 
		TrieNode pCrawl = root; 
	
		for (int level = 0; level<len; level++) 
		{ 
			int index = str.charAt(level); 
	
			if (pCrawl.child[index] == null) 
				pCrawl.child[index] = new TrieNode(); 
			else
			(pCrawl.child[index].freq)++; 
			pCrawl = pCrawl.child[index]; 
		} 
	} 
	
	List<String> findPrefixesUtil(String[] arr, TrieNode root, char[] prefix, 
						int ind) 
	{ 
		if (root == null) 
		return null; 
	
		List<String> retVal = new ArrayList<String>();
		
		for(int i = 0;i<arr.length ; i++) {
			TrieNode curr = root;
			String s = arr[i];
			StringBuilder sb = new StringBuilder();
			for(int j = 0;j<s.length();j++) {
				int v = s.charAt(j);
				if(curr.child[v] != null && curr.child[v].freq > 1) {
					sb.append((char)v);
					curr = curr.child[v];
				}else if(curr.child[v] != null){
					sb.append((char)v);
					break;
				}
			}
			retVal.add(sb.toString());
		}
		return retVal;
	} 
	
	List<String> findPrefixes(String arr[], int n) 
	{ 
		root = new TrieNode(); 
		root.freq = 0; 
		for (int i = 0; i<n; i++) 
			insert(arr[i]); 
	
		char[] prefix = new char[MAX_WORD_LEN]; 
		
		return findPrefixesUtil(arr , root, prefix, 0); 
	} 
	
	public static void main(String args[]) 
	{ 
		String arr[] = {"zebra", "dog", "duck", "dove"}; 
		int n = arr.length; 
		ShortestUniquePrefix sup = new ShortestUniquePrefix();
		sup.findPrefixes(arr, n); 
	} 
} 
