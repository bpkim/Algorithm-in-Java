package com.bp.restart.youtube.dong.serach;

public class FindNumInArr {
    public static void main(String [] args){
        int n = 7;
        int f = 2;

        FindNumInArr a = new FindNumInArr();

        System.out.println(a.findNum(new int[]{1,1,2,2,2,2,3}, 2));
        System.out.println(a.findNumBinary(new int[]{1,1,2,2,2,2,3}, 2));

    }

    /**
     * n개의 원소를 포함하고 있는 수열이 오름차순으로 정렬 되어 있다.
     * 이 수열에서 x가 등장하는 횟수를 계산하시오
     *
     * 시간복잡도는 O(log n)으로 해야한다.
     */
    int findNum(int [] arr, int f){

        int minIdx = 0;
        int maxIdx = arr.length-1;

//
//        System.out.println(minIdx);
//        System.out.println(maxIdx);
//        System.out.println("====");
        while(arr[minIdx] != f || arr[maxIdx] != f){

            if(arr[minIdx] != f){
                minIdx++;
            }

            if(arr[maxIdx] != f){
                maxIdx--;
            }
        }
//        System.out.println(minIdx);
//        System.out.println(maxIdx);
        return maxIdx - minIdx +1;
    }

    /**
     * 이거가 log n
     * @param arr
     * @param f
     * @return
     */

    int findNumBinary(int [] arr, int f){

        return getIndexRightByBinary(arr, f) - getIndexLeftByBinary(arr, f) + 1;
    }

    int getIndexLeftByBinary(int [] arr, int f){

        int maxIdx = arr.length -1;
        int minIdx = 0;
        int midIdx = ( maxIdx + minIdx ) /2;

        while(true){
            if(arr[midIdx] > f){
                minIdx = midIdx;
                midIdx = ( maxIdx + minIdx ) / 2;
            }else if(arr[midIdx] < f){

                maxIdx = midIdx;
                midIdx = ( maxIdx + minIdx ) / 2;
            }else{
                while(arr[midIdx] == f){
                    midIdx--;
                }

                break;
            }

        }
        midIdx++;
//        System.out.println("left "+ midIdx);
        return midIdx;
    }

    int getIndexRightByBinary(int [] arr, int f){

        int maxIdx = arr.length -1;
        int minIdx = 0;
        int midIdx = ( maxIdx + minIdx ) /2;

        while(true){
            if(arr[midIdx] > f){
                minIdx = midIdx;
                midIdx = ( maxIdx + minIdx ) / 2;
            }else if(arr[midIdx] < f){

                maxIdx = midIdx;
                midIdx = ( maxIdx + minIdx ) / 2;
            }else{
                while(arr[midIdx] == f){
                    midIdx++;
                }

                break;
            }

        }
        midIdx--;
//        System.out.println("right " +midIdx);
        return midIdx;
    }

}
