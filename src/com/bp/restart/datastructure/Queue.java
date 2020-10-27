package com.bp.restart.datastructure;

public class Queue {
    int [] QUEUE = null;
    int FRONT;
    int REAR;
    int MAX_SIZE;

    public Queue(int size){
        QUEUE = new int[size];
        FRONT = -1;
        REAR = -1;
        MAX_SIZE = size;

    }

    /**
     * enqueue
     *
     * @param value
     * @return
     */
    int enqueue(int value){
        if(isFull()){
            return -1;
        }


        QUEUE[++REAR] = value;
        return 0;
    }

    /**
     * deqeueue
     *
     * @return
     */
    int dequeue(){
        if(isEmpty()){
            return -1;
        }

        return QUEUE[++FRONT];
    }

    /**
     * isEmpty
     *
     * @return
     */
    boolean isEmpty(){
        if(FRONT == REAR){
            return true;
        }
        return false;
    }

    /**
     * isFull
     * @return
     */
    boolean isFull(){
        if(REAR == MAX_SIZE-1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Queue queue = new Queue(10);

        for(int i = 12 ; i >0 ; i--){
            if(!queue.isFull())
                queue.enqueue(i);
            else
                System.out.println("Queue is Full !!");
        }



        System.out.println("-- Queue Confirm --");

        for(int i = 0 ; i < queue.MAX_SIZE ; i++){
            System.out.println(queue.QUEUE[i]);
        }

        System.out.println("-- Queue Confirm End  --");


        for(int i = 12 ; i >0 ; i--){
            if(!queue.isEmpty())
                System.out.println(queue.dequeue());
            else
                System.out.println("Queue is Empty !!");
        }
    }

}
