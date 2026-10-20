class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        int r = s1.length()-1;
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s1.toCharArray()) {
            counts.put(Character.valueOf(c),counts.getOrDefault(Character.valueOf(c),0) + 1);
        }

        while ( r < s2.length()) {
            String sub = s2.substring(l,r+1);
            if (theSame(counts,sub)) {
                return true;
            }
            r++;
            l++;
        }
        return false;
    }

    boolean theSame(HashMap<Character,Integer> counts, String substring) {
        HashMap<Character, Integer> counts2 = new HashMap<>();

        for (char c : substring.toCharArray()) {
            counts2.put(Character.valueOf(c),counts2.getOrDefault(Character.valueOf(c),0) + 1);
        }
        if (counts.equals(counts2)) {
            return true;
        } else {
            return false;
        }

    }
}
