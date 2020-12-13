package com.bp.restart.youtube.dong.dijkstra;

public class Dijkstra {

    public static void main(String [] args){

        Dijkstra a = new Dijkstra();
        a.goDijkstraArray();


    }


    class Node{
        private int index;
        private int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int getIndex(){
            return this.index;
        }

        public int getDistance(){
            return this.distance;
        }
    }


    class Heap {

        final static int MAX_SIZE = 100;
        int heap[];
        int idx;

        Heap() {
            idx = -1;
            heap = new int[MAX_SIZE];
        }

        int getParent(int i) {
            if (i % 2 != 0)
                return i / 2;
            else
                return (i / 2) - 1;
        }

        int getLeftChild(int i) {
            return (i * 2) + 1;
        }

        int getRightChild(int i) {
            return (i * 2) + 2;
        }

        void swap(int a, int b) {
            int temp = heap[a];
            heap[a] = heap[b];
            heap[b] = temp;

        }

        void insert(int a) {
            heap[++idx] = a;
            int i = idx;

            while ((i != 0) && (heap[getParent(i)] < heap[i])) {
                swap(getParent(i), i);
                i = getParent(i);
            }
        }

        int pop() {

            int result = heap[0];
            heap[0] = heap[idx];
            heap[idx--] = 0;
            int i = idx;

            int cIdx, lIdx, rIdx;
            while (true) {

                lIdx = getLeftChild(i);
                rIdx = getRightChild(i);

                cIdx = (lIdx < rIdx) ? rIdx : lIdx;

                if(heap[cIdx]<1)
                    break;

                if (heap[i] < heap[cIdx]) {
                    swap(i, cIdx);
                    i = cIdx;
                } else
                    break;
            }
            return result;
        }

        boolean isHeapEmpty() {
            if(idx==-1)
                return true;
            else
                return false;
        }
    }

    /* 1. arrary */
    void goDijkstraArray(){

        int [][] map
                = {{0,2,0,1,0,0}
                ,{0,0,3,2,0,0}
                ,{0,3,0,0,0,5}
                ,{0,0,3,0,1,0}
                ,{0,0,1,0,0,2}
                ,{0,0,0,0,0,0}};

        int [] check = new int[6];

        int [] distance = new int[6];


        int chkCnt = 0;
        int minD = Integer.MAX_VALUE;
        int i = 0;
        while(chkCnt < 6){

            // 갈곳 체크
            check[i] = 1;

            // 노드 탐색 하기
            for(int j = 0 ; j < 6 ; j++){

                // 길이 있는 곳 체크
                if(map[i][j] > 0 ){
                    // 길이 체크를 안했거나
                    // 현재 확인한 길이보다 작을 때 길이 바꾸기
                    if(distance[j] == 0 || (distance[j] > (map[i][j] + distance[i])) ){
                        distance[j] = map[i][j] + distance[i];

                    }
                }
            }
/*
            System.out.println("==== "+i);
            for(int j = 0 ; j < 6 ; j++ ){
                System.out.println(distance[j]);
            }

            System.out.println("==== ");
            for(int j = 0 ; j < 6 ; j++ ){
                System.out.println(check[j]);
            }
            System.out.println("+++++chk ");*/

            // 다음에 갈 노드 찾기
            for(int j = 0 ; j < 6 ; j++){
                // 안간 곳
                if(check[j] == 0){
//                    System.out.println("mind "+ minD + " "+distance[j] +" "+j);
                    if(distance[j] != 0 && minD > distance[j]){

                        minD = distance[j];
                        i = j;
                    }
                }
            }

            minD = Integer.MAX_VALUE;
            chkCnt++;
//            System.out.println(" i "+i);
        }
        for(int j = 0 ; j < 6 ; j++ ){
            System.out.println(distance[j]);
        }

    }
}
