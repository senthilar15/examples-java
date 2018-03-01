package com.example.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class Mergesort {
	
	
	public static void main(String[] a){
		new Mergesort().sort(new int[] {27,38,39,3,9,82,10});
	}
	
	private int[] numbers;
    private int[] helper;

    private int number;

    public void sort(int[] values) {
        this.numbers = values;
        number = values.length;
        this.helper = new int[number];
        mergesort(0, number - 1);  
        System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    private void mergesort(int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
    	int middle = (low+high) / 2;
    	System.out.print(low+ ","+middle+","+high);
    	System.out.println();
    	if (low < high) {
            // Get the index of the element which is in the middle
            
           
            for(int i=low;i<high;i++){
            	System.out.print(numbers[i]);
            	System.out.print(",");
            }
    		
            System.out.println();
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        // Since we are sorting in-place any leftover elements from the right side
        // are already at the right position.

    }

}
