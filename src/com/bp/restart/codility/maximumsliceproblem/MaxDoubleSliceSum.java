package com.bp.restart.codility.maximumsliceproblem;

public class MaxDoubleSliceSum {

    public static void main(String [] args){
        MaxDoubleSliceSum a = new MaxDoubleSliceSum();

//        System.out.println(a.solution(new int[]{3,2,6,-1,4,5,-1,2}));
//        System.out.println(a.solution(new int[]{5,5,5,15,7}));
        System.out.println(a.solution(new int[]{5,3,4,5,-3,-3,9}));
    }
    /**
     A non-empty array A consisting of N integers is given.

     A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

     The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

     For example, array A such that:

     A[0] = 3
     A[1] = 2
     A[2] = 6
     A[3] = -1
     A[4] = 4
     A[5] = 5
     A[6] = -1
     A[7] = 2
     contains the following example double slices:

     double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
     double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
     double slice (3, 4, 5), sum is 0.
     The goal is to find the maximal sum of any double slice.

     Write a function:

     class Solution { public int solution(int[] A); }

     that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

     For example, given:

     A[0] = 3
     A[1] = 2
     A[2] = 6
     A[3] = -1
     A[4] = 4
     A[5] = 5
     A[6] = -1
     A[7] = 2
     the function should return 17, because no double slice of array A has a sum of greater than 17.

     Write an efficient algorithm for the following assumptions:

     N is an integer within the range [3..100,000];
     each element of array A is an integer within the range [−10,000..10,000].

     */
    public int solution(int[] A) {
        // write your code in Java SE 8

        if(A.length <6){
            return 0;
        }

        int max = Integer.MIN_VALUE ;

        int sumA = 0;
        int sumB = 0;
        int y = 1;
        int x =0;
        int z =A.length-1;


        for(int i = 1 ; i < A.length ; i++){
            if(A[i] > 0){
                sumA=A[i];
                y = i+1;
                x  = i;
                break;
            }
        }

        for(int i = A.length-2 ; i > y ; i--){
//            System.out.println(i);
            if(sumB == 0 && A[i] > 0){
                z = i;
            }else if(sumB == 0 && A[i] < 0){
                continue;
            }
            sumB+=A[i];
        }

        System.out.println("X " + x +" Y "+y + " X "+z);
        System.out.println("max "+max +"+ < "+ sumA +" + " +sumB);
        if(max < (sumA+sumB)){
            max = sumA+sumB;
        }
//        y++;

        while(y < z){
            System.out.println("Y "+y);
            System.out.println("A[y] "+ A[y]);
            sumA+=A[y];
            sumB-=A[y+1];

//            System.out.println("X " + x +" Y "+y + " X "+z);
//            System.out.println("max "+max +"+ < "+ sumA +" + " +sumB);
            if(max < (sumA+sumB)){
                max = sumA+sumB;
            }
            y++;
        }

        return max;
    }
}
