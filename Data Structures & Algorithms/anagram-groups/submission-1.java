class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < strs.length; i++) {
            if (set.contains(strs[i])) continue;
            List<String> curr = new ArrayList<>();
            curr.add(strs[i]);
            for (int j = i+1; j < strs.length; j++) {
                char[] str1 = strs[i].toCharArray();
                char[] str2 = strs[j].toCharArray();
                Arrays.sort(str1);
                Arrays.sort(str2);
                // System.out.println(str1 + " " + str2);
                if (Arrays.equals(str1, str2)) {
                    curr.add(strs[j]);
                    set.add(strs[j]);
                }
                // System.out.println();
            }
            ans.add(new ArrayList<>(curr));
        }
        return ans;
    }
}
