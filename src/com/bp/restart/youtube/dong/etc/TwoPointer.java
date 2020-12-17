package com.bp.restart.youtube.dong.etc;

public class TwoPointer {

    public static void main(String [] args){

        TwoPointer a = new TwoPointer();

        System.out.println(a.getArrCnt(5, new int[]{1,2,3,2,5}));
    }

    /**
     * 투포인터 알고리즘
     *
     * 리스트에 순차적으로 접근해야 할 때 두 개의 점의 위치를 기록하면서 처리하는 알고리즘
     *
     * 리스트에 담긴 데이터에 접근할 때는 시작점과 끝점 2개의 점으로 접근할 데이터 범위를 표현
     *
     * */


    /**
     * 특정한 합을 가지는 부분 연속 수열 찾기
     *
     * 합이 M 인 부분 연속 수열의 개수를 구하시오
     *
     *
     */

    int getArrCnt(int m, int [] arr){

        int start = 0;
        int end = 0;
        int cnt = 0;

        int sum = arr[0];

//        System.out.println("sum "+ sum);
        while(end < arr.length ){

            if(sum > m){
                sum -=arr[start];
                start ++;
                continue;

            }else if(sum < m){
                end ++;

            }else{
                cnt ++;
                end ++;

            }

            if(end > arr.length -1){
                break;
            }

            sum +=arr[end];

//            System.out.println("sum "+ sum);
        }
        return cnt;
    }
}
