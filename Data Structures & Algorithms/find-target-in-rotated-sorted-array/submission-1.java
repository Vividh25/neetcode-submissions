class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else if (nums[mid] < nums[r]) r = mid;
        }
        int l1 = l, r1 = nums.length - 1;
        int l2 = 0, r2 = l - 1;
        System.out.println(l);

        int ans1 = binarySearch(nums, l1, r1, target);
        if (ans1 != -1) return ans1;

        int ans2 = binarySearch(nums, l2, r2, target);
        if (ans2 != -1 ) return ans2;
        
        return -1;
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
