// class Solution {
//     public String simplifyPath(String path) {
//         Stack<Character> st=new Stack<>();
//         for(int i=0;i<path.length()-1;i++){
//             if(path.charAt(i)>='a' && path.charAt(i)<='z'|| path.charAt(i)>='A' && path.charAt(i)<='Z'){
//                 s.push(path.charAt(i));
//             }
//             else if(path.charAt(i)=='/' && s.top()=='/'){
//                 continue;
//             }
//             else if(path.charAt(i)=='.' && s.top()=='.' && path.charAt(i+1)=='.'){
//                 s.push(path.charAt(i));
//                 s.push(path.charAt(i+1));
//                 i++;
//             }
//             else if(path.charAt(i)=='.' && s.top()=='.' && path.charAt(i+1)!='.'){
//                 while(s.top()=='/'){
//                     s.pop();
//                 }
//             }
//         }
//         StringBuilder sb=new StringBuilder();
//         while(!s.isEmpty()){
//             sb.append(s.pop());
//         }
//         return sb.reverse();
//     }
// }
import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            else if (part.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }

            else {
                st.push(part);
            }
        }

        // build result
        StringBuilder sb = new StringBuilder();

        for (String dir : st) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}