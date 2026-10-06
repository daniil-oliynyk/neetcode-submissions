class Solution {
    public String minRemoveToMakeValid(String s) {
       int open = 0;
       int closed = 0;
       StringBuilder res = new StringBuilder();

        for(Character c : s.toCharArray()) {
           if (c == ')') {
                closed++;
            }
        }

        for (Character c : s.toCharArray()) {
            if (c == '(' ) {
                if(open == closed) continue;
                open++;
            } else if (c == ')'){
                closed--;
                if (open == 0) continue;
                open--;
            }
            res.append(c);
        }
        

        return res.toString();

    }
}