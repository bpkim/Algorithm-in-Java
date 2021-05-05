package com.bp.restart.search;

public class Search {

    /**
     * 선형 탐색
     * @param array : 찾을 배열
     * @param find  : 찾을
     * @return 찾은 idx
     */
    int linear(int [] array, int find){
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] == find) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 이진탐색 재귀
     *
     * @param array
     * @param startIdx
     * @param lastIdx
     * @param find
     * @return
     */

    int binaryRecursive(int [] array, int startIdx, int lastIdx, int find){

        if(lastIdx - startIdx < 2){
            if(array[startIdx] == find){
                return startIdx;
            }else if(array[lastIdx] == find){
                return lastIdx;
            }else{
                return -1;
            }
        }

        if(array[startIdx+(lastIdx-startIdx)/2] >= find){

            return binaryRecursive(array, startIdx, startIdx+(lastIdx-startIdx)/2, find);
        }else{
            return binaryRecursive(array, startIdx+(lastIdx-startIdx)/2+1, lastIdx, find);

        }
    }

    int binaryRecursive2(int [] array, int startIdx, int lastIdx, int find){

        if(lastIdx < startIdx){
            return -1;
        }

        int midIdx = (startIdx + lastIdx)/2;

        if(array[midIdx] == find) {
            return midIdx;
        }

        if (array[midIdx] > find){
            return binaryRecursive2(array, startIdx, midIdx-1, find);
        }else{
            return binaryRecursive2(array, midIdx+1, lastIdx, find);
        }
    }
    /**
     * 이진 탐색
     * long(n)
     * @param array
     * @param find
     * @return
     */
    int binary(int [] array, int find){
        int startIdx = 0;
        int lastIdx = array.length-1;
        int centerIdx = (lastIdx + startIdx)/2;

        while(array[centerIdx] != find){

            if(startIdx>lastIdx){
                return -1;
            }

            if(array[centerIdx] < find){
                startIdx = centerIdx +1;
            }else{
                lastIdx = centerIdx -1;
            }

            centerIdx = (lastIdx + startIdx)/2;
        }


        return centerIdx;
    }


    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8};
        Search search = new Search();
        for(int i = 0 ; i < 9 ; i ++) {
            System.out.println(search.binaryRecursive(array, 0, array.length - 1, i));
            System.out.println(search.binaryRecursive2(array, 0, array.length - 1, i));
            System.out.println(search.binary(array, i));
            System.out.println("=========");
        }
    }

}
