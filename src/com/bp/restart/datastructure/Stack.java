package com.bp.restart.datastructure;

public class Stack {
     int [] STACK = null;
     int IDX;
     int MAX_SIZE;

    public Stack(){

        STACK = new int[10];
        IDX = -1;
        MAX_SIZE = 10;
    }

    /**
     * push
     *
     * @param value
     * @return 성공 : 0 / 실패 : -1
     */
    int push(int value){
        if(isFull()){
            return -1 ;
        }

        IDX++;
        STACK[IDX] = value;
        return 0;
    }

    /**
     * pop
     *
     * @return 성공 : value / 실패 : -1
     */
    int pop(){
        if(isEmpty()){
            return -1 ;
        }

        return STACK[IDX--];

    }

    /**
     *  isEmpty
     *
     * @return isEmpty : true / not isEmpty : false
     */
    boolean isEmpty(){
        if(IDX == -1){
            return true;
        }
        return false;
    }

    /**
     *  full
     *
     * @return full : true / not full : false
     */
    boolean isFull(){

        if(IDX == MAX_SIZE-1){
            return true ;
        }

        return false;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        for(int i = 12 ; i >0 ; i--){
            if(!stack.isFull())
                stack.push(i);
            else
                System.out.println("Stack is Full !!");
        }



        System.out.println("-- Stack Confirm --");

        for(int i = 0 ; i < stack.MAX_SIZE ; i++){
            System.out.println(stack.STACK[i]);
        }

        System.out.println("-- Stack Confirm End  --");


        for(int i = 12 ; i >0 ; i--){
            if(!stack.isEmpty())
                System.out.println(stack.pop());
            else
                System.out.println("Stack is Empty !!");
        }
    }

}
