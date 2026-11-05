class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();

        while (p1 != word1.length()) {
            if (p2 == word2.length()) {
                // append rest of p1
                sb.append(word1.substring(p1,word1.length()));
                return sb.toString();
            }
            sb.append(word1.charAt(p1));
            sb.append(word2.charAt(p2));
            p1++;
            p2++;
            
        }
        sb.append(word2.substring(p2,word2.length()));
        return sb.toString();

    }
}