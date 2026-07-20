class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else if (nums[mid] < nums[r]) r = mid;
        }

        int l1 = l, r1 = nums.length - 1;
        int l2 = 0, r2 = l1 - 1;

        int ans = binarySearch(nums, l1, r1, target);

        return ans == -1 ? binarySearch(nums, l2, r2, target) : ans;
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
            else return mid;
        }
        return -1;
    }
}
