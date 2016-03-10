package com.bp.algorithms;


public class Dijkstra {

	class Heap {

		final static int MAX_SIZE = 100;
		int heap[];
		int idx;

		Heap() {
			idx = -1;
			heap = new int[MAX_SIZE];
		}

		int getParent(int i) {
			if (i % 2 != 0)
				return i / 2;
			else
				return (i / 2) - 1;
		}

		int getLeftChild(int i) {
			return (i * 2) + 1;
		}

		int getRightChild(int i) {
			return (i * 2) + 2;
		}

		void swap(int a, int b) {
			int temp = heap[a];
			heap[a] = heap[b];
			heap[b] = temp;

		}

		void insert(int a) {
			heap[++idx] = a;
			int i = idx;

			while ((i != 0) && (heap[getParent(i)] < heap[i])) {
				swap(getParent(i), i);
				i = getParent(i);
			}
		}

		int pop() {

			int result = heap[0];
			heap[0] = heap[idx];
			heap[idx--] = 0;
			int i = idx;

			int cIdx, lIdx, rIdx;
			while (true) {

				lIdx = getLeftChild(i);
				rIdx = getRightChild(i);

				cIdx = (lIdx < rIdx) ? rIdx : lIdx;
				
				if(heap[cIdx]<1)
					break;
				
				if (heap[i] < heap[cIdx]) {
					swap(i, cIdx);
					i = cIdx;
				} else
					break;
			}
			return result;
		}

		boolean isHeapEmpty() {
			if(idx==-1)
				return true;
			else
				return false;
		}
	}

	void goDijkstra(int [][] route, int l){
		
		int [] check = new int[l];
		Heap h = new Heap();
		
		int now = 0;
		h.insert(now);
		System.out.println(h.isHeapEmpty());
		while(!h.isHeapEmpty()){
			now = h.pop();
			int length = now/1000;
			int i = (now%1000)/10;
			int from = (now%1000)%10;
			
			if(check[i]>0)
				continue;
			
			check[i]=1;
			
			System.out.println(from+"에서 "+i+"까지 "+length+"");
			
				
				for(int j = 0 ; j < l ; j ++){
					if((route[i][j]>0)&&(check[j]<1))
						h.insert((length+route[i][j])*1000+j*10+i);
				}
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] route
		 = { { 0, 1, 2, 0, 7, 0, 0, 0 },//0
		 { 1, 0, 0, 2, 0, 0, 4, 0 }, //1
		 { 2, 0, 0, 0, 0, 5, 0, 0 }, //2
		 { 0, 2, 0, 0, 0, 0, 1, 0 }, //3
		 { 7, 0, 0, 0, 0, 3, 2, 0 }, //4
		 { 0, 0, 5, 0, 3, 0, 0, 2 }, //5
		 { 0, 4, 0, 1, 2, 0, 0, 6 }, //6
		 { 0, 0, 0, 0, 0, 2, 6, 0 } }; //7

		Dijkstra d = new Dijkstra();

		d.goDijkstra(route, 8);
	}

}
