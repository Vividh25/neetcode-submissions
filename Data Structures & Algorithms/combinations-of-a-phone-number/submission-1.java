class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        StringBuilder sb = new StringBuilder("");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(0, digits, ans, sb, map);
        return ans;
    }

    public void backtrack(int i, String digits, List<String> ans, StringBuilder sb, Map<Character, String> map) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String str = map.get(digits.charAt(i));

        for (int j = 0; j < str.length(); j++) {
            sb.append(str.charAt(j));
            backtrack(i+1, digits, ans, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
