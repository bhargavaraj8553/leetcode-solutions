class Solution {
    public boolean isValid(String s) {
        // Create hashmap to store the pairs...
        HashMap<Character, Character> Hmap = new HashMap<Character, Character>();
        Hmap.put(')','(');
        Hmap.put('}','{');
        Hmap.put(']','[');
        // Create stack data structure...
        Stack<Character> stack = new Stack<Character>();
        // Traverse each charater in input string...
        for (int idx = 0; idx < s.length(); idx++){
            // If open parentheses are present, push it to stack...
            if (s.charAt(idx) == '(' || s.charAt(idx) == '{' || s.charAt(idx) == '[') {
                stack.push(s.charAt(idx));
                continue;
            }
            // If the character is closing parentheses, check that the same type opening parentheses is being pushed to the stack or not...
            // If not, we need to return false...
            if (stack.size() == 0 || Hmap.get(s.charAt(idx)) != stack.pop()) {
                return false;
            }
        }
        // If the stack is empty, return true...
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}

// class Solution {
//     public boolean isValid(String s) {
//         Stack<Character> paranthesisStack = new Stack<>();

//         for (int i =0; i<s.length(); i++){
//             char c = s.charAt(i);
//             if (c == '(' || c== '{' || c== '['){
//                 paranthesisStack.push(c);
//             } else {
//                 if (paranthesisStack.isEmpty()){
//                     paranthesisStack.push(c);
//                     continue;
//                 }
//                 if (c == ')'){
//                     if (paranthesisStack.peek() == '(') paranthesisStack.pop();
//                     else paranthesisStack.push(c);
//                 } else if (c== '}') {
//                     if (paranthesisStack.peek()== '{') paranthesisStack.pop();
//                     else paranthesisStack.push(c);
//                 } else {
//                     if (paranthesisStack.peek() == '[') paranthesisStack.pop();
//                     else paranthesisStack.push(c);
//                 }
//             }
//         }

//         return paranthesisStack.isEmpty();
//     }
// }