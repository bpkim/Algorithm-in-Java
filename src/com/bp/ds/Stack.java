package com.bp.ds;

public abstract class Stack {
	
	private int stack[] ;
	private int idx;
	private int MAX_SIZE;
	
	Stack(){
		idx = -1;
		MAX_SIZE = 100;
		stack = new int[MAX_SIZE];
	}
	
	void push(int a){
		
		if(idx==MAX_SIZE){
			System.out.println("Stack is Full");
			return;
		}
		
		stack[++idx] = a;
	}
	
	int pop()
	{
		if(idx ==-1){
			System.out.println("Stack is Empty");
		}
		return stack[idx--];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
