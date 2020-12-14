package com.bp.restart.codility.countingelements;

import java.util.Arrays;

public class MissingInteger {

    public static void main(String [] args){
        MissingInteger a = new MissingInteger();

        System.out.println(a.solution(new int[] {1,3,6,4,1,2}));
        System.out.println(a.solution(new int[] {1,2,3}));
        System.out.println(a.solution(new int[] {-1,-3}));
        System.out.println(a.solution(new int[] {-1}));
        System.out.println(a.solution(new int[] {}));
        System.out.println(a.solution(new int[] {1,2,3,4,5,6,8,9,10,7,22}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        if(A.length == 0){
            return 1;
        }

        Arrays.sort(A);

        int result = 0;

        int j = 0;
        int i = 1;
        while(true){

            if(j == A.length){
                result = i;
                break;
            }
//            System.out.println("i "+ i +" j "+j+" A[j] "+A[j]);

            // 음수일때 패스 다음거 확인
            if(A[j] < 0){
                j++;
                continue;
            }
            // A 한칸 증가 하여 확인
            if(i > A[j]){
                j++;
            // i 보다 크다는건 i 가 없다는것
            }else if(i < A[j]){
                result = i;
//                System.out.println("break "+result);
                break;
            // 같을때
            }else{
                i++;
                j++;
            }
        }

        // 다 음수이거나 0 일때
        if(result == 0){
            result = 1;
        }
        return result;
    }
}
