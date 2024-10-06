class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() == sentence2.length()){
            return sentence1.equals(sentence2);
        }
        
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if(s1.length == 1 && s2.length == 1){
            return s1[0].equals(s2[0]);
        }
        if(s1.length == s2.length){
            for(int i = 0; i < s1.length; i++){
                if(!s1[i].equals(s2[i])){
                    return false;
                }
            }
            return true;
        }
        
        

        String[] small = s1.length < s2.length ? s1 : s2;
        String[] big = s1.length > s2.length ? s1 : s2;
        

        for(int i = 0; i < small.length; i++){
            if(!small[i].equals(big[i])){
                break;
            }    
            if(i == small.length - 1){
                return true;
            }
        }

        for(int i = small.length - 1, j = big.length - 1; i >=0; i--, j--){
            if(!small[i].equals(big[j])){
                break;
            }    
            if(i == 0){
                return true;
            }
        }
        int bl = 0;
        int br = big.length - 1;
        int sl = 0;
        int sr = small.length - 1;

        boolean[] sm = new boolean[small.length];
        int valid = sm.length;
        while(true){
            if(small[sl].equals(big[bl])){
                sm[sl] = true;
                valid--;
                sl++;
                bl++;
            }else break;  
        }
        sl--;
        while(true){
            if(small[sr].equals(big[br])){
                sm[sr] = true;
                valid--;
                sr--;
                br--;
            }else break;
        }
        if(valid <= 0){
            return true;
        }


        return false;
    }
}