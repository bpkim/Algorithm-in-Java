package com.bp.restart.youtube.dong.etc;

public class Eratos {

    public static void main(String [] args){

        Eratos a = new Eratos();

        a.isPrimeNumber(10);
    }

    void isPrimeNumber(int n){

        int [] chea = new int[n+1];


        for(int i = 2 ; i <= n ; i++){
            if(chea[i]==0){
                int j = 2;
                while(( j * i ) <= n){
                    chea[j*i] =1 ;
                    j++;
                }
            }
        }

        for(int i = 1 ; i <= n ; i++){

            if(chea[i] == 0) {
                System.out.println(i + " : 0 ");
            }else{
                System.out.println(i + " : 1 ");
            }
        }
    }
}
