package com.gdpr.trie;

class Node{
    Node[] links = new Node[26];
    boolean flag;

    Node(){

    }

    public boolean contains(char ch){
        return links[ch-'a']!=null;
    }

    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }

    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }


}
public class Trie {
    Node root ;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.contains(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.contains(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return false;
            }
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            if(node.contains(prefix.charAt(i))){
                node = node.get(prefix.charAt(i));
            }
            else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        boolean param_2 = obj.search("apple");
        boolean param_3 = obj.startsWith("app");
        System.out.println(param_2);
        System.out.println(param_3);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */