// class Solution {
//     public int furthestDistanceFromOrigin(String moves) {
//         char[] ch1=moves.toCharArray();
//         int move=0;
//         int b=0;
//         for(Character ch:ch1){
//             if(ch=='L'){
//                 move-=1;
//             }
//             else if(ch=='R'){
//                 move+=1;
//             }
//             else if(ch=='_'){
//                 b++;
//             }
//         }
//         return move+b;
//     }
// }
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0, R = 0, blank = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'L') L++;
            else if (ch == 'R') R++;
            else blank++;
        }

        return Math.abs(L - R) + blank;
    }
}