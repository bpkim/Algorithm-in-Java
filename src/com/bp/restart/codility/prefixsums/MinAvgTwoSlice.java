package com.bp.restart.codility.prefixsums;

public class MinAvgTwoSlice {

    public static void main(String [] args){
        MinAvgTwoSlice a = new MinAvgTwoSlice() ;

        System.out.println(a.solution_old(new int [] {4,2,2,5,1,5,8}));
        System.out.println(a.solution(new int [] {4,2,2,5,1,5,8}));
    }

    /*
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
     */


    public int solution(int[] A) {
        // write your code in Java SE 8

        if(A.length < 4){
            return 0;
        }

        int result = 0;
        int p = 0 ;
        int q = A.length-2;
        float sum = 0;
        float min = Float.MAX_VALUE;

        float [] memo = new float[A.length];
        memo[0] = A[0];
        for(int i = 1 ; i < A.length ; i++){
            memo[i] = memo[i-1]+A[i];
        }
/*
        System.out.println("--");
        for(int i = 0 ; i < A.length ; i++){
            System.out.print(memo[i]+ " ");
        }
        System.out.println("===");
*/

        while(p < A.length-2){

            if(p == q){
                p++;
                q = A.length-2;
                if(p >= q){
                    break;
                }
            }

            if(p ==0){
                sum = memo[q];
            }else{
                sum = memo[q] - memo[p-1];
            }


//          System.out.println(" - p "+ p +" q "+ q + " sum " + sum);
            sum = sum/(q-p+1);
//          System.out.println(" p "+ p +" q "+ q + " sum " + sum);

            if(sum < min ){
//              System.out.println("sum "+ sum + " "+ min + " p "+p);
                result = p;
                min = sum;
            }


            q--;
        }

        return result;
    }


    public int solution_old(int[] A) {
        // write your code in Java SE 8

        if(A.length < 4){
            return 0;
        }

        int result = 0;
        int p = 0 ;
        int q = A.length-2;
        float sum = 0;
        float min = Float.MAX_VALUE;

        /*int [] memo = new int[A.length];
        memo[0] = A[0];
        for(int i = 1 ; i < A.length ; i++){
            memo[i] = memo[i-1]+A[i];
        }*/
        while(p < A.length-2){

            if(p == q){
                p++;
                q = A.length-2;
                if(p >= q){
                    break;
                }
            }

            sum = 0;

            for(int i = p ; i <= q ; i++){
//              System.out.println("sum "+sum+ " "+A[i]);
                sum+=A[i];
            }


          System.out.println(" - p "+ p +" q "+ q + " sum " + sum);
            sum = sum/(q-p+1);
          System.out.println(" p "+ p +" q "+ q + " sum " + sum);

            if(sum < min ){
              System.out.println("sum "+ sum + " "+ min + " p "+p);
                result = p;
                min = sum;
            }


            q--;
        }

        return result;
    }


}
