class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(char c :s.toCharArray()){
            if(c=='('){
                if(!stack.isEmpty()){
                    res.append(c);
                }
                stack.push(c);
            }
            else{
                stack.pop();
                if(!stack.isEmpty()){
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}