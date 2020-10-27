package com.bp.restart.maxmin;

public class MaxMin {
    /**
     * 최대와 최소
     * */
    int min(int x, int y ){
        if( x < y )
            return x;
        return y;
    }


    int max(int x, int y ){
        if( x < y )
            return y;
        return x;
    }

    /**
     * 배열에서 가장 큰 수 구하기
     * @param arr
     * @return
     */
    int maxArr(int arr[]){
        int maxa, i;
        maxa = arr[0];

        for(i = 1 ; i < arr.length ; i++) {
            if (arr[i] > maxa) {
                maxa = arr[i];
            }
        }

        return maxa;
    }

    int reverseMaxArr(int arr[]){
        return 0;
    }

    public static void main(String[] args) {
        MaxMin maxmin = new MaxMin();

        System.out.println(maxmin.maxArr(new int[]{1,2,7,2,3,5}));
    }
}
