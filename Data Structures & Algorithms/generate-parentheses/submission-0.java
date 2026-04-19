class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> st = new Stack<>();
        backtrack(0, n, ans, sb, 0, 0);
        return ans;
    }

    public void backtrack(int i, int n, List<String> ans, StringBuilder sb, int open, int close) {
        //base condition
        if(open == n && close == open) {
            ans.add(sb.toString());
            return;
        }

        for (int j = i; j < 2*n; j++) {
            if (open < n) {
                sb.append('(');
                backtrack(j+1, n, ans, sb, open+1, close);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (close < open) {
                sb.append(')');
                backtrack(j+1, n, ans, sb, open, close+1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
