package com.bp.restart.youtube.dong.dynamicprograming;

public class SetWarrior {

    public static void main(String [] args){
        SetWarrior a = new SetWarrior();

        System.out.println(a.getCnt(new int[]{15, 11, 4, 8, 5, 2, 4}));

//        System.out.println(a.solution(1041));
    }


    /**
     *
     */
    int getCnt(int [] arr){

        int cnt = 0;
        int [] MEMO = new int[arr.length];
        MEMO[0] = arr[0];
        int j = 0;
        int i;
        for(i = 1; i < arr.length-1 ; i++){
            if(MEMO[j] > arr[i] && arr[i] > arr[i+1]){
                MEMO[++j] = arr[i];
            }else{
//                System.out.println("MEMO "+MEMO[j]);
//                System.out.println(arr[i]);
                cnt++;
            }
        }

        if(MEMO[j] > arr[i] ){
            MEMO[++j] = arr[i];
        }else{
//            System.out.println("MEMO "+MEMO[j]);
//            System.out.println(arr[i]);
            cnt++;
        }


        return cnt;
    }


}
