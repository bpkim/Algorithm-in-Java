package com.bp.restart.youtube.dong.dfsbfs;

public class EscapeMaze {
    public static void main(String [] args){
        EscapeMaze a = new EscapeMaze();

        int n = 5;
        int m = 6;

        int map [][] = {{1,0,1,0,1,0}
                , {1,1,1,1,1,1}
                , {0,0,0,0,0,1}
                , {1,1,1,1,1,1}
                , {1,1,1,1,1,1}
        };

        a.escape(map, n, m, 0,0, -1, -1);
        System.out.println(map[n-1][m-1]);



        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    /**
     * 미로 탈출
     * N, M 이 주어지고
     * N 열 M 행으로 되어 있는 미로 정보가 주어진다.
     *
     * 1 갈수 있는 길 0 이 갈 수 없는 곳
     * 움직어야 하는 최소 칸의 개수를 구하시오
     */

    void escape(int[][] map, int n, int m, int nowy, int nowx, int prey, int prex){

        if(nowy < 0 || nowy >= n
            || nowx < 0 || nowx >= m){
            return;
        }

        if(map[nowy][nowx] == 0 ){
            return;
        }


        if(prey > -1 && prey < n
                && prex > -1 && prex < m){
            map[nowy][nowx] += map[prey][prex];
        }

        escape(map, n, m, nowy+1 , nowx, nowy, nowx);
        escape(map, n, m, nowy, nowx+1, nowy, nowx);

    }

}
