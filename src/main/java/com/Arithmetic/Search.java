package com.Arithmetic;

/**
 * Created：Jeffrey
 * date   ：2021/8/9 14:41
 */
public class Search {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 34, 45, 56, 78};
//        System.out.println(binarySearch(arr, 0, 4, 56));
        System.out.println(binarySearch(arr, 0, 4, 67));



    }


    public static int binarySearch(int[] arr, int left, int right, int value) {
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (left > right) {
            return -1;
        }
        if (midValue > value) {
            return binarySearch(arr, left, mid - 1, value);
        } else if (midValue < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }

}
