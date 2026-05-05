class Solution {
    Map<String, Boolean> dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();
        return recur(s, wordDict);
    }

    public boolean recur(String s, List<String> wordDict) {
        if (s.length() == 0) return true;

        if (dp.containsKey(s)) return dp.get(s);

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (recur(s.substring(word.length()), wordDict)){
                    dp.put(s, true);
                    return true;
                } 
            }
        }
        dp.put(s, false);
        return false;
    }
}
