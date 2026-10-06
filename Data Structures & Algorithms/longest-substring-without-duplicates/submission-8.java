class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }

        HashSet<Character> hs = new HashSet<>();
        int l = 0;
        int r = 0;
        
        int ret = 0;
        int count = 0;
        while (r < s.length()){
            if (hs.contains(s.charAt(r))) {
                while (hs.contains(s.charAt(r))) {
                    hs.remove(s.charAt(l));
                    l += 1;
                }
                
                
                
            } else {
                hs.add(s.charAt(r));
                r += 1;
                ret = Math.max(ret, r-l+1);
            }
        }
        return ret-1;

    }
}
