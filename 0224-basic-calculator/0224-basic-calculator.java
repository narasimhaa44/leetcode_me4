// import java.util.*;

// class Solution {
//     public int calculate(String s) {
//         Stack<Integer> nums = new Stack<>();
//         Stack<Character> ops = new Stack<>();

//         int n = s.length();

//         for (int i = 0; i < n; i++) {
//             char c = s.charAt(i);

//             // skip spaces
//             if (c == ' ') continue;

//             // number (handle multi-digit)
//             if (Character.isDigit(c)) {
//                 int num = 0;
//                 while (i < n && Character.isDigit(s.charAt(i))) {
//                     num = num * 10 + (s.charAt(i) - '0');
//                     i++;
//                 }
//                 i--;
//                 nums.push(num);
//             }

//             // opening bracket
//             else if (c == '(') {
//                 ops.push(c);
//             }

//             // closing bracket
//             else if (c == ')') {
//                 while (ops.peek() != '(') {
//                     nums.push(eval(nums.pop(), nums.pop(), ops.pop()));
//                 }
//                 ops.pop(); // remove '('
//             }

//             // operator
//             else {
//                 // 🔥 HANDLE UNARY MINUS (with spaces)
//                 if (c == '-') {
//                     int j = i - 1;
//                     while (j >= 0 && s.charAt(j) == ' ') j--;

//                     if (j < 0 || s.charAt(j) == '(') {
//                         nums.push(0);
//                     }
//                 }

//                 // apply previous operators with higher/equal precedence
//                 while (!ops.isEmpty() && ops.peek() != '(' &&
//                        precedence(ops.peek()) >= precedence(c)) {
//                     nums.push(eval(nums.pop(), nums.pop(), ops.pop()));
//                 }

//                 ops.push(c);
//             }
//         }

//         // process remaining operations
//         while (!ops.isEmpty()) {
//             nums.push(eval(nums.pop(), nums.pop(), ops.pop()));
//         }

//         return nums.pop();
//     }

//     // IMPORTANT: order matters (a op b)
//     private int eval(int b, int a, char op) {
//         if (op == '+') return a + b;
//         if (op == '-') return a - b;
//         if (op == '*') return a * b;
//         return a / b;
//     }

//     private int precedence(char op) {
//         if (op == '+' || op == '-') return 1;
//         return 2; // * and /
//     }
// }
class Solution {
    public int calculate(String s) {
        
        int sign = 1;
        int answer = 0;
        int operand = 0;

        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                operand = operand * 10 + c - '0';
            }
            else if (c == '+') {
                answer += sign * operand;
                sign = 1;
                operand = 0;
            }
            else if (c == '-') {
                answer += sign * operand;
                sign = -1;
                operand = 0;
            }
            else if (c == '(') {
                stack.push(answer);
                stack.push(sign);

                sign = 1;
                operand = 0;
                answer = 0;
            }
            else if (c == ')') {
                answer += sign * operand;
                answer *= stack.pop();
                answer += stack.pop();

                sign = 1;
                operand = 0;
            }
        }

        return answer + sign * operand;
    }
}