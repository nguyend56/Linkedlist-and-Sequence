package proj3;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests for LinkedList class' methods
 */
public class LinkedListTests {
    @Test
    public void testConstructor(){
        LinkedList LL = new LinkedList();
        assertEquals("()", LL.toString());
        assertEquals(0, LL.getLength());
    }

    @Test
    public void testInsertAtHeadWithNonEmptyLL(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("bla");
        LL.insertAtHead("ble");
        LL.insertAtHead("blo");
        assertEquals("(blo, ble, bla)", LL.toString());
    }

    @Test
    public void testInsertAtHeadWithEmptyLL(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("19");
        assertEquals("(19)", LL.toString());
    }

    @Test
    public void testGetLengthWithNonEmptyLL(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("bla");
        LL.insertAtHead("ble");
        LL.insertAtHead("blo");
        assertEquals(3, LL.getLength());
    }

    @Test
    public void testGetLengthWithEmptyLL(){
        LinkedList LL = new LinkedList();
        assertEquals(0, LL.getLength());
    }

    @Test
    public void testDeleteElementAtIndexNonEmptyLLInvalidIndex(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("blo");
        LL.insertAtHead("bla");
        String a = LL.deleteElementAtIndex(-1);
        String b = LL.deleteElementAtIndex(3);
        assertEquals(2, LL.getLength());
        assertEquals("(bla, blo)", LL.toString());
        assertNull(a);
        assertNull(b);
    }

    @Test
    public void testDeleteElementAtIndexWithEmptyLL(){
        LinkedList LL = new LinkedList();
        String a = LL.deleteElementAtIndex(0);
        String b = LL.deleteElementAtIndex(-1);
        String c = LL.deleteElementAtIndex(1);

        assertEquals(0, LL.getLength());
        assertEquals("()", LL.toString());
        assertNull(a);
        assertNull(b);
        assertNull(c);
    }

    @Test
    public void testDeleteElementAtIndexFirstElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("bla");
        LL.insertAtHead("ble");
        LL.insertAtHead("blo");
        String s = LL.deleteElementAtIndex(0);
        String s2 = LL.deleteElementAtIndex(0);

