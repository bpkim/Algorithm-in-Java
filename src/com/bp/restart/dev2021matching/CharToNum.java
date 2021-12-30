package com.bp.restart.dev2021matching;

import java.util.HashMap;
import java.util.Map;

/*
숫자 문자열과 영단어
문제 설명
img1.png

네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

숫자	영단어
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine
제한사항
1 ≤ s의 길이 ≤ 50
s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
입출력 예
s	result
"one4seveneight"	1478
"23four5six7"	234567
"2three45sixseven"	234567
"123"	123
입출력 예 설명
입출력 예 #1

문제 예시와 같습니다.
입출력 예 #2

문제 예시와 같습니다.
입출력 예 #3

"three"는 3, "six"는 6, "seven"은 7에 대응되기 때문에 정답은 입출력 예 #2와 같은 234567이 됩니다.
입출력 예 #2와 #3과 같이 같은 정답을 가리키는 문자열이 여러 가지가 나올 수 있습니다.
입출력 예 #4

s에는 영단어로 바뀐 부분이 없습니다.
제한시간 안내
정확성 테스트 : 10초
 */
public class CharToNum {
    String [] charList = {
            "zero"
            ,"one"
            ,"two"
            ,"three"
            ,"four"
            ,"five"
            ,"six"
            ,"seven"
            ,"eight"
            ,"nine"
    };

    String regex = "[+-]?\\d*(\\.\\d+)?";

    public int solution(String s) {

        if(s.matches(regex)){
            return Integer.parseInt(s);
        }
        Map<String, String> map = new HashMap<>();

        for(int i = 0 ; i < charList.length ; i++){
            String numChar = charList[i];
            map.put(numChar, String.valueOf(i));
        }

        String strAnswer = "";
        int j;
        for(int i = 0 ; i < s.length() ; i+=j){
            String strTmp;
            j = 1;
            while(true){
                if(i+j >= s.length()){
                    // 숫자이면 더하기
                    strTmp = s.substring(i);
                }else{
                    // 숫자이면 더하기
                    strTmp = s.substring(i, i+j);

                }
                if(strTmp.matches(regex)){
                    strAnswer += strTmp;
                    break;
                // 숫자 아니면
                }else{
                    if(map.containsKey(strTmp)){
                        strAnswer += map.get(strTmp);
                        break;
                    }
                    j++;
                }
            }


            if(i+j >= s.length()){
                break;
            }

        }

        return Integer.parseInt(strAnswer);
    }


    public int solution2(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder("");
        int len = s.length();
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        String[] alphabets = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0; i<10; i++){
            s = s.replaceAll(alphabets[i],digits[i]);
        }

        return Integer.parseInt(s);
    }


    public static void main(String[] args) {
        CharToNum Compression = new CharToNum();
//        System.out.println(Compression.solution("one4seveneight"));
//        System.out.println(Compression.solution("23four5six7"));
        System.out.println(Compression.solution("2three45sixseven"));
//        System.out.println(Compression.solution("123"));
    }
}
