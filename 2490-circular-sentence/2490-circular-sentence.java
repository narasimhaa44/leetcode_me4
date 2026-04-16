class Solution {
    public boolean isCircularSentence(String sentence) { 
        String[] words=sentence.split(" ");
        if(words.length==1){
            if(words[0].charAt(0)==words[0].charAt(words[0].length()-1)) return true;
            else return false;
        }
        String init=words[0];
        for(int i=1;i<words.length;i++){
            if(init.charAt(init.length()-1)!=words[i].charAt(0)) return false;
            init=words[i];
        }
        if(words[0].charAt(0)!=init.charAt(init.length()-1)) return false;
        return true;
    }
}