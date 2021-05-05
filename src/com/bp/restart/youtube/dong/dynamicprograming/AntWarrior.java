package com.bp.restart.youtube.dong.dynamicprograming;

public class AntWarrior {
    int n = 7;
    public static void main(String [] args){

        AntWarrior a = new AntWarrior();

        System.out.println(a.solution(a.n,     new int []{1,3,1,5,2,5,6}));

        System.out.println(110000>>1);

        System.out.println(Math.pow(10,2));

    }

    /**
     * 개미전사는 부족한 식량을 충당하고자 메뚜기 마을의 식량창고를 몰래 공격하려고 한다.
     * 메뚜기 마을에는 여러 개의 식량창고가 있는데 식량창고는 일직선으로 이어져 있습니다.
     *
     * 각 식량창고에는 정해진 수의 식량을 저장하고 있으며 개미전사는 식량창고를 선택적으로
     * 약탈하여 식량을 빼앗을 예정입니다. 이때 메뚜기 정찰병들은 일직선상에 존재하는 식량차고
     * 중에서 서로 인접한 식량창고가 공격받으면 바로 알아챌 수 있습니다.
     *
     * 따라서 개미 전사가 정찰별에게 들키지 않고 식량창고를 약탈하기 위해서는 최소한 한 칸
     * 이상 떨어진 식량창고를 약탈해야 합니다.
     *
     * 예를 들어
     * 1 3 1 5
     * 의 식량창고가 존재한다.
     * 이때 개미는 두 번째와 네 번째 식량창고를 선택 했을 때 최댓값인 총 8개의 식량을 빼앗을 수 있다.
     *
     * 식량창고 N개에 대한 정보가 주어졌을 때 얻을 수 있는 식량의 최댓값을 구하는 프로그램을 작성하세요.
     *
     */
/*
    int getMaxFoodFinal(int [] arr){
        int max = Integer.MIN_VALUE;
        int memo[] = new int[arr.length];

        for(int i = 0 ; i < arr.length; i++){

            for(int j = i+2 ; j < arr.length ; j++){
                if(arr[j] > max){
                    max = arr[j];
                }
            }

            memo[i]
        }

        return max;
    }*/

    /**
     * a i = i 번째 식량창고까지의 최적의 해(얻을 수 있는 식량의 최댓값)
     * k i = i 번째 식량창고에 있는 식량의 양
     *
     * 점화식
     *  a i = max(a i-1, a i-2 + k i) */

    int solution(int n, int [] arr){
        int [] d = new int[n];

        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for(int i = 2 ; i < n ; i++){
            d[i] = Math.max(d[i-1], d[i-2] + arr[i]);
        }
        for(int j = 0 ; j < d.length ; j++){
            System.out.print(d[j]+", ");
        }
        System.out.println();
        return d[n-1];
    }
}
