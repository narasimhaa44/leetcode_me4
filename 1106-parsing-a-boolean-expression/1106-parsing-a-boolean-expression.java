// class Solution {
//     public boolean parseBoolExpr(String expression) {
        
//     }
// }
import java.util.*;

class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for(char c : expression.toCharArray()) {

            if(c == ',') continue;

            if(c != ')') {
                stack.push(c);
            }
            else {

                int t = 0, f = 0;

                while(stack.peek() != '(') {
                    char ch = stack.pop();
                    if(ch == 't') t++;
                    else if(ch == 'f') f++;
                }

                stack.pop(); // remove '('

                char op = stack.pop();

                char result;

                if(op == '!') {
                    result = (f == 1) ? 't' : 'f';
                }
                else if(op == '&') {
                    result = (f > 0) ? 'f' : 't';
                }
                else { // '|'
                    result = (t > 0) ? 't' : 'f';
                }

                stack.push(result);
            }
        }

        return stack.peek() == 't';
    }
}