package com.bp.restart.search;

public class HashSearch {

    private int [] BUCKTES = null;
    private int SIZE = 0;

    public HashSearch(int size){
        this.BUCKTES = new int[size];
        this.SIZE = size;
    }


    /***
     * 해시 탐색법으로 저장
     * @param num
     * @return
     */
    public boolean set(int num){

        int idx = getEmptySpace(num);
        if(idx < 0 ){
            return false;
        }

        this.BUCKTES[idx] = num;

        return true;
    }

    /***
     * 빈 공간 찾기
     * @param num
     * @return
     */
    private int getEmptySpace(int num){

        int idx = hash(num);
        int i = 0;
        while(this.BUCKTES[idx] !=0){

            idx ++;
            i++;
            if(idx == this.SIZE){
                idx = 0;
            }

            if(i == this.SIZE){
                return -1;
            }
        }

        return idx;

    }

    /**
     * 해시 구하기
     * @param num
     * @return
     */
    private int hash(int num){
        return num % this.SIZE;
    }

    public int get(int num){
        int idx = hash(num);

        if(this.BUCKTES[idx] == num){
            return idx;
        }else{
            return getIdx(idx,num);
        }
    }

    /**
     * 인덱스 구하기
     * @param idx
     * @param num
     * @return
     */
    private int getIdx(int idx, int num){

        idx++;
        int i = 0;
        while(this.BUCKTES[idx] != num){

            idx ++;
            i++;
            if(idx == this.SIZE){
                idx = 0;
            }

            if(i == this.SIZE){
                return -1;
            }
        }

        return idx;
    }


    public static void main(String[] args) {
        int [] array = {1,21,3,23,5};
        HashSearch search = new HashSearch(array.length);
        for(int i = 0 ; i < array.length ; i ++) {
            System.out.println(search.set(array[i]));
        }

        System.out.println("=================");
        for(int i = 0 ; i < array.length ; i ++) {
            System.out.println(search.get(array[i]));
        }
    }
}
