class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (binarySearch(row, target)) return true;
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > target) r = mid - 1;
            else if (arr[mid] < target) l = mid + 1;
            else return true;
        }
        return false;
    }
}
