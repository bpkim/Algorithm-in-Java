package com.bp.restart.youtube.dong.dynamicprograming;

public class MakeOne {


    int n;
    int[] MAKE_ONE_MEMO = new int[30001];

    public static void main(String[] args) {

        MakeOne a = new MakeOne();

//        a.MAKE_ONE_MEMO[1] = 1;
//        a.MAKE_ONE_MEMO[2] = 1;
//        a.MAKE_ONE_MEMO[3] = 1;
//        a.MAKE_ONE_MEMO[5] = 1;
        a.n = 26;
        System.out.println(a.getCntMakeOne(26, 0));
        System.out.println(a.getCntMakeOneLoop(26));


    }

    /**
     * 정수 X가 주어졌을때, 정수 X에 사용할 수 있는 연산은 다음과 같이 4가지 입니다.
     * 1. X가 5로 나누어 떨어지면, 5로 나눕니다.
     * 2. X가 3으로 나누어 떨어지면, 3으로 나눕니다.
     * 3. X가 2로 나누어 떨어지면, 2로 나눕니다.
     * 4. X에서 1을 뺍니다.
     * <p>
     * <p>
     * 정수 x가 주어졌을 때, 연산 4개를 적절히 사용해서 값을 1로 만들고자 합니다. 연산을 사용하는 횟수의 최솟값을 출력하세요.
     * 예를 들어 정수가 26이면 다음과 같이 계산해서 3번이 최솟값입니다.
     * <p>
     * 26 > 25 > 5 > 1
     */
    int getCntMakeOne(int n, int cnt) {

        if (n == 1) {
            return cnt;
        }

        int min = Integer.MAX_VALUE;
        if (n % 5 == 0) {
            int tmp = getCntMakeOne(n / 5, cnt + 1);
            if (tmp < min) {
                min = tmp;
            }
        }
        if (n % 3 == 0) {
            int tmp = getCntMakeOne(n / 3, cnt + 1);
            if (tmp < min) {
                min = tmp;
            }
        }
        if (n % 2 == 0) {

            int tmp = getCntMakeOne(n / 2, cnt + 1);
            if (tmp < min) {
                min = tmp;
            }
        }
        int tmp = getCntMakeOne(n - 1, cnt + 1);
        if (tmp < min) {
            min = tmp;
        }

        if (MAKE_ONE_MEMO[n] > min) {
//            System.out.println(cnt + " dd "+n +" / " +MAKE_ONE_MEMO[n]);
            MAKE_ONE_MEMO[n] = min;
        }

        return min;
//        return MAKE_ONE_MEMO[n];
    }

    /**
     * 점화식
     *  ai = min(a i-1, a i/2, a i/3, a i/5) +1;
     *
     */
    int getCntMakeOneLoop(int n) {

        for (int i = 2; i < n + 1; i++) {

            //  1 뺏을때
            MAKE_ONE_MEMO[i] = MAKE_ONE_MEMO[i - 1] + 1;

            // 5로 나눴을때
            if (i % 5 == 0) {
                int tmp = MAKE_ONE_MEMO[i / 5] + 1;
                if (tmp < MAKE_ONE_MEMO[i]) {
                    MAKE_ONE_MEMO[i] = tmp;
                }
            }

            // 3으로 나눴을때
            if (n % 3 == 0) {
                int tmp = MAKE_ONE_MEMO[i / 3] + 1;
                if (tmp < MAKE_ONE_MEMO[i]) {
                    MAKE_ONE_MEMO[i] = tmp;
                }
            }

            // 2로 나눴을때
            if (n % 2 == 0) {

                int tmp = MAKE_ONE_MEMO[i / 2] + 1;
                if (tmp < MAKE_ONE_MEMO[i]) {
                    MAKE_ONE_MEMO[i] = tmp;
                }
            }

        }
        return MAKE_ONE_MEMO[n];
    }
}