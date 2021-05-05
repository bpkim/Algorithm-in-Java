package com.bp.restart.naverfinancial;

public class Test1 {
    public static void main(String [] args){

        Test1 a = new Test1();

        System.out.println(a.solution(new int [] {1,0,0}));
        System.out.println(a.solution(new int [] {0,0}));

    }

    int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 1;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            }
            else
                k = 0;

            i = i - 1;
        }
        if (A[i] == 1 && k + 1 >= maximal)
            result = 0;
        return result;
    }

}

/*

class Solution {
    int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            }
            else
                k = 0;

            i = i - 1;
        }
        if (A[i] == 1 && k + 1 > maximal)
            result = 0;
        return result;
    }
}


 */
