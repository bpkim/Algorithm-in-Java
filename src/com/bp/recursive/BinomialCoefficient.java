package com.bp.recursive;
/**
 * 
 * @author BP
 * ������ Ǯ��� �˰���
 */
public class BinomialCoefficient {

	final static int MAX = 100;
	long memo[][];
	
	BinomialCoefficient(){
		memo = new long[MAX][MAX];
	}
	
	long choose(int n, int r) {

		if(memo[n][r]>0)
			return memo[n][r];
		
		if((n==r)||(r==0))
			return memo[n][r] = 1;
		
		return memo[n][r] = choose(n-1,r-1) + choose(n-1, r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
