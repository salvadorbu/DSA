package DataStructures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> list;

    @Before
    public void setup() {
        list = new DoublyLinkedList<>();
    }

    @Test
    public void testInsert() {
        list.insert(9);
        list.insert(14);
        list.insert(7);

        assertEquals(3, list.getSize());

        assertEquals(Integer.valueOf(7), list.getHead().data);
        assertEquals(Integer.valueOf(9), list.getTail().data);
        assertEquals(Integer.valueOf(14), list.getHead().next.data);
        assertEquals(Integer.valueOf(14), list.getTail().prev.data);

        assertNull(list.getHead().prev);
        assertNull(list.getTail().next);
    }

    @Test
    public void testAppend() {
        list.append(8);
        list.append(11);
        list.append(145);
        list.append(145);

        assertEquals(4, list.getSize());

        assertEquals(Integer.valueOf(8), list.getHead().data);
        assertEquals(Integer.valueOf(11), list.getHead().next.data);
        assertEquals(Integer.valueOf(145), list.getTail().data);

        assertNull(list.getHead().prev);
        assertNull(list.getTail().next);
    }

    @Test
    public void testRemoveByIndex() {
        list.insert(9);
        list.insert(14);
        list.insert(7);
        list.insert(11);

        list.remove(1);

        assertEquals(3, list.getSize());
        assertEquals(Integer.valueOf(14), list.remove(1));
        assertEquals(Integer.valueOf(11), list.remove(0));
    }
}
