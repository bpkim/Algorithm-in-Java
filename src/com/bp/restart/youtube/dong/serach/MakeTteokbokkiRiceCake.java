package com.bp.restart.youtube.dong.serach;

import java.util.Arrays;

public class MakeTteokbokkiRiceCake {

    public static void main(String [] args){
        MakeTteokbokkiRiceCake a = new MakeTteokbokkiRiceCake();

        int n = 4;
        int m = 6;
        int [] teeokbookiList = new int[]{19, 15, 10 , 17};

        long start = System.currentTimeMillis();
        System.out.println(a.getMaxHeight(teeokbookiList, m));
        long end = System.currentTimeMillis();
        System.out.println("걸린시간(초) : " + (end - start) * 1000);
        System.out.println("걸린시간(밀초) : " + (end - start));
    }

    /**
     * 떡볶이 떡 만들기
     *
     * 떡볶이 떡의 길이는 일정하지 않는다.
     * 절단기 높이를 지정하면 그 높이 대로 떡이 잘린다.
     * 높이 보다 작으면 안잘리고 높이보다 길면 잘린다.
     *
     * 떡의 높이가 19 14 10 17 인 떡이 있고 절단기 높일가 15일때
     * 잘린 떡의 길이는 4 0 0 2 이고
     * 손님은 잘린 떡 6을 가져간다.
     *
     * 떡의갯수 | 가져가는 떡의 길이
     * 4 6
     * 19 15 10 17
     *
     * 출력 15
     */
    int getMaxHeight(int [] arr, int m){

//        Arrays.sort(arr);
        int max = (int)1e9;
                //arr[arr.length-1];
        int min = 0;
        int mid = ( max + min )/2;
        int slice = 0;

//        System.out.println("slice "+ slice);

        while(true){

            slice = 0;

            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i] > mid){
//                    System.out.println("arr "+arr[i] + " arr slice "+(arr[i] - mid));
                    slice+=arr[i]-mid;
                }
            }

//            System.out.println("slice "+ slice);

            if(slice == m){
                break;
            }
            if(slice > m) {
                int tmp = mid;
                mid = (mid + max)/2;
                min = tmp;
            }else {
                int tmp = mid;
                mid = (min + mid)/2;
                max = tmp;
            }

        }

        return mid;
    }
}
