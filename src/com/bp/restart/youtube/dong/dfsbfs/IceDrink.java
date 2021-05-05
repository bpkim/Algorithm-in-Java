package com.bp.restart.youtube.dong.dfsbfs;

public class IceDrink {


    int v[] = null;


    public static void main(String [] args){


        int [][] map = new int[][]  {{0, 0, 1, 1, 0}
                                    , {0, 0, 0, 1, 1}
                                    , {1, 1, 1, 1, 1}
                                    , {0, 0, 0, 0, 0}};

        int [][] map2 = new int[][]  {{0, 0, 1, 1, 0}
                , {0, 0, 0, 1, 1}
                , {1, 1, 1, 1, 1}
                , {0, 0, 0, 0, 0}};

        int n = 4;
        int m = 5;

        int ice = 0 ;


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        IceDrink a = new IceDrink();

        /* 재귀 */
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0 ){

                    a.dfs(map,n,m, i, j, ++ice);
                }
            }
        }


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map2[i][j] == 0 ){

                    a.getIce(map2,n,m, i, j, ++ice);
                }
            }
        }

        System.out.println();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---");
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map2[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     * 음료수 얼려 먹기
     *
     * n x m 크기의 얼음 틀이 있다.
     * 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시됩니다.
     * 구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주합니다.
     * 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하세요.
     *
     *
     */

    void getIce(int [][]map, int n, int m, int i, int j, int ice){

        if(i<0 || j < 0
            || i >=n || j >= m){
            return;
        }

        if(map[i][j] > 0){
            return;
        }

        map[i][j] = ice;

        getIce(map, n, m, i+1, j, ice);
        getIce(map, n, m, i, j+1, ice);
    }



    /* 재귀 */
    void dfs(int [][] map, int n, int m, int nowy, int nowx, int ice){

        System.out.println("now " +nowy +" | "+nowx);

        if(nowy >= n || nowx >= m
            || nowy < 0 || nowx < 0 ){
            return;
        }

        if(map[nowy][nowx] != 0){

            System.out.println("no way");
            return;
        }

        System.out.println("go way");
        map[nowy][nowx] = ice;

        dfs(map, n,m,nowy+1, nowx, ice);
        dfs(map, n,m,nowy-1, nowx, ice);
        dfs(map, n,m,nowy, nowx+1, ice);
        dfs(map, n,m,nowy, nowx-1, ice);
    }

}
