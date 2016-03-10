package com.bp.algorithms;

import java.util.Scanner;

public class BoyerMoore {

	boolean findPattern(String from, String to) {

		int l = to.length();
		int i = l - 1, j = l - 1;
		char[] from_c = from.toCharArray();
		char[] to_c = to.toCharArray();

		while (i < from_c.length) {
			while (from_c[i] == to_c[j]) {
				i--;
				j--;
				if (j == 0)
					return true;
			}
			
			i += l - 1;
			j = l - 1;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		BoyerMoore bm = new BoyerMoore();
		int T;
		String from;
		String to;
		int testcase;
		boolean result;

		int a = 1024;

		a = a >> 1;
		System.out.println(a);
		T = 1;// sc.nextInt();
		for (testcase = 1; testcase <= T; testcase++) {

			// sc.nextLine();

			from = "abckefabasdefbdbcdefabcdefab";// sc.nextLine();
			to = "abcdef"; // sc.nextLine();

			result = bm.findPattern(from, to);

			System.out.println("Case#" + testcase);
			System.out.println(result);
		}
	}

}
