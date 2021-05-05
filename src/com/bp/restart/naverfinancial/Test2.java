package com.bp.restart.naverfinancial;

import java.util.Arrays;

public class Test2 {
    public static void main(String [] args){
        Test2 a  = new Test2();

        System.out.println(a.solution("acbcbba"));
        System.out.println(a.solution("axxaxa"));
        System.out.println(a.solution("aaaa"));
        System.out.println(a.solution(""));

    }

    public int solution(String S) {
        // write your code in Java SE 8

        if(S.length() == 0){
            return 0;
        }

        char [] strArr = S.toCharArray();

        Arrays.sort(strArr);

        int i = 0;
        int j = 1;
        int cnt = 0;
        while(j<strArr.length){
//            System.out.println("i "+i +" j "+j+" strArr[i] " + strArr[i] + " strArr[j] "+ strArr[j]);
            if(strArr[i] == strArr[j]){
                strArr[i] = '0';
                strArr[j] = '0';
                i+=2;
                j+=2;

            }else{
                cnt++;
                i++;
                j++;
            }

            if(j == strArr.length){
                if(strArr[i] !='0'){
                    cnt++;
                }
            }
//            System.out.println("i "+i +" j "+j +" cnt "+cnt);
        }

/*
        Arrays.sort(strArr);

        for(int a = strArr.length -1 ; a >  0 ; a--) {
            System.out.print(strArr[a]+ " ");
        }*/
//        System.out.println();
//        System.out.println("i "+i +" j "+j +" cnt "+cnt);
        return cnt;
    }


    public int solution_old(String S) {
        // write your code in Java SE 8

        char [] strArr = S.toCharArray();

        Arrays.sort(strArr);

        int i = 0;
        int j = 1;
        int cnt = 0;
        while(j<strArr.length){
//            System.out.println("i "+i +" j "+j+" strArr[i] " + strArr[i] + " strArr[j] "+ strArr[j]);
            if(strArr[i] == strArr[j]){
                strArr[i] = '0';
                strArr[j] = '0';
                i+=2;
                j+=2;

            }else{
                i++;
                j++;
            }

//            System.out.println("i "+i +" j "+j +" cnt "+cnt);
        }


        Arrays.sort(strArr);

        for(int a = strArr.length -1 ; a >  0 ; a--) {
            if(strArr[a]!='0'){
                cnt ++;
            }
        }
//        System.out.println();
//        System.out.println("i "+i +" j "+j +" cnt "+cnt);
        return cnt;
    }
}