        assertEquals(1, LL.getLength());
        assertEquals("(bla)", LL.toString());
        assertEquals("blo", s);
        assertEquals("ble", s2);
    }

    @Test
    public void testDeleteElementAtIndexLastElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");
        String s = LL.deleteElementAtIndex(2);

        assertEquals(2, LL.getLength());
        assertEquals("(c, b)", LL.toString());
        assertEquals("a", s);
    }

    @Test
    public void testDeleteElementAtIndexMiddleElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");
        String s = LL.deleteElementAtIndex(1);

        assertEquals(2, LL.getLength());
        assertEquals("(c, a)", LL.toString());
        assertEquals("b", s);
    }

    @Test
    public void testGetElementAtIndexEmptyLL(){
        LinkedList LL = new LinkedList();
        assertNull(LL.getElementAtIndex(0));
        assertNull(LL.getElementAtIndex(-1));
        assertNull(LL.getElementAtIndex(1));
        assertEquals(0, LL.getLength());
        assertEquals("()", LL.toString());
    }

    @Test
    public void testGetElementAtIndexNonEmptyLLInvalidIndex(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");
        assertNull(LL.getElementAtIndex(-1));
        assertNull(LL.getElementAtIndex(3));
        assertEquals(3, LL.getLength());
        assertEquals("(c, b, a)", LL.toString());
    }

    @Test
    public void testGetElementAtIndexFirstElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");
        assertEquals("c", LL.getElementAtIndex(0));
        assertEquals(3, LL.getLength());
        assertEquals("(c, b, a)", LL.toString());
    }

    @Test
    public void testGetElementAtIndexLastElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("b");
        LL.insertAtHead("a");
        LL.insertAtHead("c");
        assertEquals("b", LL.getElementAtIndex(2));
        assertEquals(3, LL.getLength());
        assertEquals("(c, a, b)", LL.toString());
    }

    @Test
    public void testGetElementAtIndexMiddleElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");
        assertEquals("b", LL.getElementAtIndex(1));
        assertEquals(3, LL.getLength());
        assertEquals("(c, b, a)", LL.toString());
    }

    @Test
    public void testClearEmptyLL(){
        LinkedList LL = new LinkedList();
        LL.clear();
        assertEquals(0, LL.getLength());
        assertEquals("()", LL.toString());
    }

    @Test
    public void testClearNonEmptyLL(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");
        assertEquals(3, LL.getLength());
        assertEquals("(c, b, a)", LL.toString());
        LL.clear();
        assertEquals(0, LL.getLength());
        assertEquals("()", LL.toString());
    }

    @Test
    public void testInsertElementAtIndexInvalidIndex(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");

        LL.insertElementAtIndex(-1,"-1");
        LL.insertElementAtIndex(4,"4");

        assertEquals(3, LL.getLength());
        assertEquals("(c, b, a)", LL.toString());
    }

    @Test
    public void testInsertElementAtIndexFirstElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");

        LL.insertElementAtIndex(0,"d");

        assertEquals(4, LL.getLength());
        assertEquals("(d, c, b, a)", LL.toString());
    }

    @Test
    public void testInsertElementAtIndexLastElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("c");
        LL.insertAtHead("a");
        LL.insertAtHead("b");

        LL.insertElementAtIndex(2,"d");
        LL.insertElementAtIndex(4,"e");

        assertEquals(5, LL.getLength());
        assertEquals("(b, a, d, c, e)", LL.toString());
    }

    @Test
    public void testInsertElementAtIndexMiddleElement(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("a");
        LL.insertAtHead("b");
        LL.insertAtHead("c");

        LL.insertElementAtIndex(1,"1");
        LL.insertElementAtIndex(3,"3");

        assertEquals(5, LL.getLength());
        assertEquals("(c, 1, b, 3, a)", LL.toString());
    }

    @Test
    public void testInsertElementAtIndexEmptyLL(){
        LinkedList LL = new LinkedList();

        LL.insertElementAtIndex(0,"0");
        LL.insertElementAtIndex(0,"2");
        LL.insertElementAtIndex(0,"1");

        assertEquals(3, LL.getLength());
        assertEquals("(1, 2, 0)", LL.toString());
    }

    @Test
    public void testCloneLinkedListEmptyLL(){
        LinkedList LL = new LinkedList();
        LinkedList cloneLL = LL.cloneLinkedList();

        LL.insertAtHead("2");
        LL.insertAtHead("1");
        LL.insertAtHead("0");

        assertEquals(3, LL.getLength());
        assertEquals("(0, 1, 2)", LL.toString());
        assertEquals(0, cloneLL.getLength());
        assertEquals("()", cloneLL.toString());
    }

    @Test
    public void testCloneLinkedListNonEmptyLL(){
        LinkedList LL = new LinkedList();
        LL.insertAtHead("2");
        LL.insertAtHead("1");
        LL.insertAtHead("0");
        LinkedList cloneLL = LL.cloneLinkedList();

        assertEquals(3, cloneLL.getLength());
        assertEquals("(0, 1, 2)", cloneLL.toString());

        LL.insertAtHead("-1");
        LL.insertAtHead("-2");

        cloneLL.insertAtHead("-3");


        assertEquals(5, LL.getLength());
        assertEquals("(-2, -1, 0, 1, 2)", LL.toString());
        assertEquals(4, cloneLL.getLength());
        assertEquals("(-3, 0, 1, 2)", cloneLL.toString());
    }

    @Test
    public void testToStringEmptyLL(){
        LinkedList LL = new LinkedList();

        assertEquals("()", LL.toString());
    }

    @Test
    public void testToStringNonEmptyLL(){
        LinkedList LL = new LinkedList();

        LL.insertElementAtIndex(0,"0");
        LL.insertElementAtIndex(1,"2");
        LL.insertElementAtIndex(1,"1");

        assertEquals("(0, 1, 2)", LL.toString());
    }

    @Test
    public void testIsEmpty(){
        LinkedList LL = new LinkedList();
        assertTrue(LL.isEmpty());
        assertEquals("()", LL.toString());

        LL.insertElementAtIndex(0,"0");
        assertFalse(LL.isEmpty());
        assertEquals("(0)", LL.toString());
    }

    @Test
    public void testEqualsTrue2string(){
        LinkedList L1 = new LinkedList();
        LinkedList L2 = new LinkedList();

        L1.insertAtHead("2");
        L1.insertAtHead("1");
        L1.insertAtHead("0");

        L2.insertElementAtIndex(0,"0");
        L2.insertElementAtIndex(1,"2");
        L2.insertElementAtIndex(1,"1");

        assertTrue(L1.equals(L2));
        assertTrue(L2.equals(L1));

        L1.deleteElementAtIndex(2);
        L2.deleteElementAtIndex(2);

        assertTrue(L1.equals(L2));
        assertTrue(L2.equals(L1));
    }

    @Test
    public void testEqualsFalse2string(){
        LinkedList L1 = new LinkedList();
        LinkedList L2 = new LinkedList();

        L1.insertAtHead("2");
        L1.insertAtHead("1");
        L1.insertAtHead("0");

        L2.insertElementAtIndex(0,"0");
        L2.insertElementAtIndex(1,"1");
        L2.insertElementAtIndex(1,"2");

        assertFalse(L1.equals(L2));
        assertFalse(L2.equals(L1));

        L1.deleteElementAtIndex(2);
        L2.deleteElementAtIndex(1);

        assertTrue(L1.equals(L2));
        assertTrue(L2.equals(L1));
    }

    @Test
    public void testEquals2EmptyString(){
        LinkedList L1 = new LinkedList();
        LinkedList L2 = new LinkedList();

        assertTrue(L1.equals(L2));
        assertTrue(L2.equals(L1));
    }

    @Test
    public void testEquals2CloneString(){
        LinkedList L1 = new LinkedList();
        L1.insertAtHead("2");
        L1.insertAtHead("1");
        L1.insertAtHead("0");
        LinkedList L2 = L1.cloneLinkedList();

        assertTrue(L1.equals(L2));
        assertTrue(L2.equals(L1));
    }



    @Test
    public void testInsertLinkedListToEnd2EmptyLL(){
        LinkedList LL1 = new LinkedList();
        LinkedList LL2 = new LinkedList();

        LL1.insertLinkedListToEnd(LL2);

        assertEquals("()", LL1.toString());
        assertEquals(0, LL1.getLength());
        assertEquals("()", LL2.toString());
        assertEquals(0, LL2.getLength());

        LL1.insertAtHead("1");
        LL1.insertAtHead("0");
        LL2.insertAtHead("3");

        assertEquals("(0, 1)", LL1.toString());
        assertEquals(2, LL1.getLength());
        assertEquals("(3)", LL2.toString());
        assertEquals(1, LL2.getLength());
    }

    @Test
    public void testInsertLinkedListToEndNonEmptyVsNonEmpty(){
        LinkedList LL1 = new LinkedList();
        LinkedList LL2 = new LinkedList();

        LL1.insertAtHead("2");
        LL1.insertAtHead("1");
        LL1.insertAtHead("0");

        LL2.insertAtHead("4");
        LL2.insertAtHead("3");

        LL1.insertLinkedListToEnd(LL2);

        assertEquals("(0, 1, 2, 3, 4)", LL1.toString());
        assertEquals(5, LL1.getLength());
        assertEquals("(3, 4)", LL2.toString());
        assertEquals(2, LL2.getLength());

        LL1.deleteElementAtIndex(4);
        LL1.deleteElementAtIndex(3);
        LL2.insertAtHead("2");

        assertEquals("(0, 1, 2)", LL1.toString());
        assertEquals(3, LL1.getLength());
        assertEquals("(2, 3, 4)", LL2.toString());
        assertEquals(3, LL2.getLength());
    }

    @Test
    public void testInsertLinkedListToEndEmptyVsNonEmpty(){
        LinkedList LL1 = new LinkedList();
        LinkedList LL2 = new LinkedList();

        LL2.insertAtHead("1");
        LL2.insertAtHead("0");

        LL1.insertLinkedListToEnd(LL2);

        assertEquals("(0, 1)", LL1.toString());
        assertEquals(2, LL1.getLength());
        assertEquals("(0, 1)", LL2.toString());
        assertEquals(2, LL2.getLength());

        LL1.insertAtHead("1");
        LL1.insertAtHead("0");
        LL2.insertAtHead("3");

        assertEquals("(0, 1, 0, 1)", LL1.toString());
        assertEquals(4, LL1.getLength());
        assertEquals("(3, 0, 1)", LL2.toString());
        assertEquals(3, LL2.getLength());
    }

    @Test
    public void testInsertLinkedListToEndNonEmptyVsEmpty(){
        LinkedList LL1 = new LinkedList();
        LinkedList LL2 = new LinkedList();

        LL1.insertAtHead("1");
        LL1.insertAtHead("0");

        LL1.insertLinkedListToEnd(LL2);

        assertEquals("(0, 1)", LL1.toString());
        assertEquals(2, LL1.getLength());
        assertEquals("()", LL2.toString());
        assertEquals(0, LL2.getLength());

        LL1.insertAtHead("1");
        LL1.insertAtHead("0");
        LL2.insertAtHead("3");

        assertEquals("(0, 1, 0, 1)", LL1.toString());
        assertEquals(4, LL1.getLength());
        assertEquals("(3)", LL2.toString());
        assertEquals(1, LL2.getLength());
    }
}
