class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c: s1.toCharArray()) {
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        int l = 0;
        int r = s1.length()-1;
        HashMap<Character, Integer> hm2 = new HashMap<>();

        while (r < s2.length()) {

            String substr = s2.substring(l,r+1);
            for (char c: substr.toCharArray()) {
                hm2.put(c, hm2.getOrDefault(c, 0) +1);
            }
            if(hm.equals(hm2)) {
                return true;
            }
            hm2.clear();
            r++;
            l++;

        }
        return false;

    }
}
