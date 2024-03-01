package opgave03.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListRingTest {

    private Ring<Integer> ring;

    @BeforeEach
    public void setUp() {
        ring = new ArrayListRing<>();
        ring.add(1);
        ring.add(2);
        ring.add(3);
    }

    @Test
    public void testAdvance() {
        int expected = 3;
        int actual = ring.getCurrentItem();

        assertEquals(3, actual);
        ring.advance();

        expected = 1;
        actual = ring.getCurrentItem();

        assertEquals(expected, actual);
        ring.advance();

        expected = 2;
        actual = ring.getCurrentItem();

        assertEquals(expected, actual);
        ring.advance();

        expected = 3;
        actual = ring.getCurrentItem();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetCurrentItem() {
        int actual = ring.getCurrentItem();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testAdd() {
        ring.add(4);
        int actual = ring.getCurrentItem();
        int expected = 4;
        assertEquals(expected, actual);
        assertEquals(4, ring.size());
    }

    @Test
    public void testRemoveItem() {
        // act
        boolean isTwoRemoved = ring.removeItem(2);
        // assert
        assertTrue(isTwoRemoved);
        assertEquals(2, ring.size());
    }

    @Test
    public void testRemoveCurrentItem() {
        int expected = 3;
        int actual = ring.removeCurrentItem();
        assertEquals(expected, actual);
        assertEquals(2, ring.size());
    }

    @Test
    public void testSize() {
        assertEquals(3, ring.size());
        ring.add(4);
        assertEquals(4, ring.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(ring.isEmpty());
        ring = new ArrayListRing<>();
        assertTrue(ring.isEmpty());
    }

    @Test
    public void testThrowsWhenEmpty() {
        ring = new ArrayListRing<>();
        assertThrows(RuntimeException.class, () -> ring.removeCurrentItem());
    }

    @Test
    public void testMap() {
        Function<Integer, Integer> square = x -> x * x;
        ring.map(square);
        int actual = ring.getCurrentItem();
        assertEquals(9, actual);
        ring.advance();
        actual = ring.getCurrentItem();
        assertEquals(1, actual);
        ring.advance();
        actual = ring.getCurrentItem();
        assertEquals(4, actual);
    }

}
