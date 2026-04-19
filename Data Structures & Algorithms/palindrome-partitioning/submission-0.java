class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        String sub = "";
        StringBuilder substr = new StringBuilder(sub);
        backtrack(0, s, ans, curr);
        return ans;
    }

    public void backtrack(int i, String s, List<List<String>> ans, List<String> curr) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String substr = s.substring(i, j+1); 
            if(isPalindrome(substr)) {
                curr.add(substr);
                backtrack(j+1, s, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
