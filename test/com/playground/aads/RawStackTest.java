package com.playground.aads;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 3/4/14
 * Time: 9:15 PM
 */
public class RawStackTest {

    @Test
    public void testPop() throws Exception {
        RawStack<Integer> stack = new RawStack<>();
        stack.push(10);
        assertThat(stack.pop(), is(10));
        assertNull(stack.pop());
        stack.push(10);
        stack.push(11);
        stack.push(12);
        assertThat(stack.pop(), is(12));
        assertThat(stack.pop(), is(11));
        assertThat(stack.pop(), is(10));
        assertEquals(null, stack.pop());
    }

}
