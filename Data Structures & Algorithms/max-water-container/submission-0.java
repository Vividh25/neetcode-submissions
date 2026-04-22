class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = (j - i) * Math.min(heights[i], heights[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}
