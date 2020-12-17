package com.bp.restart.youtube.dong.etc;

import java.util.Arrays;

public class GenomicRangeQuery {

    public static void main(String [] args){
        GenomicRangeQuery a = new GenomicRangeQuery();

        long start = System.currentTimeMillis();
        int [] result = a.solution("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6});
        long mid = System.currentTimeMillis();
        int [] result2 = a.solution2("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6});
        long end = System.currentTimeMillis();

        System.out.println( mid - start);
        System.out.println(end - mid);
        System.out.println("----");
        for(int tmp : result){
            System.out.println(tmp);
        }
        System.out.println("===");
        for(int tmp : result2){
            System.out.println(tmp);
        }

//        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
//        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    }
/**
 A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence.
 Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
 You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

 The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
 There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
 The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

 For example, consider string S = CAGCCTA and arrays P, Q such that:

 P[0] = 2    Q[0] = 4
 P[1] = 5    Q[1] = 5
 P[2] = 0    Q[2] = 6
 The answers to these M = 3 queries are as follows:

 The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 Write a function:

 class MinAbsSum { public int[] solution(String S, int[] P, int[] Q); }

 that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

 Result array should be returned as an array of integers.

 For example, given the string S = CAGCCTA and arrays P, Q such that:

 P[0] = 2    Q[0] = 4
 P[1] = 5    Q[1] = 5
 P[2] = 0    Q[2] = 6
 the function should return the values [2, 4, 1], as explained above.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [1..100,000];
 M is an integer within the range [1..50,000];
 each element of arrays P, Q is an integer within the range [0..N − 1];
 P[K] ≤ Q[K], where 0 ≤ K < M;
 string S consists only of upper-case English letters A, C, G, T.


 CAGCCTA
 2132241

  */


    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8

        int [] result = new int[P.length];


//        int i = 0 ;

        char [] chArr = S.toCharArray();

        for(int i = 0 ; i < P.length ; i++ ){

            int min = 5;

            for(int j = P[i] ; j <= Q[i] ; j++) {
                if(chArr[j] =='A'){
                    if(min > 1){
                        min = 1;
                        break;
                    }
                }else if(chArr[j] =='C'){
                    if(min > 2){
                        min = 2;
                    }
                }else if(chArr[j] =='G'){
                    if(min > 3){
                        min = 3;
                    }
                }else if(chArr[j] =='T'){
                    if(min > 4){
                        min = 4;
                    }
                }else{
                }
//                System.out.println("i "+ i +" P i"+P[i] +" Q "+Q[i]);
            }
//            System.out.println("i "+ i +" P i"+P[i] +" Q "+Q[i]);

            result[i] = min;
        }

        return result;
    }



    public int[] solution2(String S, int[] P, int[] Q) {
        // write your code in Java SE 8

        int [] result = new int[P.length];

        for(int i = 0 ; i < P.length ; i++ ){

            int start = P[i];
            int end = Q[i];

//            System.out.println("+ "+S.substring(start, end+1));
            char [] chArr = S.substring(start, end+1).toCharArray();

            Arrays.sort(chArr);

            if(chArr[0] =='A'){
                result[i] = 1;
            }else if(chArr[0] =='C'){
                result[i] = 2;
            }else if(chArr[0] =='G'){
                result[i] = 3;
            }else if(chArr[0] =='T'){
                result[i] = 4;
            }

        }

        return result;
    }
}
