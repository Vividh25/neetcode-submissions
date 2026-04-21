class Solution {
    public boolean isPalindrome(String s) {
        // String[] words = s.split(" ");
        // StringBuilder str = new StringBuilder("");
        // for (String word : words) str.append(word);
        // str.toString();
        // System.out.println(str);
        // int i = 0, j = s.length() - 1;
        // while (i < j) {
        //     if (str.charAt(i) != str.charAt(j)) return false;
        //     i++;
        //     j--;
        // }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}
