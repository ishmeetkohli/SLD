class Solution {

    public static final String YES =  "YES, can be made of only known words";
    public static final String NO =  "NO, can NOT be made of only known words";

    public static void main(String[] args) {
        Trie dictionaryTrie = new Trie();
        dictionaryTrie.insert("toy example");
        dictionaryTrie.insert("bottle");
        dictionaryTrie.insert("nuts");
        dictionaryTrie.insert("pea");
        dictionaryTrie.insert("peanuts");
        dictionaryTrie.insert("set");
        dictionaryTrie.insert("string");
        dictionaryTrie.insert("super");
        dictionaryTrie.insert("superset");


        String word1 = "supersetpeanuts";
        String word2 = "supersetqpeanuts";

        boolean result1 = isWordPossible(word1, dictionaryTrie);
        boolean result2 = isWordPossible(word2, dictionaryTrie);

        System.out.println(result1 ? YES : NO);
        System.out.println(result2 ? YES : NO);
    }

    private static boolean isWordPossible(String input, Trie trie) {
        String current = null, remaining = null;
        int size = input.length();

        // End condition
        if(size == 0) {
            return true;
        }

        for (int i = 1; i <= input.length(); i++) {
            current = input.substring(0, i);
            remaining = input.substring(i, size);

            // trie.search returns a boolean
            if(trie.containsNode(current) && isWordPossible(remaining, trie)) {
                return true;
            }
        }
        return false;
    }
}