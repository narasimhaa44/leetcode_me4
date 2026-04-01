// class Pair{
//     int pos;
//     int[] details;
//     public Pair(int pos,int[] details){
//         this.pos=pso;
//         this.details=details;
//     }
// }
// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//         List<Integer> res = new ArrayList<>();
//         if(!directions.contains("L")){
//             for (int h : healths) {
//                  res.add(h);
//             }
//                     return res;
//         }
//         ArrayList<Pair> arr=new ArrayList<>();
//         List<Character> char=directions.toCharArray();
//         PriorityQueue<Pair> pq=new PriorityQueue<>();
//         for(int i=0;i<n;i++){
//             arr.add(new Pair(positions[i],new int[]{healths[i],(directions[i]=='R')?1:-1}));
//         }
//         for(Pair p:arr){
//             int botpos=p.pos;
//             int[] botdet=pos.details;
//             if(botdet[1]==1){
//                 pq.add(p);
//             }
//             else if(botdet[1]==-1){
//                 Pair botprev=pq.poll();
//                 if(botprev.details[0]>p.details[0]){
//                     botprev.details[0]-=1;
//                     pq.add(botprev);
//                 }
//                 else if(botprev.details[0]<p.details[0]){
//                     p.details[0]-=1;
//                     pq.add(p);
//                 }
//                 else{
//                     continue;
//                 }
//             }
//         }
//         for(Pair p:pq){
//             res.add(p.details[0]);
//         }
//     }
// }
import java.util.*;

class Pair{
    int pos;
    int[] details;
    int idx;
    public Pair(int pos,int[] details,int idx){
        this.pos=pos;
        this.details=details;
        this.idx=idx;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        List<Integer> res = new ArrayList<>();
        if(!directions.contains("L")){
            for (int h : healths) {
                res.add(h);
            }
            return res;
        }

        ArrayList<Pair> arr=new ArrayList<>();

        for(int i=0;i<n;i++){
            arr.add(new Pair(positions[i],new int[]{healths[i],(directions.charAt(i)=='R')?1:-1},i));
        }

        Collections.sort(arr,(a,b)->a.pos-b.pos);

        Stack<Pair> st=new Stack<>();

        for(Pair p:arr){
            if(p.details[1]==1){
                st.push(p);
            }
            else{
                while(!st.isEmpty() && st.peek().details[1]==1){
                    Pair prev=st.peek();

                    if(prev.details[0]>p.details[0]){
                        prev.details[0]-=1;
                        p.details[0]=0;
                        break;
                    }
                    else if(prev.details[0]<p.details[0]){
                        p.details[0]-=1;
                        st.pop();
                    }
                    else{
                        st.pop();
                        p.details[0]=0;
                        break;
                    }
                }
                if(p.details[0]>0){
                    st.push(p);
                }
            }
        }

        List<Pair> survivors=new ArrayList<>(st);
        Collections.sort(survivors,(a,b)->a.idx-b.idx);

        for(Pair p:survivors){
            res.add(p.details[0]);
        }

        return res;
    }
}