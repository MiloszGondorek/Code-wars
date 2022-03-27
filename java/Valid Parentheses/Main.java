//task url: https://www.codewars.com/kata/52774a314c2333f0a7000688
import java.util.ArrayList;
import java.util.List;

class Solution{
    public boolean validParentheses(String parens)
    {
        List<Integer> left=new ArrayList<>(),right=new ArrayList<>(); // Create a list of left bracket and list of right bracket
        char[] chars=parens.toCharArray(); // Convert string 'parens' to char array
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(') // If char == '(', then add this char id to left brackets list
                left.add(i);
            else if(chars[i]==')') // Else if char == ')', then add this char id to right brackets list
                right.add(i);
        }

        while (left.stream().count()>0){ // While left list have ids
            if(right.stream().count()>0) {
                if (left.get(0) < right.get(0)) { // If smallest left brackets id < right brackets id, then remove them from lists
                    left.remove(0);
                    right.remove(0);
                }
                else // Else return false, because now right bracket is first (first only for brackets)
                    return false;
            }
            else // If right doesn't have any brackets return false, because there's not the same number of left and right brackets
                return false;
        }

        if(right.stream().count()>0) // Return false, because now right bracket is first (first only for brackets)
            return false;

        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().validParentheses("()"));
        System.out.println(new Solution().validParentheses("())"));
        System.out.println(new Solution().validParentheses("32423(sgsdg)"));
        System.out.println(new Solution().validParentheses("(dsgdsg))2432"));
        System.out.println(new Solution().validParentheses("adasdasfa"));
        System.out.println(new Solution().validParentheses("()()((()"));
        System.out.println(new Solution().validParentheses(""));
    }
}
