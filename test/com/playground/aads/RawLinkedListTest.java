package com.playground.aads;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 3/6/14
 * Time: 10:48 PM
 */
public class RawLinkedListTest {
    @Test
    public void testGet() throws Exception {
        RawLinkedList<Integer> rll = new RawLinkedList<>();
        rll.add(1);
        rll.add(2);
        rll.add(3);
        assertThat(rll.get(0), is(1));
        assertThat(rll.get(1), is(2));
        assertThat(rll.get(2), is(3));
        assertNull(rll.get(4));
    }
}
