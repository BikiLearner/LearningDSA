import java.util.Stack;

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
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));
    }

}
