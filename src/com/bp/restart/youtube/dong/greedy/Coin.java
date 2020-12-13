package com.bp.restart.youtube.dong.greedy;

public class Coin {

    public static void main(String[] args) {
        Coin coin = new Coin();

        System.out.println(coin.getCoinCnt(1260));
    }

    /**
     * 거스름돈으로 사용해야할 동전이 500, 100, 50
     * 갯수는 무한
     * 손님에게 거슬러줘야 하는 돈이 n 원일때
     * 거슬러 주어야할 동전의 최소 개수는?
     *
     * 단, n은 10의 배수
     *
     *
     * 가장 큰 화페 단위부터 돈을 거슬러 주면 된다.
     *
     * 그리드
     * 정당성 석
     *
     * 최적의 해를 보장해 주는 이유는 ?
     *   가장 큰 단위가 항상 작은 단위의 배수이므로 작은 단위의 동전들을 종합해 다른 해가 나올 수 없기 때문에 정당하다.
     *
     *   그리디 알고리즘은 최소한의 아이디어를 떠올리고 이것이 정당한지 검토할 수 있어야 한다.
     */

    private int getCoinCnt(int n) {
        int arr [] = {500, 100, 50};
        int cnt = 0 ;

        for(int tmp : arr){

            cnt += n/tmp;
            n %= tmp;
        }


        return cnt;
    }
}
