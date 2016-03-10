package com.bp.ds;

public class BFSDFSTree {
	
	class Queue{
		
		final static int MAX_SIZE = 100;
		int queue[];
		int rear;
		int front;
		
		Queue(){
			rear = -1; 
			front= -1;
			queue = new int [MAX_SIZE];
		}
		
		void push(int a)
		{
			if(rear == MAX_SIZE){
				System.out.println("Full");
				return ;
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
	
	class Stack{
		final static int MAX_SIZE = 100;
		int idx;
		int stack[];
		Stack(){
			idx=-1;
			stack = new int [MAX_SIZE]; 
		}
		
		void push(int a){
			if(idx==MAX_SIZE){
				System.out.println("FULL");
				return;
			}
			stack[++idx] = a;
		}
		
		int pop(){
			if(idx==-1){
				System.out.println("Empty");
				return -10;
			}
			return stack[idx--];
		}
		boolean isEmpty(){
			if(idx==-1)
				return true;
			else
				return false;
		}
	}
	int findParentIdx(int i){
		if(i%2==1)
			return i/2;
		else
			return i/2-1;
	}
	int findLeftChildIdx(int i){
		return i*2+1;
	}
	int findRightChildIdx(int i){
		return i*2+2;
	}
	void BFS(int tree[]){
		
		int idx;
		Queue q = new Queue();
		//q에 넣고
		// pop
		q.push(tree[0]);
		while(!q.isEmpty())
		{
			System.out.println((idx = q.pop())+" ");
			
			// 자식 있는지 확인하고 
			
			// 있으면 넣고
			if(tree[findLeftChildIdx(idx)]>0)
				q.push(tree[findLeftChildIdx(idx)]);

			if(tree[findRightChildIdx(idx)]>0)
				q.push(tree[findRightChildIdx(idx)]);
		}
		
	}
	void DFS(int tree[]){
		int idx;
		Stack s = new Stack();
		
		s.push(tree[0]);
		
		while(!s.isEmpty()){
			
			System.out.println((idx = s.pop())+" ");
			
			if(tree[findLeftChildIdx(idx)]>0)
				s.push(tree[findLeftChildIdx(idx)]);
			if(tree[findRightChildIdx(idx)]>0)
				s.push(tree[findRightChildIdx(idx)]);
			
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
		
		BFSDFSTree bdtree = new BFSDFSTree();
		int []tree = {0, 1, 2, 3, 4, -1, 6, -1, -1, -1, -1, -1, -1, -1, -1};
		//bdtree.BFS(tree);
		bdtree.DFS(tree);
	}

}
