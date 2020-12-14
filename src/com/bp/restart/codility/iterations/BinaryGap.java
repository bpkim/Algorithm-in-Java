package com.bp.restart.codility.iterations;

public class BinaryGap {
    public static void main(String [] args){
        BinaryGap a = new BinaryGap();
        System.out.println(a.solution(32));
        System.out.println(a.solution(16));
        System.out.println(a.solution(1401));
    }


    public int solution(int N) {
        // write your code in Java SE 8

        int maxCnt = 0;
        int nowCnt = -1;
        int start = -1;/* -1 : 시작안함 / 1 : 시작 / 0 : 진행중 */
        while(N > 0){
//            System.out.println(" N % 2 "+ ( N % 2 ));
            if( N % 2 == 0 ){
                // 시작
                if(start == 1){
                    nowCnt =1;
                    start = 0;
                    // 진행중
                }else if(start == 0){
                    nowCnt ++;
                }

            }else{
                // 시작
                start = 1;
                if(maxCnt < nowCnt){
                    maxCnt = nowCnt;
                }

            }
            N = N/2;

            /*System.out.println("N "+N);
            System.out.println("start "+start);
            System.out.println("maxCnt "+maxCnt);
            System.out.println("nowCnt "+nowCnt);
            System.out.println("-----------");*/
        }
        /*System.out.println("-----");
        System.out.println("N "+N);
        System.out.println("maxCnt "+maxCnt);*/
        return maxCnt;
    }

}
