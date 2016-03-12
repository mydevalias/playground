package com.playground.aads;

import org.junit.Test;


import java.util.List;


import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.*;


/**
 * Created by liviu on 12.03.2016.
 */
public class TrieTest {

    @Test
    public void test(){
        Trie trie = new Trie();
        trie.addWord("dog");
        trie.addWord("door");
        trie.addWord("room");

        List<String> lst = trie.getWords("do");
        assertThat(lst, hasItems("dog", "door"));
    }

}