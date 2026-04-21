class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[j] + numbers[i] < target) i++;
            else if (numbers[j] + numbers[i] > target) j--;
            else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{};
    }
}
