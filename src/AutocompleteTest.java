import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AutocompleteTest {

    @Test
    public void test() {
        String inputs[] = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};
        Trie trie = new Trie();

        for (int i = 0; i < inputs.length; i++){
            trie.add(inputs[i]);
        }
        List<String> complete = trie.autocomplete("h");
        List<String> completeTwo = trie.autocomplete("se");
        List<String> completeThree = trie.autocomplete("sea");
        List<String> completeFour = trie.autocomplete("ho");
        List<String> empty = trie.autocomplete("xyz");

//        assertEquals(Arrays.asList("hello", "high", "hollow", "how")

        assertEquals(complete, trie.autocomplete("h"));
        System.out.println(complete);

        assertEquals(completeTwo, trie.autocomplete("se"));
        System.out.println(completeTwo);

        assertEquals(completeThree, trie.autocomplete("sea"));
        System.out.println(completeThree);

        assertEquals(completeFour, trie.autocomplete("ho"));
        System.out.println(completeFour);

        assertEquals(empty, trie.autocomplete("xyz"));
        System.out.println(empty);
    }
}
