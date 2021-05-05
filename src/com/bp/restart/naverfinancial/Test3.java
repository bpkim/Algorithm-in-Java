package com.bp.restart.naverfinancial;

public class Test3 {
    public static void main(String [] args){
        Test3 a = new Test3();

        /*System.out.println(
                a.solution(new int [][]{{7,3,8}
                        ,{7,6,5}
                        ,{4,9,5}}));*/

        System.out.println(
                a.numMagicSquaresInside(new int [][]{{4,3,4,5,3}
                        ,{2,7,3,8,4}
                        ,{1,7,6,5,2}
                        ,{8,4,9,5,5}}));
/*
        System.out.println(
                a.solution(new int [][]{{2,2,1,1}
                        ,{2,2,2,2}
                        ,{1,2,2,2}}));

        System.out.println(
                a.solution(new int [][]{{7,2,4}
                        ,{2,7,6}
                        ,{9,5,1}
                        ,{4,3,8}
                        ,{3,5,4}}));*/
    }

    public int numMagicSquaresInside(int[][] grid) {

    int R = grid.length, C = grid[0].length;
    int ans = 0;
        for (int r = 0; r < R-2; ++r)
            for (int c = 0; c < C-2; ++c) {
        if (grid[r+1][c+1] != 5) continue;  // optional skip
        if (magic(grid[r][c], grid[r][c+1], grid[r][c+2],
                grid[r+1][c], grid[r+1][c+1], grid[r+1][c+2],
                grid[r+2][c], grid[r+2][c+1], grid[r+2][c+2]))
            ans++;
    }

        return ans;
}

    public boolean magic(int... vals) {
        int[] count = new int[16];
        for (int v: vals) count[v]++;
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }




    public int solution(int[][] A) {
        // write your code in Java SE 8
        int row = A[0].length;
        int column = A.length;
        int n = 0;
        // 정사각형이 될 수 있는 수 구 하기
        if(row < column){
            n = row;
        }else{
            n = column;
        }

        int sum = 0;
        int preSum = 0;

        //좌측 상단 위치
        int preI=-1;
        int preJ=-1;
        int nowI=0;
        int nowJ=0;

        System.out.println("nowI "+ nowI +" n "+n+ " sum "+ sum);

        while(n > 0) {
            sum = 0;
            // 행 확인
            System.out.println("nowI "+ nowI +" nowJ "+ nowJ);
            for (int i = nowJ; i < nowJ + n; i++) {
                sum += A[nowI][i];
            }
            System.out.println("nowI "+ nowI +" nowJ "+ nowJ+" n "+n+ " sum "+ sum +" pre "+preSum);
            // 최초 1행
            if(preSum == 0){
                preSum = sum;
                continue;
            }

            // 이전 행의 합과 지금 합이 같을 때
            // 다음 행 확인
            if (preSum == sum) {

                nowI++;
                continue;
            }

            // 이전 행의 합과 지금 합이 다를 때
            // nowI 위치 이동
            // n 값 감소
            if (preSum != sum) {
                preI = nowI;
                nowI = nowI+1;

                preSum = 0;

                // 초기화
                if(nowI == row -1) {
                    nowI = 0;
                    preI=-1;
                    preJ=nowJ;
                    nowJ ++;
                }
                continue;
            }

            // 행 끝까지 학인해서 같았음
            /*if(nowI + n == row){
                // 열 값 확인
                preI = nowI;
                while(true) {
                    sum = 0;
                    preSum = 0;

                    // 열 값 더하기
                    for (int i = nowI; i < nowI + n; i++) {
                        sum += A[i][nowJ];
                    }
                    // 최초 1열
                    if(sum == 0){
                        preSum = sum;
                        continue;
                    }

                    // 이전 행의 합과 지금 합이 같을 때
                    // 다음 행 확인
                    if (preSum != 0 && preSum != sum) {
                        nowJ++;
                        continue;
                    }

                    // 이전 행의 합과 지금 합이 다를 때
                    // nowI 위치 이동
                    // n 값 감소
                    if (preSum != 0 && preSum != sum) {
                        break;
                    }


                    if(nowJ + n == column){
                        return n;
                    }
                }


                preJ = nowJ;
            }*/
        }
        return 0;
    }

    int solution2( int [][] A){

        int row = A[0].length;
        int column = A.length;
        int n = 0;
        // 정사각형이 될 수 있는 수 구 하기
        if(row < column){
            n = row;
        }else{
            n = column;
        }

        for(int i = 0; i < n ; i++){

        }

        return 0;
    }

    boolean getValue(int[][] A, int i , int j, int n, int c, int d, int value){
/*
        // row
        if(d == 1){
            if(i > n ){

            }
            if(c > n){
                return 0;
            }
            return getValue(A, i+1, j, n, ++c, d, A[i][j]);
        // column
        }else if (d==2){
            if(j > n ){
                return 0;
            }
        }else if (d==3){
            if(i > n && j > n ){
                return 0;
            }
        }*/

        return false;
    }


}
