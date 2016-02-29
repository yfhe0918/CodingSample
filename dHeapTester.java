import static org.junit.Assert.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * The dHeapTester implements JUnit test cases for dHeap class
 * 
 * @author Yifan He
 * @version 1.0
 * @since 02-14-2016
 */

public class dHeapTester {

    private dHeap<Integer> numheap;
    private dHeap<String> strheap;

    /**
     * setup that initializes dheap before each test
     */
    @Before
    public void setUp() {
        numheap = new dHeap<Integer>(3, 10);
        strheap = new dHeap<String>(7);
        numheap.add(1);
        numheap.add(2);
        numheap.add(3);
        numheap.add(4);
        numheap.add(5);
        numheap.add(6);
        numheap.add(7);
        strheap.add("a");
        strheap.add("b");
        strheap.add("c");
        strheap.add("d");
        strheap.add("e");
    }

    /**
     * Tester to check size functionality
     */
    @Test
    public void testSize() {
        assertEquals("Check size", 7, numheap.size());
        assertEquals("Check size", 5, strheap.size());
    }

    /**
     * Tester to check add and remove functionality
     */
    @Test
    public void testAddAndRemove() {
        numheap.add(0);
        numheap.add(4);
        numheap.add(7);
        numheap.add(10);
        assertEquals("Check resize", 11, numheap.size());
        assertEquals("Check add and remove", 
                new Integer(0), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(1), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(2), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(3), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(4), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(4), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(5), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(6), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(7), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(7), numheap.removeSmallest());
        assertEquals("Check add and remove", 
                new Integer(10), numheap.removeSmallest());
        assertEquals("Check size", 0, numheap.size());
        strheap.add("b");
        strheap.add("d");
        strheap.add("f");
        strheap.add("g");
        strheap.add("h");
        assertEquals("Check add and remove", "a", strheap.removeSmallest());
        assertEquals("Check add and remove", "b", strheap.removeSmallest());
        assertEquals("Check add and remove", "b", strheap.removeSmallest());
        assertEquals("Check add and remove", "c", strheap.removeSmallest());
        assertEquals("Check add and remove", "d", strheap.removeSmallest());
        assertEquals("Check add and remove", "d", strheap.removeSmallest());
        assertEquals("Check add and remove", "e", strheap.removeSmallest());
        assertEquals("Check add and remove", "f", strheap.removeSmallest());
        assertEquals("Check add and remove", "g", strheap.removeSmallest());
        assertEquals("Check add and remove", "h", strheap.removeSmallest());
        assertEquals("Check size", 0, numheap.size());
    }

    /**
     * Tester to check constructor IllegalArgumentException
     */
    @Test
    public void testConstructorIllegalArgumentException() {
        try {
            numheap = new dHeap<Integer>(0, 10);
            fail("Should have generated an exception");
        } catch (IllegalArgumentException e) {
            // normal
        }
    }

    /**
     * Tester to check add NullPointerException
     */
    @Test
    public void testAddNullPointerException() {
        try {
            numheap.add(null);
            fail("Should have generated an exception");
        } catch (NullPointerException e) {
            // normal
        }
    }

    /**
     * Tester to check remove SmallestNoSuchElementException
     */
    @Test
    public void testRemoveSmallestNoSuchElementException() {
        try {
            strheap.removeSmallest();
            strheap.removeSmallest();
            strheap.removeSmallest();
            strheap.removeSmallest();
            strheap.removeSmallest();
            strheap.removeSmallest();
            fail("Should have generated an exception");
        } catch (NoSuchElementException e) {
            // normal
        }
    }

}
