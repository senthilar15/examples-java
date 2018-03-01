package com.example.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortingExamples {
	
	
	public static void main(String[] a){
		
		//System.out.println(Arrays.stream(bubbleSort(new int[] {8,7,655,6,55,213,4,1,5,0})).mapToObj(String::valueOf).collect(Collectors.joining(",")));
		
		int[] src= new int[] {8,7,655,6,55,213,4,1,5,0};
		int[] dest = src.clone();
		
		mergeSort(src, dest, 0, src.length-1,0);
		//System.out.println(Arrays.stream(dest).mapToObj(String::valueOf).collect(Collectors.joining(",")));
		System.out.println(dest);
		
		//System.out.println(Arrays.stream(mergeSort(new int[] {8,7,655,6,55,213,4,1,5,0})).mapToObj(String::valueOf).collect(Collectors.joining(",")));
		System.out.println(Arrays.stream(insertionSortv2(new int[] {7,6,8,4,1,5})).mapToObj(String::valueOf).collect(Collectors.joining(",")));
		
		System.out.println();
		
	}
	
	
	private static int[] bubbleSort(int[] array){
		
		if(array == null || array.length == 0){
			throw new RuntimeException("Array should not be empty or null");
		}
		
		for(int i = array.length -1 ; i >= 0 ; i--){
			
			for(int j = 0; j < i; j++){
				
				if(array[j] > array[i]){
					
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp; 
				}
				
			}
			
		}
		
		return array;
	
		
	}
	
	
	private static int[] selectionSort(int[] array){
		if(array == null || array.length == 0){
			throw new RuntimeException("Array should not be empty or null");
		}
		
		
		for(int i = 0 ; i <=array.length -1 ; i++){
			
			int min = i;//{6,8,4,1,5,7} 
			
			for(int j= i+1 ; j <= array.length -1; j++){
				
				if(array[j] < array[min]){
					
					min = j;
					//System.out.println(array[min]);
				}
				
			}
			
		    int temp = array[min];
		    array[min] = array[i];
		    array[i] = temp;
			//Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(","));
		}
		return array;
		
	}
	
	
	
	private static int[] selectionSort1(int[] array){
		if(array == null || array.length == 0){
			throw new RuntimeException("Array should not be empty or null");
		}
		
		
		for(int i = 0 ; i <=array.length -1 ; i++){
			
			int min = i;//{6,8,4,1,5,7} 
			int j= i+1 ;
			while(j <= array.length -1 ){
				if(array[j] < array[min]){
					min = j;
					
				}
				j++;	
				
			}
			
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
			
		}
		return array;
		
	}
	
	
	private static int[] insertionSort(int[] array){
		if(array == null || array.length == 0){
			throw new RuntimeException("Array should not be empty or null");
		}
		//{7,6,8,4,1,5}
		for(int i = 1 ; i<=array.length-1; i++){
			
			int min = array[i];	
			int j = i-1;
			while(j >= 0 && array[j] > min){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = min;
		}
		
		return array;
	}
	
	
	private static int[] insertionSort1(int[] array){
		if(array == null || array.length == 0){
			throw new RuntimeException("Array should not be empty or null");
		}
		//{7,6,8,4,1,5}
		for(int i = 1 ; i<=array.length-1; i++){
			
			int min = array[i];
			int  k = i;
			for(int j = i-1; j >=0 ; j-- ){
				if(array[j] > min){
					array[j+1] = array[j];
					k = j;
				}
				
			}
			
			array[k] = min;
		}
		
		return array;
	}
	
	
	private static int[] insertionSortv2(int arr[]){
		for (int i=0; i<arr.length; i++)
            for (int j=i; j>0 && (arr[j-1] > arr[j]);j--){
            	 swap(arr, j, j-1);
            }
               
        return arr;
	}
	
	
	
	   @SuppressWarnings({"unchecked", "rawtypes"})
	    private static void mergeSort(int[] src,
	                                  int[] dest,
	                                  int low,
	                                  int high,
	                                  int off) {
	        int length = high - low;

	        // Insertion sort on smallest arrays
	        if (length < 7) {
	            for (int i=low; i<high; i++)
	                for (int j=i; j>low &&
	                         ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--)
	                    swap(dest, j, j-1);
	            return;
	        }

	        // Recursively sort halves of dest into src
	        int destLow  = low;
	        int destHigh = high;
	        low  += off;
	        high += off;
	        int mid = (low + high) >>> 1;
	        mergeSort(dest, src, low, mid, -off);
	        mergeSort(dest, src, mid, high, -off);

	        // If list is already sorted, just copy from src to dest.  This is an
	        // optimization that results in faster sorts for nearly ordered lists.
	        if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
	            System.arraycopy(src, low, dest, destLow, length);
	            return;
	        }

	        // Merge sorted halves (now in src) into dest
	        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
	            if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0)
	                dest[i] = src[p++];
	            else
	                dest[i] = src[q++];
	        }
	    }
	   private static void swap(int[] x, int a, int b) {
	        int t = x[a];
	        x[a] = x[b];
	        x[b] = t;
	    }


}
