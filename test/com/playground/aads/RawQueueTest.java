package com.playground.aads;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * User: liviu
 * Date: 3/4/14
 * Time: 9:39 PM
 */
public class RawQueueTest {
    @Test
    public void testPop() throws Exception {
        RawQueue<Integer> queue = new RawQueue<>();
        assertEquals(null, queue.dequeue());

        queue.enqueue(1);
        assertThat(queue.dequeue(), is(1));
        assertEquals(null, queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
        assertThat(queue.dequeue(), is(3));

        assertEquals(null, queue.dequeue());

    }
}
