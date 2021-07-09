package leetcode;

import org.junit.Test;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int mid = arr.length >> 1;
        while (true) {
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                mid++;
            } else {
                mid--;
            }
        }
    }

    public int peakIndexInMountainArray2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    @Test
    public void test() {
        System.out.println(peakIndexInMountainArray2(new int[]{0, 1, 2}));
    }
}
