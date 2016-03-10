package com.bp.ds;

public class Heap {

	final static int MAX_SIZE = 100;
	static int heap[] ;
	static int idx;
	
	Heap(){
		idx =-1;
		heap = new int [MAX_SIZE];
	}
	void swap(int i, int j){
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j]=temp;
		
	}
	int getParents(int idx){
		if(idx%2!=0)
			return idx/2;
		else
			return (idx/2)-1;
			
	}
	int getLeftChild(int idx){
		return (idx*2)+1;
	}
	int getRightChild(int idx){
		return (idx*2)+2;
	}
	void insertHeap(int a){
		
		if(idx == MAX_SIZE)
			return;
		
		heap[++idx]= a;
		
		int i = idx;
		
		while((i!=0)&&(heap[getParents(i)]<heap[i])){
			
			swap(getParents(i),i);
			i = getParents(i);
			
		}
	}
	
	int popHeap(){
		
		int result = heap[0];
		
		heap[0]=heap[idx];
		heap[idx--]=0;
		
		int i = 0;
		int lIdx, rIdx, cIdx;
		
		while(true){
			lIdx = getLeftChild(i);
			rIdx = getRightChild(i);
			
			cIdx = (heap[lIdx] < heap[rIdx]) ? rIdx:lIdx;
			
			if(heap[i]<heap[cIdx]){
				swap(i,cIdx);
				i = cIdx;
			}else
				break;
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1, 2, 10, 12, 7, 6, 3, 11, 8, 4};
		Heap h = new Heap();
		
		for(int i = 0 ; i < 10 ; i ++){
			h.insertHeap(input[i]);
		}
		for(int i = 0 ; i < input.length ; i ++){
			System.out.println(h.popHeap());
		}
		
	}

}
