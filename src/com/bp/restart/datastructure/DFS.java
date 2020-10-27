package com.bp.restart.datastructure;

import static java.lang.System.currentTimeMillis;

public class DFS {

    /**
     * 깊이 우선 탐색 DFS
     *
     * 스택으로 만든다.
     */

    int [] recursiveCheck = null;

    public DFS(){

    }

    public void stackDFS(int[][] route){
        int [] check = new int[route.length];

        Stack stack = new Stack();
        int i = 0;
        stack.push(i);

        while(true){
            i = stack.pop();

            // 큐가 비었을때 없을 때
            if(i<0){
                break;
            }
            // 간곳 인지 확인
            if(check[i] == 1){
                continue;
            }
            System.out.println(i);
            check[i] = 1;
            for(int j = 0 ; j < route.length ; j++){
                if(route[i][j] == 1){
                    stack.push(j);
                }
            }

        }

    }

    public void setRecursiveCheck(int l){
        recursiveCheck = new int[l];
    }

    public void recursiveDFS(int[][] route, int i){
        if(recursiveCheck[i] != 0){
            return;
        }
        recursiveCheck[i] = 1;
        System.out.println(i);

        for(int j = route.length -1 ; j > 0 ; j--){
            if(route[i][j] != 0 && recursiveCheck[j]!=1){
                recursiveDFS(route, j);
            }
        }
    }

    public static void main(String[] args) {
/*
        int[][] route = {{0,1,0,0,1,0}
                        ,{1,0,1,0,1,0}
                        ,{0,1,0,1,0,0}
                        ,{0,1,1,0,1,1}
                        ,{1,1,0,1,0,0}
                        ,{0,0,0,1,0,0}};
*/
        int[][] route = { { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, };
        DFS dfs = new DFS();

        dfs.stackDFS(route);

        System.out.println("==================");

        dfs.setRecursiveCheck(route.length);
        dfs.recursiveDFS(route, 0);
    }
}
