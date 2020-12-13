package com.bp.restart.youtube.dong.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxArrChange {
    public static void main(String [] args){
        int k = 3;
        MaxArrChange a = new MaxArrChange();
        long startA = System.currentTimeMillis();
        System.out.println(a.getMaxArrA(k, new int[]{1,2,5,4,3}, new int[]{5,5,6,6,5}));
        long startB = System.currentTimeMillis();
        System.out.println(a.getMaxArrAUsingSort(k, new Integer[]{1,2,5,4,3}, new Integer[]{5,5,6,6,5}));
        long startC = System.currentTimeMillis();


    }
    /**
     * N 과 K K 가 주어진다.
     * 배열 A와 B가 주어진다.
     * N 은 배열의 길이
     * K 바꿀 수 있는 횟수
     *
     * 배열 A와 B는 K 번 원소를 바꿀 수 있다.
     * 이때 A의 원소 총합이 가장 큰 수를 구하라
     *
     */

    int getMaxArrA(int k, int [] A, int [] B){

        while(k > 0 ){

            int minA = 10000000;
            int minAIdx = 0;
            int maxB = -1;
            int maxBIdx = 0;

            for(int i = 0 ; i < A.length ; i ++){
                if(A[i] < minA){
                    minA = A[i];
                    minAIdx = i;
                }
            }

            for(int i = 0 ; i < B.length ; i ++){
                if(B[i] > maxB){
                    maxB = B[i];
                    maxBIdx = i;
                }
            }

            A[minAIdx] = maxB;
            B[maxBIdx] = minA;

            /*
            System.out.println("======== "+k);
            for(int i = 0 ; i < A.length ; i ++) {
                System.out.print(A[i]+" ");
            }
            System.out.println();
            for(int i = 0 ; i < B.length ; i ++) {
                System.out.print(B[i]+" ");
            }
            System.out.println();
            */

            k--;
        }

        int result = 0;
        for(int i = 0 ; i < A.length ; i ++) {
//            System.out.print(A[i]+" ");
            result += A[i];
        }
//        System.out.println();
        return result;
    }
    int getMaxArrAUsingSort(int k, Integer [] A, Integer [] B){

        List<Integer> ListA = new ArrayList<>();
        List<Integer> ListB = new ArrayList<>();

        for(int tmp : A){
            ListA.add(tmp);
        }
        for(int tmp : B){
            ListB.add(tmp);
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i = 0 ; i < k; i++){

            if(A[i] < B[i]){
                int tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
            }
        }

        int result = 0;
        for(int i = 0 ; i < A.length ; i ++) {
//            System.out.print(A[i]+" ");
            result += A[i];
        }
//        System.out.println();
        return result;
    }
}
