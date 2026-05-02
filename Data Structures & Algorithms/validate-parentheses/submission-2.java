class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        if (s.length() == 1) return false;
        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                if (!st.isEmpty() && st.peek() == brackets.get(c)) st.pop();
                else return false;
            }
            else st.push(c);
        }
        return st.isEmpty();
    }
}
