 package com.bp.algorithms;

import java.security.AllPermission;

public class Sort {
	
	public int [] swap(int arr[] , int to, int from){
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to]= temp ; 
				
		return arr;
	}

	/**
	 * Quick Sort
	 * 기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
	 * 가장 많이 사용되는 일고리즘
	 * 시간복잡도 nlogn2n 가장 빠르다.
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public int [] QuickSort(int arr[], int left, int right){
		if(left == right) return arr ;
		
		int pivot = arr[left];
		int h_left = left;
		int h_right = right;
		
		while(left<right){
			while((arr[right]>= pivot)&&(left < right))
				right --;
			
			if(left!=right){
				arr[left] = arr[right];
				left++;
			}
			while((arr[left]<= pivot)&&(left<right))
				left++;
			
			if(left!=right){
				arr[right]=arr[left];
				right--;
			}
		}// while ����
		
		arr[left] = pivot;
		pivot = left;
		
		if(h_left<pivot)
			QuickSort(arr, h_left, pivot-1);
		if(pivot<h_right)
			QuickSort(arr, pivot+1, h_right);
				
		return arr;
	}
	/**
	 * Bubble Sort
	 * 시간복잡도 n^2
	 * @param arr
	 * @return
	 */
	public int[] BubbleSort(int arr[]){
		
		for(int i = 0 ; i < arr.length -1 ; i ++){
			for( int j= 0 ; j < arr.length -i-1 ; j++){
				if(arr[j]>arr[j+1]){
					arr= swap(arr, j, j+1);
				}
			}
		}
		return arr;
	}
	/**
	 * SelectSort
	 * 시간복잡도 n
	 * @param arr
	 * @return
	 */
	public int[] SelectSort(int arr[]){
		
		int minIdx;
		for( int i = 0 ; i< arr.length -1 ; i++)
		{
			minIdx = i;
			
			for( int j = i ; j < arr.length ; j++)
			{
				if(arr[j]<arr[minIdx])
					minIdx = j;
			}
			
			arr = swap(arr, i, minIdx);
		}
		return arr;
	}
	/**
	 * InsertSort
	 * 시간복잡도 n^2
	 * 일정 범위안에서 계속 정렬하는거
	 * 예를 들어 첫번재인덱스가 1 이니까 0 ~ 1 안에서 정렬
	 * 그다음은 0 ~2 이렇게 점차 범위를 넓혀가면서  새롭게 선택 된 곳의 위치를 삽입해가면서
	 * 정렬한다.
	 *
	 * 거의 정렬되어 있는 상태라면 매우 빠르다.
	 * 최선의 경우 O(n)의 시간 복잡도를 가집니다.
	 * @param arr
	 * @return
	 */
	public int [] InsertSort(int arr[]){
		int temp ;
		int j ;
		
		for( int i = 1 ; i < arr.length; i++){
			temp = arr[i];
			j = i-1;
			while((j>=0)&&(arr[j]>temp)){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
			
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {5, 3, 7, 9, 8, 3, 4};
		Sort sort = new Sort();
		//sort.QuickSort(arr, 0, arr.length-1);
		//sort.BubbleSort(arr);
		sort.SelectSort(arr);
		
		for(int i = 0 ; i < arr.length ;i ++){
			System.out.print(arr[i]+" ");
		}
	}

}
