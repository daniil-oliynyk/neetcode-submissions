class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int r = 0;
        int res = 0;

        while (r <= s.length()-1) {
            char c = s.charAt(r);
            hm.put(Character.valueOf(c),hm.getOrDefault(Character.valueOf(c),0)+1);

            int maxf = getMax(hm);
            if ((r-l+1)-maxf <= k) {
                res = Math.max(res,r-l+1);
            } else {
                while ((r-l+1)-maxf > k) {
                    char toDecrement = s.charAt(l);
                    hm.put(Character.valueOf(toDecrement),hm.get(Character.valueOf(toDecrement))-1);
                    l++;
                }
                
            }
            r++;

        }
        return res;
    }

    int getMax(HashMap<Character,Integer> hm) {
        int maxf = 0;

        for (int i: hm.values()) {
            maxf = Math.max(maxf, i);
        }
        return maxf;
    }
}
