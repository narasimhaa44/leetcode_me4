class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int width = r - l;
            maxArea = Math.max(maxArea, h * width);

            // move smaller pointer
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}