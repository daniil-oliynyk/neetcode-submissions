class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> s1Counts = new HashMap<>();
        HashMap<Character,Integer> s2Counts = new HashMap<>();
        for (char c : s1.toCharArray()) {
            s1Counts.put(Character.valueOf(c),s1Counts.getOrDefault(Character.valueOf(c),0)+1);
        }

        int l = 0;
        int r = 0;

        while (r < s2.length()) {
            while (r-l+1 > s1.length()) {
                s2Counts.put(Character.valueOf(s2.charAt(l)),s2Counts.get(Character.valueOf(s2.charAt(l)))-1);
                if (s2Counts.get(Character.valueOf(s2.charAt(l))) == 0) {
                    s2Counts.remove(Character.valueOf(s2.charAt(l)));
                }
                l+=1;
            }
            
            s2Counts.put(Character.valueOf(s2.charAt(r)),s2Counts.getOrDefault(Character.valueOf(s2.charAt(r)),0)+1);
            if(s1Counts.equals(s2Counts)) {
                return true;
            }
            r+=1;
        }
        return false;
    }
}
