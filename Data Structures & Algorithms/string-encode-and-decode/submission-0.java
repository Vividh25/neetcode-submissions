class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            int n = str.length();
            encoded.append(n + "#" + str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder len = new StringBuilder();
            while (str.charAt(i) != '#') {
                len.append(str.charAt(i));
                i++;
            }
            i++;
            int l = Integer.parseInt(len.toString());
            StringBuilder s = new StringBuilder();
            while (l-- > 0) {
                s.append(str.charAt(i));
                i++;
            }
            decoded.add(s.toString());
        }
        return decoded;
    }
}
