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

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.isEmpty()) return combinations;

        String [] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack("", digits, 0, combinations,arr);
        return combinations;


    }
    private  void backtrack(String combination, String digits, int index, List<String> combinations,String [] phoneMap) {
        if (index == digits.length()) {
            combinations.add(combination);
            return;
        }

        String letters = phoneMap[digits.charAt(index) - '0'];
        if (letters != null) {
            for (char letter : letters.toCharArray()) {
                backtrack(combination + letter, digits, index + 1, combinations,phoneMap);
            }
        }
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() !=t.length()) return false;

        HashMap<Character,Integer> map =new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch) && map.get(ch)!=0){
                map.put(ch,map.get(ch)-1);
            }else{
                return false;
            }
        }
        return true;
    }
    public static String reverseWords(String s) {
        // s=s+' ';
        // String word="";
         String newStr="";
        // for(int i=0;i<s.length();i++){
        //     char ch=s.charAt(i);
        //     if(ch==' '){
        //         if(word.isEmpty()){
        //             continue;
        //         }
        //         newStr=word + ' '+ newStr;
        //         word="";
        //         continue;
        //     }
        //     word+=ch;

        // }
        // return newStr.trim();
        StringTokenizer stringTokenizer=new StringTokenizer(s);
        while (stringTokenizer.hasMoreTokens()){
            newStr=stringTokenizer.nextToken() +' '+ newStr;

        }

        return newStr;
    }
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mapSToT = new HashMap<>();
        HashMap<Character,Character> mapTToS = new HashMap<>();


        if(s.length() != t.length());

        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(mapSToT.containsKey(c1) && mapSToT.get(c1)!=c2){
                return false;
            }
            else{
                mapSToT.put(c1,c2);
            }

            if(mapTToS.containsKey(c2) && mapTToS.get(c2)!=c1){
                return false;
            }
            else{

                mapTToS.put(c2,c1);
            }

        }
        return true;
    }

    public String longestPalindrome(String s) {
        //(https://youtu.be/6i_T5kkfv4A?si=OTucUtaxQSBUPVXA)
        if(s.length()<2) return s;
        int maxLen=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                String str=s.substring(i,j);
                if(palindrom(str)>maxLen){
                    System.out.println(str);
                    ans=str;
                    maxLen=palindrom(str);
                }
            }
        }
        return ans;


    }
    public int palindrom(String s){

        int left=0,right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return 0;
            }
            left++;
            right--;
        }
        return s.length();
    }

    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
//        System.out.println(longestValidParentheses(s));
        System.out.println(reverseWords(s));
    }

}
