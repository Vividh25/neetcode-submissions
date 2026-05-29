class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        for (String s : tokens) {
            if (operations.contains(s)) {
                int res = 0;
                int b = stack.pop();
                int a = stack.pop();
                if (s.equals("+")) {
                    res = a + b;
                }
                else if (s.equals("-")) {
                    res = a - b;
                }
                else if (s.equals("*")) {
                    res = a * b;
                }
                else if (s.equals("/")){
                    res = a / b;
                }
                stack.push(res);
            }
            else stack.push(Integer.parseInt(s));
        }
        return stack.peek();
    }
}
