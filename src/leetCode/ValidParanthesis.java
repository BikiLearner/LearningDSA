package leetCode;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args){
        String str=")()())";
        System.out.println(longestValidParentheses(str));
    }
    public static int longestValidParentheses(String s) {
        int parentVal=0;
        Stack<Integer> para=new Stack<>();
        para.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                para.push(i);
            } else if(!para.empty() && s.charAt(i)==')'){
                para.pop();
                if(para.empty()){
                    para.push(i);
                }else {
                    parentVal = Math.max(parentVal, i - para.peek());
                }

            }

        }
        return parentVal;
    }
}
