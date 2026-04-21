class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[j] + numbers[i] < target) i++;
            else if (numbers[j] + numbers[i] > target) j--;
            else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                break;
            }
        }
        return ans;
    }
}
