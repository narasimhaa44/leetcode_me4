// class Solution {
//     public String processStr(String s) {
//         StringBuilder sb=new StringBuilder();
//         for(char c:s.toCharArray()){
//             if(c>='a' && c<='z'){
//                 sb.append(c);
//             }
//             else if(c=='*' && sb.length()>0){
//                 sb.remove(sb.length()-1);
//             }
//             else if(c=='#'){
//                 sb.append(sb);
//             }
//             else if(c=='%'){
//                 sb.reverse();
//             }
//         }
//         return sb.toString();
//     }
// }
class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            }

            else if (c == '*' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1); // FIXED
            }

            else if (c == '#') {
                sb.append(sb);
            }

            else if (c == '%') {
                sb.reverse();
            }
        }

        return sb.toString();
    }
}