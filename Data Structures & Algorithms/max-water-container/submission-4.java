class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = 0;

        if (heights.length == 2) {
            return Math.min(heights[0],heights[1]);
        }

        int l = 0;
        int r = heights.length-1;

        while (l < r) {
            int area = Math.min(heights[l],heights[r])*(r-l);
            if (area > maxArea) {
                maxArea = area;
            }
            if (heights[l] > heights[r]) {
                r--;
            } else if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
                l++;
            }
        }

        
        return maxArea;

    }
}
