package com.playground.aads;

import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 3/5/14
 * Time: 11:47 PM
 */
public class NaiveRawTableMapTest {
    @Test
    public void testPut() throws Exception {
        NaiveRawTableMap<Integer, String> map = new NaiveRawTableMap<>();
        assertNull(map.get(1));

        map.put(1, "A");
        assertThat(map.get(1), is("A"));
        map.put(15, "B");
        assertThat(map.get(1), is("A"));
        assertThat(map.get(15), is("B"));
        assertNull(map.get(3));

        map.put(1, "A");
        assertThat(map.get(1), is("A"));
        map.put(16, "C");
        assertThat(map.get(1), is("A"));
        assertThat(map.get(16), is("C"));
        assertNull(map.get(3));


        map.put(1, "A");
        assertThat(map.get(1), is("A"));
        map.put(16, "C");
        map.put(31, "D");
        assertThat(map.get(1), is("A"));
        assertThat(map.get(16), is("C"));
        assertThat(map.get(31), is("D"));
        assertNull(map.get(3));
    }


}
