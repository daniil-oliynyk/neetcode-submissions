class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int n: nums) {
            hs.add(n);
        }

        int res = 0;

        for (int num: hs) {

            if (!hs.contains(num-1)) {
                int start = num;
                int length = 1;
                while(true) {
                    start += 1;
                    if (hs.contains(start)) {
                        length +=1;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, length);

            }


        }
        return res;

    }
}
