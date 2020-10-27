package com.bp.restart.datastructure;

public class BFS {
    /**
     * 너비 우선 탐색 BFS
     */

    int [] recursiveCheck = null;

    public BFS(){

    }

    public void queueBFS(int[][]route){
        int [] check = new int[route.length];
        Queue queue = new Queue(100);

        int i = 0;

        queue.enqueue(i);

        while(true){
            i = queue.dequeue();

            if(i < 0){
                break;
            }

            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            System.out.println(i);
            for(int j = 0 ; j < route.length ; j ++){
                if(route[i][j] == 1){
                    queue.enqueue(j);
                }
            }
        }
    }


    public void setRecursiveCheck(int l){
        recursiveCheck = new int[l];
    }

    public void recursiveBFS(int[][] route, int i){
        if(recursiveCheck[i] != 0){
            return;
        }
        recursiveCheck[i] = 1;
        System.out.println(i);

        for(int j = 0 ; j < route.length; j++){
            if(route[i][j] != 0 && recursiveCheck[j]!=1){
                recursiveBFS(route, j);
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
        BFS bfs = new BFS();

        bfs.queueBFS(route);
        System.out.println("==================");

        bfs.setRecursiveCheck(route.length);
        bfs.recursiveBFS(route, 0);
    }
}
