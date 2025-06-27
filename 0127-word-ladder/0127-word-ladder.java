class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> hset = new HashSet<>();
        //push all words into set
        int n = wordList.size();
        for(int i=0;i<n;i++){
            hset.add(wordList.get(i));
        }
        //push beginWord into queue
        q.add(new Pair(beginWord,1));
        hset.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            if(word.equals(endWord)){//got final word
                return steps;
            }
            //replace each character of word with character from a to z
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replaced = word.toCharArray();
                    replaced[i] = ch;
                    String replacedword = new String(replaced);
                    //check if it exists in set and push into queue
                    if(hset.contains(replacedword)){
                        hset.remove(replacedword);
                        q.add(new Pair(replacedword, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String first; 
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}