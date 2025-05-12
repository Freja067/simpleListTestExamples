
package ut.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleListTest {

    @Test
    void testAddOneElement() {
        SimpleList<String> list = new SimpleList<>();
        list.add("Hello");
        assertEquals(1, list.size());
        assertEquals("Hello", list.get(0));
    }

    @Test
    void testAddNullElement() {
        SimpleList<String> list = new SimpleList<>();
        list.add(null);
        assertEquals(1, list.size());
        assertNull(list.get(0));
    }



    @Test
    void testGetFirstElement() {
        SimpleList<String> list = new SimpleList<>();
        list.add("Hello");
        assertEquals("Hello", list.get(0));
    }

    @Test
    void testGetElementOnEmptyList() {
        SimpleList<String> list = new SimpleList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testRemoveOneElement() {
        SimpleList<String> list = new SimpleList<>();
        list.add("Hello");
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveFromEmptyList() {
        SimpleList<String> list = new SimpleList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testSize() {
        SimpleList<String> list = new SimpleList<>();
        assertEquals(0, list.size());
        list.add("Hello");
        assertEquals(1, list.size());
    }

    @Test
    void testClear() {
        SimpleList<String> list = new SimpleList<>();
        list.add("Hello");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void testResize() {
        SimpleList<String> list = new SimpleList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Element " + i);
        }
        assertEquals(20, list.size());
        for (int i = 0; i < 20; i++) {
            assertEquals("Element " + i, list.get(i));
        }
    }
}
