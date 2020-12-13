package com.bp.restart.youtube.dong.greedy;

public class MultiplyPlus {
    public static void main(String [] args){
        MultiplyPlus a = new MultiplyPlus();
        System.out.println(a.getValueNew("02984"));

        char c1 = 1;
//        System.out.printf("%d", c1);
        System.out.printf("%c", c1);
    }

    /**
     * 곱하기 혹은 더하기
     * 각 자리 숫자가 0 ~ 9 로만 이루어진 문자열 S가 주어졌을 때
     * 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하여 숫자 사이에 'X' 혹은 '+' 연산자를 넣어 결과적으로 만들어 질 수있는 가장 큰 수를 구하기
     *
     * 앞에서 부터 계산
     * 두 수가 0, 1 이 아니면 곱하기
     * 곱해야 수가 커지고 , 0 일때 곱하면 0 1일때 곱하면 자기자신이기 때문에
     *
    * */
    int getValue(String numStr){
        int result = 0;

        int i = 0;

        result = Integer.parseInt(numStr.substring(i,i+1));

        numStr = numStr.substring(i+1);
        i++;
        while(numStr.length() > 0) {

            int tmp = Integer.parseInt(numStr.substring(0, 1));
            numStr = numStr.substring(1);

            if((result > 1)
                    && (tmp > 1 ) ){
                result *= tmp;
            }else{
                result += tmp;
            }
        }

        return result;
    }


    long getValueNew(String numStr){
        long result = 0;

        /*문자 0 의 아스키 코드 값은 48
        * 숫자 1 의 아크시 코드 값은 1
        * 따라서 문자 1 - 문자 0 은 숫자 1 */
        result = numStr.charAt(0) -'0';

        for(int i = 1; i < numStr.length() ; i++){

            int tmp = numStr.charAt(i) -'0';

            if((result > 1)
                    && (tmp > 1 ) ){
                result *= tmp;
            }else{
                result += tmp;
            }
        }

        return result;
    }

 }
