class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r && nums[l] == nums[r]) l++;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) r = mid;
            else if (nums[mid] > nums[r]) l = mid + 1;
            else r--; 
        }

        // System.out.println(l);

        int l1 = l, r1 = nums.length - 1;
        int l2 = 0, r2 = l - 1;

        return binarySearch(l1, r1, nums, target) || binarySearch(l2, r2, nums, target);
    }

    public boolean binarySearch(int l, int r, int[] nums, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else return true;
        }
        return false;
    }
}