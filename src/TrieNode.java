import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class TrieNode {
    LinkedList<TrieNode> trieList;
    TrieNode Node;
    char data;
    boolean isTrue;

    public TrieNode(char ch) {
        data = ch;
        trieList = new LinkedList<>();
        isTrue = false;
    }

    public TrieNode getTrieList(char ch) {
        if (trieList != null) {
            for (TrieNode Node : trieList){
                if (Node.data == ch) {
                    return Node;
                }
            }
        }
        return null;
    }

    protected List<String> getString() {
        List<String> list = new ArrayList<>();
        if (isTrue) {
            list.add(toString());
        }
        if (trieList != null) {
            for (int i = 0; i < trieList.size(); i++) {
                if (trieList.get(i) != null) {
                    list.addAll(trieList.get(i).getString());
                }
            }
        }
        return list;
    }

    public String toString() {
        if (Node == null) {
            return "";
        } else {
            return Node.toString() + new String(new char[] {data});
        }
    }
}
