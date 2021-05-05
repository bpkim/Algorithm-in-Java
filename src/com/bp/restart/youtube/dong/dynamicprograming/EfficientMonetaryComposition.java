package com.bp.restart.youtube.dong.dynamicprograming;

import java.util.Arrays;

public class EfficientMonetaryComposition {
    public static void main(String [] args){
        EfficientMonetaryComposition a = new EfficientMonetaryComposition();

        System.out.println(a.getMonetaryCntLoop(2,20, new int []{2,3}));
//        System.out.println(a.getMonetaryCnt(15, new int []{2,3}, 0));

    }

    /**
     * 효율적인 화폐 구성
     * N가지 종류의 화페가 있다.
     * 이 화폐들의 개수를 최소한으로 이용해서 그 가치의 합이 M원이 되도록 하려고 한다.
     * 이때 각 종류의 화폐의 갯수는 제한이 없다.
     *
     * 예를 들어 2원, 3원 단위의 화폐가 있을 때는 15원을 만들기 위해 3원을 5개 사용하는 것이 효과적
     *
     * M원을 만들기 위한 최소한의 화폐 개수를 출력하는 프로그램을 만들어라.
     *
     * 첫째줄에 N, M이 주어진다
     *
     * 이후에 N개의 줄에는 각 화폐의 가치가 주어진다. 화폐의 가치는 10,000보다 작거나 같은 자연수이다.
     *
     * 첫째줄에 화패의 겟수를 출력한다. 불가능 할 때는 -1 을 출력
     *
     * 예시
     * 2 15
     * 2
     * 3
     *
     * 출력예시 5
     *
     * 예시 2
     * 3 4
     * 3
     * 5
     * 7
     * 출력 예시 -1
     */

    /**
     * 점화식
     *
     * ai = 금액 i를 만들 수 있는 최소한의 화폐 개수
     * k = 각 화페 단위
     *
     * 점화식 : 각 화폐 단위인 k를 하나씩 확인하며
     *  a i-k 를 만드는 방법이 존재하는 경우 , ai = min(ai, ai-k +1)
     *  a i-k 를 만드는 방법이 존재하지 않는 경우, ai = INF
     *
     */

    int getMonetaryCntloop2(int n, int money, int [] monetary){

        int [] memo = new int [money+1] ;

        Arrays.fill(memo, 10001);

        memo[0] = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = monetary[i] ; j <=money ; j++){
                if(memo[j - monetary[i]] !=10001){
                    memo[j] = Math.min(memo[j], memo[j - monetary[i]] +1);
                }
            }
        }
        if(memo[money] == 10001){
            return -1;
        }
        return memo[money];
    }
    int getMonetaryCntLoop(int n, int money, int []monetary){
        int result = 0;

        int [] memo = new int[money+1];

        Arrays.fill(memo, 10001);
        memo[0] = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = monetary[i]; j <=money ; j++){
                if(memo[j - monetary[i]] != 10001){
                    memo[j] = Math.min(memo[j], memo[j - monetary[i]] +1);
                }
            }
        }

        if(memo[money] == 10001)
            return -1;
        return memo[money];
    }

}
