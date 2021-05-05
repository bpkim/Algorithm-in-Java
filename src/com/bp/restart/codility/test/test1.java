package com.bp.restart.codility.test;

import java.util.ArrayList;
import java.util.Arrays;

public class test1 {

    public static void main(String [] args){
        test1 a = new test1();

//        System.out.println(a.solution(new int[] {10,2,1,1}, new int[]{10,3,2,2}));
//        System.out.println(a.solution(new int[] {1,2,3,4}, new int[]{3,6,4,4}));
//        System.out.println(a.solution(new int[] {1,1,5}, new int[]{5,6,8}));
        System.out.println(a.solution(new int[] {2, 3}, new int[]{3, 4}));
//        System.out.println(a.solution(new int[] {2,2,2,1,5,6,7,8,1},
//                                      new int[] {2,2,2,4,5,6,7,8,9}));
    }

    /**
     Rick is really fond of fruit juices, but he is bored of their traditional flavours. Therefore, he has decided to mix as many of them as possible to obtain something entirely new as a result.
     He has N glasses, numbered from 0 to N-1, each containing a different kind of juice. The J-th glass has capacity[J] units of capacity and contains juice[J] units of juice. In each glass there is at least one unit of juice.
     Rick want to create a multivitamin mix in one of the glasses. He is going to do it by pouring juice from several other glasses into the chosen one. Each of the used glasses must be empty at the end (all of the juice from each glass has to be poured out).
     What is the maximum number of flavours that Rick can mix?
     Write a function:
     class Solution { public int solution(int[] juice, int[] capacity); }
    that, given arrays juice and capacity, both of size N, returns the maximum number of flavours that Rick can mix in a single glass.
     Examples:
     1. Given juice = [10, 2, 1, 1] and capacity = [10, 3, 2, 2], your function should return 2. Rick can pour juice from the 3rd glass into the 2nd one.
     2. Given juice = [1, 2, 3, 4] and capacity = [3, 6, 4, 4], your function should return 3. Rick can pour juice from the 0th and 2nd glasses into the 1st one.
     3. Given juice = [2, 3] and capacity = [3, 4], your function should return 1. No matter which glass he chooses, Rick cannot pour juice from the other one into it. The maximum number of flavours in the chosen glass is 1.
     4. Given juice = [1, 1, 5] and capacity = [6, 5, 8], your function should return 3. Rick can mix all juices in the 2nd glass.

     Write an efficient algorithm for the following assumptions:
     N is an integer within the range [2..100,000];
     each element of arrays juice, capacity is an integer within the range [1..1,000,000,000];
     arrays juice and capacity have the same length, equal to N;
     for each J juice[J] ≤ capacity[J].
     */

    public int solution(int[] juice, int[] capacity) {
        // write your code in Java SE 8
        int result= 1;
        int cnt = 1;
        int tmp = 0;

        int [] a;

        for(int i = 0 ; i < capacity.length ; i ++){
            capacity[i] -=juice[i];
        }

        for(int i = 0 ; i < capacity.length ; i ++){

            cnt = 1;
            tmp =0;
            a = juice.clone();
            a[i] =0;
            Arrays.sort(a);

            for(int j = 0 ; j < juice.length ; j++) {

                if(a[j] < 1){
                    continue;
                }
//                System.out.println(" 그릇 용량 " +capacity[i] +" 담겨있는 주스 양 "+ tmp + "주스 양 "+ a[j]);

                if(capacity[i] >= (tmp + a[j])){
//                    System.out.println("담자 ");
                    tmp += a[j];
                    cnt ++;
                }
//                System.out.println("cnt "+ cnt);
//                System.out.println("tmp "+ tmp);

            }

            if(result < cnt){
                result = cnt;
            }

        }

        return result;
    }
}
