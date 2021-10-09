//package com.rizon;
//
//public class findPeak {
//
//    public static void main(String[] args) {
//
//    }
//
//        // https://leetcode.com/problems/find-peak-element/
//        public int findPeakElement(int[] nums) {
//            int start = 0;
//            int end = nums.length - 1;
//
//            while(start < end){
//                int mid = start + (end - start) / 2;
//
//                if(nums[mid] > nums[mid+1]){
//                    // you are in decreasing part of the array
//                    // this may be the ans, but look at the left
//                    // this is why end != end - 1
//                    end = mid;
//                } else {
//                    // you are in ascending part of the array
//                    start = mid + 1;    // because we know that mid + 1 element > mid element
//
//                }
//            }
//            // in the end, start == end and pointing to the largest number in the array because of 2 checks
//            // start and end are always trying to find the max element in the above 2 check
//            // hence, when they are pointing to just one element, tht is the max one because that is what the checks says
//            // more elaboration: at every point of time for start and end, they have best possible answer till that time
//            // and if we are saying that only one item is remaining, hence because of above line that is the best possible answer
//            return start; // or return end as both are same
//        }
//    }
//
//}
