class Solution {
    public int trap(int[] height) {
        // int[] maxLeft = new int[height.length];
        // int[] maxRight = new int[height.length];

        // maxLeft[0] = 0;
        // for (int i = 1; i < height.length; i++) {
        //     maxLeft[i] = Math.max(height[i-1],maxLeft[i-1]);
        // }

        // maxRight[height.length-1] = 0;
        // for (int i = height.length-2; i > 0; i--) {
        //     maxRight[i] = Math.max(height[i+1],maxRight[i+1]);
        // }
    
        // int totalTrapped = 0;
        // for (int i = 0; i < height.length; i++) {
        //     int water =Math.min(maxLeft[i],maxRight[i]) - height[i];
        //     if ( water> 0) {
        //         totalTrapped += water;
        //     } 
        // }
        // return totalTrapped;

        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];

        int trapped = 0;

        while (l < r) {
            if (maxL < maxR) {
                int water = maxL - height[l];
                if (water > 0) {
                    trapped += water;
                }
                l++;
                maxL = Math.max(maxL, height[l]);
            } else {
                int water = maxR - height[r];
                if (water > 0) {
                    trapped += water;
                }
                r--;
                maxR = Math.max(maxR, height[r]);
            } 
        }
        return trapped;
    }
}
