package proj3;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests for Sequence class' methods
 *
 * SequenceTest collaborator: Minh Pham
 */
public class SequenceTest{

    @Test   // Sequence with default initial capacity = 10
    public void testConstructDefault(){
        Sequence seq = new Sequence();
        assertEquals(0, seq.size());
        assertFalse(seq.isCurrent());
        assertEquals(10, seq.getCapacity());
        assertEquals("{} (capacity = 10)", seq.toString());
    }

    @Test   // Sequence with given initial capacity
    public void testConstructGivenCapacity(){
        Sequence seq = new Sequence(50);
        assertEquals(0, seq.size());
        assertFalse(seq.isCurrent());
        assertEquals(50, seq.getCapacity());
        assertEquals("{} (capacity = 50)", seq.toString());
    }

    @Test
    public void testGetCapacity(){
        Sequence seq = new Sequence(24);
        assertEquals(24, seq.getCapacity());
    }

    @Test
    public void testAddBeforeEmptySequence(){
        Sequence seq = new Sequence();
        seq.addBefore("first");
        assertEquals("{>first} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddBeforeNonEmptySequence(){
        Sequence seq = new Sequence();
        seq.addBefore("first");
        seq.addBefore("second");
        seq.addBefore("third");
        assertEquals("{>third, second, first} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddBeforeLastElement(){
        Sequence seq = new Sequence();
        seq.addBefore("first");
        seq.addBefore("second");
        seq.advance();
        seq.addBefore("third");
        assertEquals("{second, >third, first} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddBeforeNoCurrentElement(){
        Sequence seq = new Sequence();
        seq.addBefore("first");
        seq.addBefore("second");
        seq.advance();
        seq.advance();
        seq.addBefore("third");
        assertEquals("{>third, second, first} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddBeforeMaxCapacity(){
        Sequence seq = new Sequence(2);
        seq.addBefore("first");
        seq.addBefore("second");
        seq.addBefore("third");
        seq.addBefore("fourth");
        assertEquals("{>fourth, third, second, first} (capacity = 5)", seq.toString());
    }

    @Test
    public void testAddAfterEmptySequence(){
        Sequence seq = new Sequence();
        seq.addAfter("first");
        assertEquals("{>first} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddAfterFirstElement(){
        Sequence seq = new Sequence();
        seq.addAfter("first");
        seq.addAfter("second");
        seq.start();
        seq.addAfter("third");
        assertEquals("{first, >third, second} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddAfterNonEmptySequence(){
        Sequence seq = new Sequence();
        seq.addAfter("first");
        seq.addAfter("second");
        seq.addAfter("third");
        assertEquals("{first, second, >third} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddAfterNoCurrentElement(){
        Sequence seq = new Sequence();
        seq.addAfter("first");
        seq.addAfter("second");
        seq.advance();
        seq.addAfter("third");
        assertEquals("{first, second, >third} (capacity = 10)", seq.toString());
    }

    @Test
    public void testAddAfterMaxCapacity(){
        Sequence seq = new Sequence(2);
        seq.addAfter("first");
        seq.addAfter("second");
        seq.addAfter("third");
        seq.addAfter("fourth");
        assertEquals("{first, second, third, >fourth} (capacity = 5)", seq.toString());
    }

    @Test
    public void testIsCurrentEmptySequence(){
        Sequence seq = new Sequence(2);
        assertFalse(seq.isCurrent());
    }

    @Test
    public void testIsCurrentAdvanceToEnd(){
        Sequence seq = new Sequence();
        seq.addAfter("first");
        seq.addAfter("second");
        seq.advance();
        assertFalse(seq.isCurrent());
    }

    @Test
    public void testGetCurrentValid(){
        Sequence seq = new Sequence();
        seq.addAfter("first");
        seq.addAfter("second");
        assertEquals("second", seq.getCurrent());
    }

    @Test
    public void testGetCurrentInvalid(){
        Sequence seq = new Sequence();
        seq.addAfter("first");
        seq.addAfter("second");
        seq.advance();
        assertNull(seq.getCurrent());
    }

    @Test
    public void testEnsureCapacityToSmallerCapacity(){
        Sequence seq = new Sequence(50);
        seq.ensureCapacity(10);
        assertEquals(50, seq.getCapacity());
    }

    @Test
    public void testEnsureCapacityToLargerCapacity(){
        Sequence seq = new Sequence();
        seq.ensureCapacity(50);
        assertEquals(50, seq.getCapacity());
    }

    @Test
    public void testAddAllEmptyWithEmpty(){
        Sequence seq1 = new Sequence();
        Sequence seq2 = new Sequence();
        seq1.addAll(seq2);
        assertEquals("{} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testAddAllNormalWithNormal(){
        Sequence seq1 = new Sequence();
        Sequence seq2 = new Sequence();
        seq1.addAfter("first");
        seq2.addAfter("second");
        seq1.addAll(seq2);
        assertEquals("{>first, second} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testAddAllNormalWithEmpty(){
        Sequence seq1 = new Sequence();
        Sequence seq2 = new Sequence();
        seq1.addAfter("first");
        seq1.addAfter("second");
        seq1.addAll(seq2);
        assertEquals("{first, >second} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testAddAllNormalNoCurrentWithNormalCurrent(){
        Sequence seq1 = new Sequence();
        Sequence seq2 = new Sequence();
        seq1.addAfter("first");
        seq1.addAfter("second");
        seq1.advance();
        seq2.addAfter("three");
        seq2.addAfter("four");
        seq1.addAll(seq2);
        assertEquals("{first, second, three, four} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testAdvanceValid(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("first");
        seq1.addBefore("second");
        seq1.advance();
        assertEquals("{second, >first} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testAdvanceInvalid(){
        Sequence seq1 = new Sequence();
        seq1.addBefore("first");
        seq1.addBefore("second");
        seq1.advance();
        seq1.advance();
        assertEquals("{second, first} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testCloneNormal(){
        Sequence seq1 = new Sequence();
        seq1.addBefore("first");
        seq1.addBefore("second");
        Sequence seq2 = seq1.clone();
        assertEquals("{>second, first} (capacity = 10)", seq2.toString());
    }

    @Test
    public void testCloneDoesNotChangeOriginal(){
        Sequence seq1 = new Sequence();
        seq1.addBefore("first");
        seq1.addBefore("second");
        Sequence seq2 = seq1.clone();
        seq2.removeCurrent();
        assertEquals("{>first} (capacity = 10)", seq2.toString());
        assertEquals("{>second, first} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testRemoveCurrentNormal(){
        Sequence seq1 = new Sequence();
        seq1.addBefore("first");
        seq1.addBefore("second");
        seq1.removeCurrent();
        assertEquals("{>first} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testRemoveCurrentNoCurrentElement(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("first");
        seq1.addAfter("second");
        seq1.advance();
        seq1.removeCurrent();
        assertEquals("{first, second} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testRemoveCurrentLastElement(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("first");
        seq1.addAfter("second");
        seq1.removeCurrent();
        assertEquals("{first} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testSizeEmpty(){
        Sequence seq1 = new Sequence();
        assertEquals(0, seq1.size());
    }

    @Test
    public void testSizeNormal(){
        Sequence seq1 = new Sequence();
        seq1.addBefore("1");
        seq1.addBefore("2");
        assertEquals(2, seq1.size());
    }

    @Test
    public void testStartEmpty(){
        Sequence seq1 = new Sequence();
        seq1.start();
        assertFalse(seq1.isCurrent());
    }

    @Test
    public void testStartNormal(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("1");
        seq1.addAfter("2");
        seq1.start();
        assertEquals("{>1, 2} (capacity = 10)", seq1.toString());
    }

    @Test
    public void testTrimToSizeNormal(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("1");
        seq1.addAfter("2");
        seq1.trimToSize();
        assertEquals(2, seq1.getCapacity());
    }

    @Test
    public void testTrimToSizeWithSizeEqualsCapacity(){
        Sequence seq1 = new Sequence(2);
        seq1.addAfter("1");
        seq1.addAfter("2");
        seq1.trimToSize();
        assertEquals(2, seq1.getCapacity());
    }

    @Test
    public void testToString(){
        Sequence seq1 = new Sequence(2);
        seq1.addAfter("1");
        seq1.addAfter("2");
        seq1.trimToSize();
        assertEquals("{1, >2} (capacity = 2)", seq1.toString());
    }

    @Test
    public void testEqualsSameCapacity(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("1");
        seq1.addAfter("2");
        Sequence seq2 = seq1.clone();
        assertTrue(seq1.equals(seq2));
        assertTrue(seq2.equals(seq1));
    }

    @Test
    public void testEqualsDifferentCapacity(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("1");
        seq1.addAfter("2");
        Sequence seq2 = new Sequence(15);
        seq2.addAfter("1");
        seq2.addAfter("2");
        assertTrue(seq1.equals(seq2));
        assertTrue(seq2.equals(seq1));
    }

    @Test
    public void testEqualsDifferentSize(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("1");
        seq1.addAfter("2");
        seq1.addAfter("3");
        Sequence seq2 = new Sequence(15);
        seq2.addAfter("1");
        seq2.addAfter("2");
        assertFalse(seq1.equals(seq2));
        assertFalse(seq2.equals(seq1));
    }

    @Test
    public void testEqualsSameElementDifferentCurrent(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("1");
        seq1.addAfter("2");
        seq1.addAfter("3");
        Sequence seq2 = new Sequence();
        seq2.addAfter("1");
        seq2.addAfter("3");
        seq2.addBefore("2");
        assertFalse(seq1.equals(seq2));
        assertFalse(seq2.equals(seq1));
        assertEquals("{1, 2, >3} (capacity = 10)", seq1.toString());
        assertEquals("{1, >2, 3} (capacity = 10)", seq2.toString());
    }

    @Test
    public void isEmptyFalse(){
        Sequence seq1 = new Sequence(2);
        seq1.addAfter("1");
        assertFalse(seq1.isEmpty());
    }

    @Test
    public void isEmptyTrue(){
        Sequence seq1 = new Sequence(2);
        seq1.addAfter("1");
        seq1.removeCurrent();
        assertTrue(seq1.isEmpty());
    }

    @Test
    public void clearNonEmpty(){
        Sequence seq1 = new Sequence();
        seq1.addAfter("1");
        seq1.addAfter("2");
        seq1.clear();
        assertEquals("{} (capacity = 10)", seq1.toString());
    }

    @Test
    public void clearEmpty(){
        Sequence seq1 = new Sequence();
        seq1.clear();
        assertEquals("{} (capacity = 10)", seq1.toString());
    }
}
