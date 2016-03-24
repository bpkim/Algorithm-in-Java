package com.bp.recursive;
/**
 * 프로그래밍 대회에서 배우는 알고리즘 문제해결전략
 * @author BP
 *
 */
public class Recursive {
	/*
	 *  1 + 2 +3 + ... + n
	 *   = (1 + 2 + 3 ... + n/2) + ((n/2 +1) + ... + n)
	 *   = (1 + 2 + 3 ... + n/2) + ((n/2 + 1) + (n/2 + 2) + (n/2 + 3) + ... +(n/2 + n/2))
	 *   = (1 + 2 + 3 ... + n/2) + (1 + 2 + 3 ... + n/2) + (n/2)*(n/2)
	 *   =  (1 + 2 + 3 ... + n/2)*2 + (n/2)*(n/2)
	 *   n 이 홀수일때는 
	 *   =  (1 + 2 + 3 ... + n-1) + n 
	 *   
	 *   =  (1 + 2 + 3 ... + n/2) 이 부분을 recursive
	 */
	int fastSum(int n){
		
		if(n==1)
			return 1;
		if(n%2 ==1)
			return fastSum(n-1)+n;
		
		return 2*fastSum(n/2) + (n/2)*(n/2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
