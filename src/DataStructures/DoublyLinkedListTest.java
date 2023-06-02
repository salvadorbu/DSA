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

        assertNull(list.getHead().prev);
        assertNull(list.getTail().next);
    }
}
