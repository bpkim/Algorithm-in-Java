package com.bp.restart.hackerrank.BalancedSystemFilesPartition;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {

    /*
     * Complete the 'mostBalancedPartition' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY files_size
     */


    public static int mostBalancedPartition(List<Integer> parent, List<Integer> files_size) {
        // Write your code here

        Map<String,String> a = new HashMap<>();

        a.get()
                a.replace()


//        System.out.println(parent.size());
        int result0 = 0;
        int result1 = 0;
        for(int i = 0 ; i < parent.size() ; i++){
            if((int)parent.get(i) == 0 ){
                result0 += startGetChildFileSize(i, parent, files_size);
            }
        }
        for(int i = 0 ; i < parent.size() ; i++){
            if((int)parent.get(i) == 1 ){
//                result1 += startGetChildFileSize(i, parent, files_size);
            }
        }

        System.out.println(result0);
        System.out.println(result1);

        return Math.abs( result0 - result1);
    }

    public static int startGetChildFileSize(int nowIdx, List<Integer> parent, List<Integer> files_size){

        int result = 0;
        int tmp = 0;
        System.out.println("nowIdx "+nowIdx);
        for(int i = 0 ; i < parent.size() ; i++){
            if((int)parent.get(i) == nowIdx ){

                tmp = startGetChildFileSize(i, parent, files_size);
                System.out.println("i "+i);
                System.out.println("get "+tmp);
                result +=tmp;
//                result += startGetChildFileSize(i, parent, files_size);
            }
        }
        result += files_size.get(nowIdx);

        return result;

    }

}