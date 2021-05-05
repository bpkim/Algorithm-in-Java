package com.bp.dynamicp;

import java.util.Scanner;

/**
 * WaytoWork 출근길 클래스 경로 갯수 세기 프로그램
 * 
 * @author BP
 *
 */
public class WaytoWork {
	final static int M = 100;
	final static int N = 100;

	final static int MAP[][] = new int[M][N];
	//	이모제이션
	final static long MEMO[][] = new long[M][N];
	//	다이나믹
	final static long DYNAMIC_PATH[][] = new long[M][N];

	final static long JOY_PATH[][] = new long[M][N];

	final static int JOY_BACK_ROUTE[][] = new int[M][N];
	final static int JOY_ROUTE[][] = new int[M][N];

	enum TURN {
		UP, RIGHT
	};

	WaytoWork() {

	}

	long numPathRecursive(int m, int n) {

		if (MAP[m][n] == 0)
			return 0;
		if (m == 0 && n == 0)
			return 1;

		return ((m > 0) ? numPathImo(m - 1, n) : 0)
				+ ((n > 0) ? numPathImo(m, n - 1) : 0);

	}

	long numPathImo(int m, int n) {

		if (MEMO[m][n] > 0)
			return MEMO[m][n];

		if (MAP[m][n] == 0)
			return 0;
		if (m == 0 && n == 0)
			return 1;

		return MEMO[m][n] = (((m > 0) ? numPathImo(m - 1, n) : 0) + ((n > 0) ? numPathImo(
				m, n - 1) : 0));

	}

	/* *
	 * 동적 프로그래밍 테이블을 채워 나가느면서 값을 구하는 방법
	 */
	void numPathDynamic(int m, int n) {

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (MAP[i][j] == 0)
					continue;

				if (i == 0 || j == 0)
					DYNAMIC_PATH[i][j] = MAP[i][j];
				else if (i > 0 && j > 0)
					DYNAMIC_PATH[i][j] = DYNAMIC_PATH[i - 1][j]
							+ DYNAMIC_PATH[i][j - 1];
			}
		}
	}

	/*
	 * 
	 */
	long getMaxJoyPathRecursive(int m, int n) {

		if (m == 0 && n == 0)
			return JOY_PATH[m][n] = MAP[m][n];

		if (m == 0 && n > 0)
			return JOY_PATH[m][n] = MAP[m][n] + MAP[m][n - 1];
		if (m > 0 && n == 0)
			return JOY_PATH[m][n] = MAP[m - 1][n] + MAP[m][n];

		return JOY_PATH[m][n] = (max(getMaxJoyPathRecursive(m - 1, n),
				getMaxJoyPathRecursive(m, n - 1)) + MAP[m][n]);
	}

	void getMaxJoyPathDynamic(int m, int n) {

		JOY_PATH[0][0] = MAP[0][0];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j > 0) {
					JOY_PATH[i][j] = MAP[i][j - 1] + MAP[i][j];
					// Turn right
					JOY_BACK_ROUTE[i][j] = 1;
					JOY_ROUTE[i][j-1] = 1;
				} else if (i > 0 && j == 0) {
					JOY_PATH[i][j] = MAP[i - 1][j] + MAP[i][j];
					// Turn down
					JOY_BACK_ROUTE[i][j] = 2;
					JOY_ROUTE[i-1][j] = 2;

				} else if (i > 0 && j > 0) {
					if (JOY_PATH[i][j - 1] > JOY_PATH[i - 1][j]) {
						JOY_PATH[i][j] = JOY_PATH[i][j - 1] + MAP[i][j];
						JOY_BACK_ROUTE[i][j] = 1;
						JOY_ROUTE[i][j-1] = 1;

					} else {
						JOY_PATH[i][j] = JOY_PATH[i - 1][j] + MAP[i][j];
						JOY_BACK_ROUTE[i][j] = 2;
						JOY_ROUTE[i-1][j] = 2;

					}
				}

			}
		}
	}

	void printBackPath(int m, int n){
		
		if (m==0 && n==0)
			return ;
		
		System.out.print("("+m+", "+n+")"+" ");

		//Rignt
		if(JOY_BACK_ROUTE[m][n]==1)
			printBackPath(m,n-1);
		// Down
		else if(JOY_BACK_ROUTE[m][n]==2)
			printBackPath(m-1,n);
	}

	// �ȵ�
	void printPath(int m, int n){
		
		if (m==4 && n==4)
			return ;
		
		System.out.print("("+m+", "+n+")"+" ");

		//Rignt
		if(JOY_ROUTE[m][n]==1)
			printBackPath(m,n+1);
		// Down
		else if(JOY_ROUTE[m][n]==2)
			printBackPath(m+1,n);
	}
	
	
	long max(long a, long b) {

		return (a > b) ? a : b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m, n;
		Scanner s = new Scanner(System.in);
		WaytoWork wtw = new WaytoWork();
		m = s.nextInt();
		n = s.nextInt();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				MAP[i][j] = s.nextInt();
			}
		}

		wtw.getMaxJoyPathDynamic(m ,n );
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(JOY_ROUTE[i][j] + " ");
			}
			System.out.println();
		}
		
		wtw.printBackPath(m-1,n-1);
		//wtw.printPath(0,0);
	}

}
