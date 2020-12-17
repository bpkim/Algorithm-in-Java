package com.bp.restart.codility.prefixsums;

public class CountDiv {

    public static void main(String [] args){
        CountDiv a = new CountDiv() ;

        long start= System.currentTimeMillis();
        System.out.println(a.solution2(0, 0, 2000000000));
        long mid = System.currentTimeMillis();
        System.out.println(mid - start);
        System.out.println(a.solution3(0, 0, 2000000000));
        long end = System.currentTimeMillis();
        System.out.println(mid - end);
    }
    /**
     *
medium
     Write a function:

     class MinAbsSum { public int solution(int A, int B, int K); }

     that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

     { i : A ≤ i ≤ B, i mod K = 0 }

     For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

     Write an efficient algorithm for the following assumptions:

     A and B are integers within the range [0..2,000,000,000];
     K is an integer within the range [1..2,000,000,000];
     A ≤ B.

     */
    public int solution2(int A, int B, int K) {
        // write your code in Java SE 8

        if(K == 1){
            return B-A +1;
        }

        int cnt = 0;
        for(int i = A ; i <=B ; i++){

            if(i%K == 0){
                cnt++;
            }
        }

        return cnt;
    }


    public int solution3(int A, int B, int K) {
        // write your code in Java SE 8

        if(K == 1){
            return B-A +1;
        }

        if(A == 0 ){
            return B/K +1;
        }
        return B/K - (A-1)/K;

    }

    public int solution(int A, int B, int K) {
        // write your code in Java SE 8

        if(K == 1){
            return B-A +1;
        }

        int cnt = 0;
        int i = A;
        while(i <= B+1){

            if(i%K == 0 ){

                while(i * cnt < B+1){
                    System.out.println("cnt "+cnt );
                    cnt++;
                }

                break;

            }

            i++;
        }

        return cnt;
    }
}
