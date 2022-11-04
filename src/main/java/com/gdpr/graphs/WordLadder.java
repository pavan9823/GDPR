package com.gdpr.graphs;

import java.util.*;

class Tuple{
    String f;
    int s;
    Tuple(String f,int s){
        this.f = f;
        this.s = s;
    }
}
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(beginWord,1));
        if(wordSet.contains(beginWord))
            wordSet.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().f;
            int steps = q.peek().s;
            q.remove();
            if(word.equals(endWord))
                return steps;
            for (int i = 0; i < word.length() ; i++) {

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] charArray = word.toCharArray();
                    charArray[i]=ch;
                    String replacedWord = new String(charArray);
                    if(!word.equals(replacedWord) && wordSet.contains(replacedWord)){
                        wordSet.remove(replacedWord);
                        q.add(new Tuple(replacedWord,steps+1));
                        System.out.println(steps+1+"--"+replacedWord);
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord ="cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(List.of(words));
        WordLadder w = new WordLadder();

        int res = w.ladderLength(beginWord,endWord,wordList);
        System.out.println(res);
    }
}
