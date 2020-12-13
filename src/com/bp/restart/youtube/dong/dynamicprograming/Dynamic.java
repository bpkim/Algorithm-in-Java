package com.bp.restart.youtube.dong.dynamicprograming;

public class Dynamic {
    /**
     * 다이나믹 프로그래밍은 문제가 다음의 조건을 만족할 때 사용할 수 있습니다.
     * 1. 최적 부분 구조(Optimal Substructure)
     *   큰 문제를 작은 문제로 나눌 수 있으며 작은 문제의 답을 모아서 큰 문제를 해결할 수 있습니다.
     *
     * 2. 중복되는 부분 문제(Overlapping Subproblem)
     *   동일한 작은 문제를 반복적으로 해결해야 합니다.
     *
     *
     * TopDown vs BottomUp
     * 이모제이션은 TopDown 하양식 방법이고
     * BottomUp 방식은 상향식 방식이다.
     *
     * 다이나믹 프로그래밍의 전형적인 형태는 BottomUp 방식입니다.
     *   결과 저장용 리스트는 DP 테이블이라고 부릅니다.
     *
     * 엄밀히 말하면 메모이제이션은 이전에 계산된 결과는 일시적으로 기록해 놓는 넓은 개념을 의미
     *   따라서 메모이제이션은 다이나믹 프로그래밍에 국한된 개념은 아닙니다.
     *   한 번 계산된 결과를 담아 놓기만 하고 다이나믹 프로그래밍을 위해 활용하지 않을 수도 있습니다.
     *
     *
     * 다이나믹 프로그래밍 vs 분할 정복
     *  다이나믹 프로그래밍과 분할 정복은 모두 "최적 부분 구조"를 가질 때 사용할 수 있습니다.
     *    큰 문제를 작은 문제로 나눌 수 있으며 작은 문제의 답을 모아서 큰 문제를 해결할 수 있는 상황
     *  다이나믹 프로그래밍과 분할 정복의 차이점은 "부분 문제의 중복"입니다.
     *    다이나믹 프로그래밍 문제에서는 각 부분 문제들이 서로 영향을 미치며 부분 문제가 중복됩니다.
     *    분할 정복 문제에서는 동일한 부분 문제가 반복적으로 계산되지 않습니다.
     *
     * 다이나믹 프로그래밍 문제에 접근 하는 방법
     *  주어진 문제가 다이나믹 프로그래밍 유형임을 파악하는 것이 중요
     *
     *  1. 가장 먼제 그리디, 구현, 완전 탐색 등의 아이디어로 문제를 해결 할 수 있는지 검토
     *    다른 알고리즘으로 풀이 방법이 떠오르지 않는 다면 다이나믹 프로그래밍 고려
     *  2. 일단 재귀 함수로 비효율 적인 완전 탐색 프로그래밍을 작성한 뒤에 TopDown 작은 문제에서 구한 답이 큰 문제에서 그대로 사용 될 수 있으면
     *     메모이제이션을 적용하는 등의 방식으로 코드를 개선하는 방법을 사용
     *  3. 일반적인 코딩 테스트 수준에서는 기본 유형의 다이나믹 프로그래밍 문제가 출제 되는 경우가 많다.
     */

    public static void main(String []  args){
        Dynamic a = new Dynamic();
        System.out.println(a.fibo(3));
        System.out.println(a.fiboDP(3));
    }
    /**
     * 피보나치 수열
     * 점화식 an = an-1 + an-2 , a1 = 1, a2 =1
     *
     * 빅오 O(2^n)
     * @param a
     * @return
     */
    int fibo(int a){
        if(a==1 || a==2){
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
    int [] FIBO_MEMO = new int[999];


    /**
     * 피보나치 수열
     * 메모이제이션(Memoization)
     *
     * @param a
     * @return
     */
    int fiboDP(int a){
        if(a==1 || a==2){
            return 1;
        }
        if(FIBO_MEMO[a] > 0 ){
            return FIBO_MEMO[a];
        }
        FIBO_MEMO[a] = fibo(a-1) + fibo(a-2);

        return FIBO_MEMO[a];

    }

}