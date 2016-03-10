package com.bp.ds;

public class Queue {
	
	private int queue[];
	private int rear; 
	private int front ; 
	private final static int MAX_SIZE =100;

	Queue(){
		rear = -1;
		front = -1;
		queue = new int[MAX_SIZE];
	}
	
	void push(int a){
		
		if(rear == MAX_SIZE){
			System.out.println("Queue is Full");
			return;
		}
		
		queue[++rear] = a;
		
	}
	int pop(){
		if(front ==rear){
			System.out.println("Queue is Empty");
			return -10;
		}
		
		return queue[++front];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue q = new Queue();
		
		
		for(int i = 0 ; i < 10 ; i ++){
		q.push(i);	
		}
		for(int i = 0 ; i < 11 ; i ++){
			System.out.print(q.pop()+" ");	
		}
	}

}
