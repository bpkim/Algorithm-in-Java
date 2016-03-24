package com.bp.dynamicp;

import java.util.Scanner;
/**
 * 부분집합의 합 
 * @author BP
 *
 */
public class SubsetSum {
	
	static Scanner s = new Scanner(System.in);

	boolean isSubsetSum(int set[], int n, int m) {
		if (n == 0) {
			if (m == 0)
				return true;
			else
				return false;
		}
		
		       //원하는 합인 m을 집합에서 가장 큰 수부터 빼면서 가장 작은 수까지 합해서 가능한지 확인  
		return isSubsetSum(set, n - 1, m - set[n - 1])
				|| isSubsetSum(set, n - 1, m);
				// 잡합 마지막 뒤에서 하나찍 줄여가면서 확인  

	}

	void clculateSubsetSumDynamic(int set[], int n, int m) {

		int c [][]= new int[n+1][m+1]; 
		
		int i, j;
		for (i = 0; i <= n; i++) {
			c[i][0] = 1 ;
		}
		for (i = 1; i <= m; i++) {
			c[0][i] = 0 ;
		}
		
		showArray(c,n+1,m+1);
		
		for (i = 1; i <= n; i++) {
			for (j = 1; j <= m; j++) {
				c[i][j] = 0;
				System.out.println(i+", "+j);

				// 집합의 첫번째 부터 확인 
				if(j>= set[ i-1 ]){
					System.out.println("a "+ j+ " >= "+set[ i-1 ]);
					if(c[ i-1 ][j - set[i-1]]==1)
					{	System.out.println("b "+(i-1)+" "+(j-set[i-1]) + "="+c[ i-1 ][j - set[i-1]]); 
						c[i][j]=1;
					}else
						System.out.println("c "+(i-1)+" "+(j-set[i-1]) + "="+c[ i-1 ][j - set[i-1]]); 

				}
				
				if(c[i-1][j]==1){
					System.out.println("d "+(i-1)+" "+j+" = "+c[i-1][j]);
					c[i][j] =1;
				}
				else
					System.out.println("e "+(i-1)+" "+j+" = "+c[i-1][j]);

				showArray(c,n+1,m+1);
				s.next();
				
				if(c[n][m]==1)
					System.out.println("asdf");
			}
		}
	}

	void showArray(int arr[][], int n, int m)
	{
		System.out.println("============================");
		for(int i = 0 ;  i< n ; i ++){
			for(int j = 0 ;  j< m ; j ++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	long max(long a, long b) {

		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
		SubsetSum ss = new SubsetSum();
		System.out.print("input m, n: ");
		int m = s.nextInt();
		int n = s.nextInt();

		int set[] = new int[n];

		for (int i = 0; i < n; i++) {
			set[i] = s.nextInt();
		}
		ss.clculateSubsetSumDynamic(set, n, m);
	}

}
