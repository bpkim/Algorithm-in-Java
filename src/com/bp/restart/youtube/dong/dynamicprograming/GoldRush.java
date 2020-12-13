package com.bp.restart.youtube.dong.dynamicprograming;

public class GoldRush {

    public static void main(String[] args) {

        GoldRush a = new GoldRush();

        System.out.println(a.getMaxGold(3
                , 4
                , new int[][]{{1, 3, 3, 2}
                        , {2, 1, 1, 4}
                        , {0, 6, 4, 7}}));


        int [][] goldMap = new int[][]{{1, 3, 3, 2}
                , {2, 1, 1, 4}
                , {0, 6, 4, 7}};

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 4 ; j++) {

                System.out.print(goldMap[i][j]+ " ");
            }
            System.out.println();
        }

        System.out.println("-----");
        System.out.println(a.getMaxGoldDP(3
                , 4
                , new int[][]{{1, 3, 3, 2}
                        , {2, 1, 1, 4}
                        , {0, 6, 4, 7}}));

        System.out.println(a.getMaxGold(4
                , 4
                , new int[][]{{1, 3, 1, 5}
                        , {2, 2, 4, 1}
                        , {5, 0, 2, 3}
                        , {0, 6, 1, 1}}));
    }

    /**
     * 금광
     * <p>
     * n X m 크기의 금광이 있다.
     * <p>
     * 채굴자는 첫 번째 열부터 출발하여 금을 캐기 시작한다.
     * 맨처음 첫번째열에서는 어느 행에서든 출발 할 수 있다.
     * 이후 m-1   번에 걸처서 매번 오른쪽 위, 오른쪽, 오른족 아래 3가지중 하나의 위치로 이동할 수 있다.
     * <p>
     * 결과적으로 얻을 수 있는 금의 최대 크기는
     */

    int getMaxGold(int n, int m, int[][] goldMap) {

        int goldValue = 0;
        int max = 0;
        int[] direction = {-1, 0, 1};
        int nowi = 0;
        int j = 0;
        int tmpj = 0;

        for (int i = 0; i < n; i++) {
//            System.out.print();
            if (max < goldMap[i][0]) {

                max = goldMap[i][0];
                j = i;
            }
        }
        goldValue = max;
//        System.out.println(goldValue);
        for (int i = 1; i < m; i++) {
            max = 0;
            for (int di = 0; di < 3; di++) {
//                System.out.print("j "+j+"  dd "+ (j + direction[di])+" ddd "+direction[di]);
                if (j + direction[di] > -1
                        && j + direction[di] < n) {
//                    System.out.println(" i "+ i+ " j "+ (j + direction[di])+ "  map "+ goldMap[j + direction[di] ][i]);

                    if (max < goldMap[j + direction[di]][i]) {
                        max = goldMap[j + direction[di]][i];
                        tmpj = j + direction[di];
                    }
                }
            }

            goldValue += max;
            j = tmpj;
//            System.out.println("goldValue "+ goldValue);
//            System.out.println("jj "+ j);
        }
        return goldValue;
    }


    int getMaxGoldDP(int n, int m, int[][] goldMap) {

        int[][] MEMO = new int[n][m];

        for (int i = 0; i < n; i++) {
            MEMO[i][0] = goldMap[i][0];
        }
/*
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++) {
                System.out.print(MEMO[i][j]+ " ");
            }
            System.out.println();
        }*/

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {

                int tmp;

                tmp = MEMO[i][j-1];
                if (i - 1 > -1) {
                    if (tmp < MEMO[i - 1][j - 1]) {
                        tmp = MEMO[i - 1][j - 1];
                    }
                }

                if (i + 1 < n) {
                    if (tmp < MEMO[i + 1][j - 1]) {
                        tmp = MEMO[i + 1][j - 1];
                    }
                }


                MEMO[i][j] = goldMap[i][j] + tmp;
            }
/*
            System.out.println("----");
            for(int ii = 0 ; ii < n ; ii++){
                for(int jj = 0 ; jj < m ; jj++) {
                    System.out.print(MEMO[ii][jj]+ " ");
                }
                System.out.println();
            }*/
        }
/*
        System.out.println("----");
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++) {
                System.out.print(MEMO[i][j]+ " ");
            }
            System.out.println();
        }*/


        return MEMO[n-1][m-1];
    }
}
