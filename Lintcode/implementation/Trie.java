package com.company;

// lc 442.
//You may assume that all inputs are consist of lowercase letters a-z.
//Example
//        insert("lintcode")
//        search("code") >>> false
//        startsWith("lint") >>> true
//        startsWith("linterror") >>> false
//        insert("linterror")
//        search("lintcode) >>> true
//        startsWith("linterror") >>> true

public class Trie {

    // 1st, we need to introduce TrieNode class
    static class TrieNode {

        private TrieNode[] children;
        private boolean isWord;
        public TrieNode() {
//            children = new int[26];
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private static TrieNode root;
    public Trie() {

        root = new TrieNode();
    }

    public static void insert(String word) {
        TrieNode n = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (n.children[idx] == null) n.children[idx] = new TrieNode();
            n = n.children[idx]; // go to next level!
        }

        n.isWord = true;
    }

    public static boolean search(String word) {

        TrieNode node = find(word);
        return node != null && node.isWord; // avoid NullPointerException.
    }

    public static boolean startsWith(String prefix) {

        TrieNode node = find(prefix);
        return node != null;
    }

    private static TrieNode find(String str) {
        TrieNode n = root;
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (n.children[idx] == null) return null;
            n = n.children[idx];
        }
        return n;
    }

    public static void main(String[] args) {

        Trie obj = new Trie();
        obj.insert("wordplay");
        boolean param_2 = obj.search("word");
        boolean param_3 = obj.startsWith("word");
        System.out.println(param_2);
        System.out.println(param_3);

    }

}