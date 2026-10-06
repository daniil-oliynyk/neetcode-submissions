class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!hm1.containsKey(Character.toString(s.charAt(i)))) {
                hm1.put(Character.toString(s.charAt(i)), 1);
            } else {
                int temp = hm1.get(Character.toString(s.charAt(i)));
                hm1.replace(Character.toString(s.charAt(i)), temp+1);
            }
        
            if (!hm2.containsKey(Character.toString(t.charAt(i)))) {
                hm2.put(Character.toString(t.charAt(i)), 1);
            } else {
                int temp = hm2.get(Character.toString(t.charAt(i)));
                hm2.replace(Character.toString(t.charAt(i)), temp+1);
            }
        }
        return hm1.equals(hm2);

    }
}
