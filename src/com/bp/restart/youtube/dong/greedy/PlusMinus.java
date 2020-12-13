package com.bp.restart.youtube.dong.greedy;

public class PlusMinus {

    public static void main(String[] args) {
        PlusMinus p = new PlusMinus();

        System.out.println(p.getCntNew(17, 4));
    }

    /**
     * 1 이 될 때까지
     *
     * 어떠한 수 n이 1이 될 때까지의 다음의 두 과정 중 하나를 반복적으로 선택하여 수행하려고 합니다.
     * 단, 두번째 연산은 n이 k로 나눠어 떨어질 때문 선택 할 수 있습니다.
     *
     * 1. n에서 1을 뺍니다.
     * 2. n에서 k로 나눕니다.
     *
     * 예를 들어 n이 17, k 가 4 일때
     *  1번을 한번 하면 n 은 16
     *  이후에 2를 2번하면 n은 1
     *
     *  정당성 ?
     *  1을 빼는 것 보다 k 로 나누는 것이 수를 빠르게 줄일 수 있다.
     *
     *  따라서 k가 2 이상이라면 k로 나누는 것이 1을 빼는것 보다 빠르다.
     */
    int getCnt(int n, int k){
        int result = 0;

        while(n!=1){

            if(n%k == 0){
                n /=k;
            }else{
                n -=1;
            }
            result ++;
        }

        return result;
    }

    int getCntNew(int n, int k){
        int result = 0;

        while(true){

            System.out.println("start n "+n);
            // n이 k로 나누어 떨어지는 수가 될 때까지 빼기
            int target = (n/k)*k;
            System.out.println("target "+target);
            result += (n - target);
            System.out.println("result "+result);
            n = target;
            // n이 k 보다 닥을때 (더 이상 나눌 수 없을 때) 반복문 탈출
            System.out.println("n  "+n);
            if(n < k)
                break;

            result++;
            n/=k;
        }
        // 마지막으로 남은 수에 대하여 1 씩 빼기
        result +=(n-1);

        return result;
    }


}
