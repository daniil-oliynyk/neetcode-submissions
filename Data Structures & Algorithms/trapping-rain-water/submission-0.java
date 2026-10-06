class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] mins = new int[height.length];

        for (int i = 0; i < height.length;i++) {
            if (i == 0){
                maxLeft[i] = height[i];
            } else {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
            }
        }
        
        for (int i = height.length-1; i > 0;i--) {
            if (i==height.length-1) {
                maxRight[i] = height[i];
            } else {
                maxRight[i] = Math.max(maxRight[i+1], height[i]);
            }
        }
        for (int i = 0; i < height.length;i++) {
            mins[i] = Math.min(maxLeft[i], maxRight[i]);
        }

        int res = 0;
        for (int i = 0; i<height.length;i++){

            int t = mins[i] - height[i];
            if (t > 0) {
                res += t;
            } 

        }

        return res;
    }
}
