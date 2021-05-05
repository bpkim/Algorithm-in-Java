package com.bp.restart.codility.arrays;

import java.util.Arrays;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        OddOccurrencesInArray a = new OddOccurrencesInArray();

        System.out.println(a.solution(new int[]{9,3,9,3,9,7,9}) );
        System.out.println(a.solution(new int[]{9,2,2,9}) );
        System.out.println(a.solution(new int[]{1000000,9,1000000,9,1,1,5555}) );

    }


    /**
     * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
     * <p>
     * For example, in array A such that:
     * <p>
     * A[0] = 9  A[1] = 3  A[2] = 9
     * A[3] = 3  A[4] = 9  A[5] = 7
     * A[6] = 9
     * the elements at indexes 0 and 2 have value 9,
     * the elements at indexes 1 and 3 have value 3,
     * the elements at indexes 4 and 6 have value 9,
     * the element at index 5 has value 7 and is unpaired.
     * Write a function:
     * <p>
     * class MinAbsSum { public int solution(int[] A); }
     * <p>
     * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
     * <p>
     * For example, given array A such that:
     * <p>
     * A[0] = 9  A[1] = 3  A[2] = 9
     * A[3] = 3  A[4] = 9  A[5] = 7
     * A[6] = 9
     * the function should return 7, as explained in the example above.
     * <p>
     * Write an efficient algorithm for the following assumptions:
     * <p>
     * N is an odd integer within the range [1..1,000,000];
     * each element of array A is an integer within the range [1..1,000,000,000];
     * all but one of the values in A occur an even number of times.
     */

    public int solution(int[] A) {
        // write your code in Java SE 8

        if(A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return A[0];
        }

        Arrays.sort(A);
        int front = 0;
        int front2 = 1;
        int end = A.length-1;
        int end2 = A.length-2;
        int result = 0 ;

        for(int a : A){
            System.out.print(a +" ");
        }
        System.out.println();

        while(front2 < A.length && end2 > 0){
            if( A[front] != A[front2]){
                result = A[front];
                System.out.println("front " + A[front] + "!= "+A[front2]);
                break;
            }
            front+=2;
            front2+=2;

            if( A[end2] != A[end]){
                System.out.println("end " +A[end2] + "!= "+A[end]);
                result = A[end];
                break;
            }
            end-=2;
            end2-=2;

        }

        System.out.println("===");

        return result;
    }



    public int solution2(int[] A) {

        // write your code in Java SE 8

        if(A.length == 1){
            return A[0];
        }
        Arrays.sort(A);

        int result = 0;

        int fLeft = 0;
        int fRight = 1;

        int eLeft = A.length -2;
        int eRight = A.length -1;

        while(fRight < A.length -1 && eLeft > -1){

            // 다를때
            // System.out.println("fLeft  fRight");
            // System.out.println(fLeft +" / "+fRight);
            // System.out.println(A[fLeft] +" / "+A[fRight]);
            if(A[fLeft] != A[fRight]){
                // 한칸 움직여서 확인
                result = A[fLeft];
                break;
            }

            // System.out.println("eLeft  eRight");
            // System.out.println(eLeft +" / "+eRight);
            // System.out.println(A[eLeft] +" / "+A[eRight]);
            if(A[eLeft] != A[eRight]){
                result = A[eRight];
                break;
            }

            fLeft+=2;
            fRight+=2;
            eLeft-=2;
            eRight-=2;
        }
/*
        if(result == 0){
            result = A[A.length-1];
        }
*/
        return result;
    }
}
