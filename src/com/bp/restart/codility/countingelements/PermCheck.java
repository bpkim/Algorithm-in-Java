package com.bp.restart.codility.countingelements;

import java.util.Arrays;

public class PermCheck {

    public static void main(String [] args){
        PermCheck a = new PermCheck();

        System.out.println(a.solution(new int[]{2}));
    }
    /**
     *
     * A non-empty array A consisting of N integers is given.
     *
     * A permutation is a sequence containing each element from 1 to N once, and only once.
     *
     * For example, array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     *     A[3] = 2
     * is a permutation, but array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     * is not a permutation, because value 2 is missing.
     *
     * The goal is to check whether array A is a permutation.
     *
     * Write a function:
     *
     * class MinAbsSum { public int solution(int[] A); }
     *
     * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
     *
     * For example, given array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     *     A[3] = 2
     * the function should return 1.
     *
     * Given array A such that:
     *
     *     A[0] = 4
     *     A[1] = 1
     *     A[2] = 3
     * the function should return 0.
     *
     * Write an efficient algorithm for the following assumptions:
     *
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [1..1,000,000,000].
     *
     */


    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 0){
            return 0;
        }

        Arrays.sort(A);

        int i = 1;
        int j = 0;

        while(j < A.length){

            // 같으면 패스
            if(i == A[j]){
                j++;
                i++;

            // i가 작으면 A에 없다는 것 이므로 연결되는 배열 아님
            }else{
                break;
            }
        }

        // 배열 끝까지 확인 못했으면 순차 배열 아님
        if(j < A.length){
            return 0;
        // 배열 끝까지 확인 했으면 순차 배열
        }else{
            return 1;
        }

    }
}
