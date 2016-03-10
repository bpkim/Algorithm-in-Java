package com.bp.ds;

public class BFSDFSGraph {
	class Stack{
		final static int MAX_SIZE = 100;
		int top ;
		int stack [];
		Stack(){
			top =-1;
			stack = new int[MAX_SIZE];
		}
		
		void push(int a){
			if(top==MAX_SIZE){
				System.out.println("FULL");
				return;
			}
				
			stack[++top] = a;
		}
		int pop(){
			
			return stack[top--];
		}
		boolean isEmpty(){
			if(top== -1)
				return true;
			else
				return false;
				
		}
	}
	
	class Queue{
		final static int MAX_SIZE = 100;
		int rear;
		int front;
		int queue[];
		
		Queue(){
			rear  = -1;
			front = -1;
			queue= new int [MAX_SIZE];
		}
		void push(int a){
			if(rear==MAX_SIZE){
				System.out.println("FULL");
				return;
			}
				
			queue[++rear] = a;
		}
		int pop(){
			if(rear == front){
				System.out.println("Empty");
				return -10;
			}
			return queue[++front];
		}
		boolean isEmpty(){
			if(rear==front)
				return true;
			else
				return false;
					
		}
	}
	
	void BFS(int route[][]){
		
		int check[] = new int[route.length];
		int idx=0;
		Queue q = new Queue();
		
		q.push(idx);
		// ³Ö°í 
		while(!q.isEmpty()){
			//System.out.println("1");
			idx = q.pop();
			
			if(check[idx]>0)
				continue;
			else
				check[idx]=1;
			
			System.out.print(idx + " ");
			
			for(int j = 0 ; j < route.length; j ++){
				if((route[idx][j]>0)&&(check[j]<1))
					q.push(j);
			}
			
		}
		
	}
	
	void DFS(int route[][]){
		
		int check[] = new int [route.length];
		int idx=0;
		
		Stack s = new Stack();
		
		s.push(idx);
		
		while(!s.isEmpty()){
			idx = s.pop();
			
			if(check[idx]>0)
				continue;
			else
				check[idx]=1;
			
			System.out.print(idx +" ");
			
			for(int j = 0 ; j < route.length ; j++){
				if((route[idx][j]>0)&&(check[j]<1))
					s.push(j);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] route = { { 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, };

		BFSDFSGraph sdg = new BFSDFSGraph();
		//sdg.BFS(route);
		sdg.DFS(route);
	}

}
