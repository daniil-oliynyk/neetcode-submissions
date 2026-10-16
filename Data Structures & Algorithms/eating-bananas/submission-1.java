class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int res = high;

        while (low <= high) {
            int mid = (high + low) / 2;

            int timeTaken = 0;
            for (int i = 0; i < piles.length; i++) {
                timeTaken += Math.ceil((double)piles[i] / mid);
            }
            if (timeTaken <= h) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    
}
 