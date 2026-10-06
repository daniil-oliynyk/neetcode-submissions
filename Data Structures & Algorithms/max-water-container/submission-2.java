class Solution {
    public int maxArea(int[] heights) {
        int res = 0;

        int l = 0;
        int r = heights.length-1;

        while (l<r) {

            System.out.println("L: "+heights[l]+" R: "+heights[r]);
           
            int w = Math.abs(r-l);
            int h = Math.min(heights[l],heights[r]);
            res = Math.max(res, w*h);

            if (heights[l]<=heights[r]) {
                l++;
            }  else {
                r--;
            }
        }
        return res;

    }
}
