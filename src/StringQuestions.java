import java.math.BigInteger;
import java.util.*;

public class StringQuestions {

    public static int longestValidParentheses(String s) {
        int parentVal=0;
//        int i=0,j=1;
//        while (i<=j && j<s.length()){
//            if(s.charAt(i)=='(' && s.charAt(j)==')'){
//                parentVal+=2;
//                longValue=Math.max(longValue,parentVal);
//                i++;
//                j++;
//            } else if (s.charAt(i)==')') {
//                i++;
//                parentVal=0;
//            }else {
//                j++;
//            }
//        }
        Stack<Integer> para=new Stack<>();
        para.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                para.push(i);
            } else{
                para.pop();
                if(para.empty()){
                    para.push(i);
                }else {
                    parentVal=Math.max(parentVal,i-para.peek());
                }

            }
        }
        return parentVal;
    }


    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int dept=0;
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='('){
                if(dept>0){
                    result.append(ch);
                }
                dept++;
            }else {
                dept--;
                if (dept > 0) {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    public static String largestOddNumber(String num) {
        for(int i=num.length()-1; i>=0;i--){
            int n=Character.getNumericValue(num.charAt(i));
            if(n % 2 !=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;

        String conCat=s + s;

        return conCat.contains(goal);
    }
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((entry1, entry2) -> {
            int freqCompare = Integer.compare(entry2.getValue(), entry1.getValue());
            if (freqCompare == 0) {
                return Character.compare(entry1.getKey(), entry2.getKey());
            }
            return freqCompare;
        });

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(character);
            }
        }

        return result.toString();
    }
    public int myAtoi(String s) {
        int index = 0;
        int sign = 1;
        int result = 0;

        // Remove leading whitespace
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Check for sign
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Read digits until a non-digit character or the end of the input
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }

}
