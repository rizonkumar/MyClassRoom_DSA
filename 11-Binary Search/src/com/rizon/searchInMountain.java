package com.rizon;

public class searchInMountain {

    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/find-in-mountain-array/
    int search(int[] arr, int target){
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak);
        if(firstTry != -1){
            return firstTry;
        }
        // try to seach in second half
        return orderAgnosticBS(arr, target, peak + 1, arr.length-1);

    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[mid+1]){
                // you are in decreasing part of the array
                // this may be the ans, but look at the left
                // this is why end != end - 1
                end = mid;
            } else {
                // you are in ascending part of the array
                start = mid + 1;    // because we know that mid + 1 element > mid element

            }
        }
        // in the end, start == end and pointing to the largest number in the array because of 2 checks
        // start and end are always trying to find the max element in the above 2 check
        // hence, when they are pointing to just one element, tht is the max one because that is what the checks says
        // more elaboration: at every point of time for start and end, they have best possible answer till that time
        // and if we are saying that only one item is remaining, hence because of above line that is the best possible answer
        return start; // or return end as both are same
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end){
        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            // find the middle element
//            int mid = (start + end)/2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if (isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                if(target > arr[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
