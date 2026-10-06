class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(' | c =='[' | c =='{' ) {
                st.push(c);
            }
            if (c == ')') {
                // char temp = st.peek();
                if (!st.empty() && st.peek() == '(' ){
                    st.pop();
                } else {
                    return false;
                }
            }
            if(c == ']') {
                // char temp = st.peek();
                if (!st.empty() && st.peek() == '['){
                    st.pop();
                }else {
                    return false;
                }
            }

            if(c == '}') {
                // char temp = st.peek();
                if (!st.empty() && st.peek() == '{'){
                     st.pop();
                }else {
                    return false;
                }
            }
        }
        if (!st.empty()){
            return false;
        }
        return true;
    }
}
