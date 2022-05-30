package tech.igrant.binarySearch.no852;

class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (true) {
            if (left == right) {
                return -1;
            }
            int middle = (right - left) / 2 + left;
            if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
                return middle;
            }
            if (arr[middle] < arr[middle + 1]) {
                left = middle;
            } else {
                right = middle;
            }
        }
    }

}
