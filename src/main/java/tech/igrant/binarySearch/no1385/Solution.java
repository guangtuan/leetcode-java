package tech.igrant.binarySearch.no1385;

import java.util.Arrays;

class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int num1 : arr1) {
            int low = num1 - d;
            int high = num1 + d;
            if (!invalid(arr2, low, high)) {
                ans++;
            }
        }
        return ans;
    }

    public static boolean invalid(int[] arr, int low, int high) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= low && arr[mid] <= high) {
                return true;
            } else if (arr[mid] < low) {
                left = mid + 1;
            } else if (arr[mid] > high) {
                right = mid - 1;
            }
        }
        return false;
    }

}
