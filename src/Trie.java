import java.util.ArrayList;
import java.util.List;

/*
got help from:
https://www.geeksforgeeks.org/auto-complete-feature-using-trie/
https://medium.com/@dookpham/predictive-text-autocomplete-using-a-trie-prefix-tree-data-structure-in-javascript-part-1-6ff7fa83c74b
http://www.tutre.com/index.php/2015/11/02/autocomplete-implementation-using-tries/
https://www.lavivienpost.com/autocomplete-with-trie-code/
 */

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode(' ');
    }

    public void add(String str) {
        if (search(str) == true) {
            return;
        }
        TrieNode ptr = root;
        TrieNode temp;
        for (char ch : str.toCharArray()) {
            temp = ptr;
            TrieNode node = ptr.getTrieList(ch);
            if (node != null) {
                ptr = node;
                node.Node = temp;
            } else {
                ptr.trieList.add(new TrieNode(ch));
                ptr = ptr.getTrieList(ch);
                ptr.Node = temp;
            }
        }
        ptr.isTrue = true;
    }

    public boolean search(String word) {
        TrieNode ptr = root;
        for (char ch : word.toCharArray()) {
            if (ptr.getTrieList(ch) == null) {
                return false;
            }
            else {
                ptr = ptr.getTrieList(ch);
            }
        }
        if (ptr.isTrue == true) {
            return true;
        }
        return false;
    }

    public List<String> autocomplete(String str) {
        TrieNode lastNode = root;
        for (int i = 0; i < str.length(); i++) {
            lastNode = lastNode.getTrieList(str.charAt(i));
            if (lastNode == null) {
                return new ArrayList<>();
            }
        }
        return lastNode.getString();
    }
}
