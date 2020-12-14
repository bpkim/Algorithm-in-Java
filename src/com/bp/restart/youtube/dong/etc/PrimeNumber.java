package com.bp.restart.youtube.dong.etc;

public class PrimeNumber {

    public static void main(String [] args){
        PrimeNumber a = new PrimeNumber();

        System.out.println(a.isPrimeNumber(10));
        System.out.println(a.isPrimeNumber(7));
        System.out.println(a.isPrimeNumber(11));
    }

    boolean isPrimeNumber(int n){

        for(int i = 2 ; i < Math.sqrt(n) ; i++){
            if(n%i == 0){
                return false;
            }
        }

        return true;
    }
}
