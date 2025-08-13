//approach 2
class Solution {
    public String removeOuterParentheses(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : charArray) {
            if (c == '(') {
                if (counter!=0) sb.append('(');
                counter++;
            }
            else{
                counter--;
                if (counter!=0) sb.append(')');
            }
        }
        return sb.toString();
    }
}

//approach 1 using multiple counters to track starting and ending indexes and using overall counter to track asn 

// class Solution {
//     public String removeOuterParentheses(String s) {
//         StringBuilder sb = new StringBuilder(s);
//         int length = s.length();
//         int i = 0;
//         int openingIndexCounter=0;
//         int closingIndexCounter=0;
//         int closingIndex = 0;
//         int openingIndex = 0;
//         while (i <length) {
//             if (i!=0 && openingIndexCounter==closingIndexCounter) {
//                 closingIndex=i-1;
//                 sb.deleteCharAt(openingIndex);
//                 sb.deleteCharAt(closingIndex-1);
//                 length-=2;
//                 i-=2;
//                 openingIndex= i;
//             }
//             if (sb.charAt(i)=='(') openingIndexCounter++;
//             else closingIndexCounter++;
//             i++;
//         }
//         if (i!=0 && openingIndexCounter==closingIndexCounter) {
//                 closingIndex=i-1;
//                 sb.deleteCharAt(openingIndex);
//                 sb.deleteCharAt(closingIndex-1);
//             }
//        return sb.toString();
//     }
// }