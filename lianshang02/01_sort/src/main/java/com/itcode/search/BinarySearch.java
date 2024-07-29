package com.itcode.search;

/**
 * 二分查找
 */
public class BinarySearch<E extends Comparable<E>> {


    public static void main(String[] args) {
        System.out.println(new BinarySearch<Integer>().binarySearch(new Integer[]{1, 2, 3, 4, 5, 6}, 5));
    }


    /**
     * if not found, return -1.
     */
    public int binarySearch(E[] arr, E element) {
        int low = 0;
        int high = arr.length;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (element.compareTo(arr[mid]) < 0) {
                high = mid;
            } else if (element.compareTo(arr[mid]) > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
