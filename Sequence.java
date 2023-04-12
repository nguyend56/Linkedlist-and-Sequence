package proj3;  // Gradescope needs this.

/**
 * Model a Sequence, which is a container storing objects of similar type. Accessing via an element called current
 * which is movable using methods. The sequence capacity to facilitate adding or removing elements.
 *
 * Invariant:
 *
 * 1. Linked List contents: The items of the sequence are stored in the contents of the instance
 * variable, which is a Linked List, and the length of this LinkedList is also the number of items in the LinkedList.
 * On the other hand, an empty LinkedList has no items and has length equals 0. The LinkedList changes its items
 * (insert or delete), adjusts its length when there is any changes made in the sequence.
 *
 * 2. int capacity: The instance variable representing the maximum items of the Sequence
 *
 * 3. int currentIndex: The instance variable representing the index of the current item. If the Sequence is empty,
 * currentIndex is set to equal the number of items in Sequence.
 */
public class Sequence
{
	private LinkedList contents;
    private int capacity;
    private int currentIndex;

    private final int DEFAULT_CAPACITY = 10;
	
    /**
     * Creates a new sequence with initial capacity 10.
     */
    public Sequence() { // reuse size()
        contents = new LinkedList();
        capacity = DEFAULT_CAPACITY;
        currentIndex = size();
    }
    

    /**
     * Creates a new sequence.
     * 
     * @param initialCapacity the initial capacity of the sequence.
     */
    public Sequence(int initialCapacity){ // reuse size()
        if (initialCapacity < 0)
            throw new IllegalArgumentException("initialCapacity is negative: " + initialCapacity);
        contents = new LinkedList();
        capacity = initialCapacity;
        currentIndex = size();
    }
    

    /**
     * Adds a string to the sequence in the location before the
     * current element. If the sequence has no current element, the
     * string is added to the beginning of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addBefore(String value)
    {   // reuse isCurrent(), insertValueToGivenIndex(), getCurrentIndex()
        if (isCurrent()){
            insertValueToGivenIndex(getCurrentIndex(),value);
        }
        else {
            insertValueToGivenIndex(0, value);
        }
    }
    
    
    /**
     * Adds a string to the sequence in the location after the current
     * element. If the sequence has no current element, the string is
     * added to the end of the sequence.
     *
     * The added element becomes the current element.
     *
     * If the sequences's capacity has been reached, the sequence will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addAfter(String value)
    {   // reuse isCurrent(), insertValueToGivenIndex(), getCurrentIndex()
        if (isCurrent()){
            insertValueToGivenIndex(getCurrentIndex()+1,value);
        }
        else {
            insertValueToGivenIndex(size(), value);
        }
    }

    
    /**
     * @return true if and only if the sequence has a current element.
     */
    public boolean isCurrent()
    {   // reuse getCurrentIndex(), size()
        return ((0 <= getCurrentIndex()) && (getCurrentIndex() < size()));
    }
    
    
    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()
    {
        return capacity;
    }

    
    /**
     * @return the element at the current location in the sequence, or
     * null if there is no current element.
     */
    public String getCurrent()
    {   // reuse isCurrent(), getContents()
        if (isCurrent()){
            return getContents().getElementAtIndex(getCurrentIndex());
        } else {
            return null;
        }
    }
    
    
    /**
     * Increase the sequence's capacity to be
     * at least minCapacity.  Does nothing
     * if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {   // reuse getCapacity(), setCapacity()
        if (getCapacity() < minCapacity){
            setCapacity(minCapacity);
        }
    }

    
    /**
     * Places the contents of another sequence at the end of this sequence.
     *
     * If adding all elements of the other sequence would exceed the
     * capacity of this sequence, the capacity is changed to make (just enough) room for
     * all of the elements to be added.
     * 
     * Postcondition: NO SIDE EFFECTS!  the other sequence should be left
     * unchanged.  The current element of both sequences should remain
     * where they are. (When this method ends, the current element
     * should refer to the same element that it did at the time this method
     * started.)
     *
     * @param another the sequence whose contents should be added.
     */
    public void addAll(Sequence another)
    {   // reuse isCurrent(), ensureCapacity(), size(), deleteCurrentIndex()
        this.ensureCapacity(this.size()+another.size());
        if (!this.isCurrent()){
            this.contents.insertLinkedListToEnd(another.contents.cloneLinkedList());
            deleteCurrentIndex();
        }
        else {
            this.contents.insertLinkedListToEnd(another.contents.cloneLinkedList());
        }
    }

    
    /**
     * Move forward in the sequence so that the current element is now
     * the next element in the sequence.
     *
     * If the current element was already the end of the sequence,
     * then advancing causes there to be no current element.
     *
     * If there is no current element to begin with, do nothing.
     */
    public void advance()
    {   // reuse isCurrent(), size(), deleteCurrentIndex(), getCurrentIndex(), setCurrentIndex()
        if (isCurrent()) {
            if (getCurrentIndex() == size() -1){
                deleteCurrentIndex();
            } else {
                setCurrentIndex(getCurrentIndex() + 1);
            }
        }
    }

    
    /**
     * Make a copy of this sequence.  Subsequence changes to the copy
     * do not affect the current sequence, and vice versa.
     * 
     * Post-condition: NO SIDE EFFECTS!  This sequence's current
     * element should remain unchanged.  The clone's current
     * element will correspond to the same place as in the original.
     *
     * @return the copy of this sequence.
     */
    public Sequence clone()
    {   //reuse getCapacity(), getContents(), setCurrentIndex(), getCurrentIndex()
        Sequence newSeq = new Sequence(this.getCapacity());
        newSeq.contents = this.contents.cloneLinkedList();
        newSeq.setCurrentIndex(this.getCurrentIndex());

        return newSeq;
    }
   
    
    /**
     * Remove the current element from this sequence. The following
     * element, if there was one, becomes the current element.  If
     * there was no following element (current was at the end of the
     * sequence), the sequence now has no current element.
     *
     * If there is no current element, does nothing.
     */
    public void removeCurrent()
    {   // reuse isCurrent(), getCurrentIndex(), size(), getContents(), deleteCurrentIndex()
        if(isCurrent()) {
            if (getCurrentIndex() == size() - 1) {
                getContents().deleteElementAtIndex(getCurrentIndex());
                deleteCurrentIndex();
            }
            else {
                getContents().deleteElementAtIndex(getCurrentIndex());
            }
        }
    }

    
    /**
     * @return the number of elements stored in the sequence.
     */
    public int size()
    {   // reuse getContents
        return getContents().getLength();
    }

    
    /**
     * Sets the current element to the start of the sequence.  If the
     * sequence is empty, the sequence has no current element.
     */
    public void start()
    {
        if (size() > 0){
            setCurrentIndex(0);
        }
        else{
            deleteCurrentIndex();
        }
    }

    
    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize()
    {   // reuse setCapacity(), size()
        setCapacity(size());
    }
    
    
    /**
     * Produce a string representation of this sequence.  The current
     * location is indicated by a >.  For example, a sequence with "A"
     * followed by "B", where "B" is the current element, and the
     * capacity is 5, would print as:
     * 
     *    {A, >B} (capacity = 5)
     * 
     * The string you create should be formatted like the above example,
     * with a comma following each element, no comma following the
     * last element, and all on a single line.  An empty sequence
     * should give back "{}" followed by its capacity.
     * 
     * @return a string representation of this sequence.
     */
    public String toString() 
    {   // reuse isCurrent(), size(), getCurrentIndex(), getContents()
        String toReturn = "{";
        for(int i = 0; i < size(); i++){
            if (isCurrent()){
                if (i == getCurrentIndex()){
                    toReturn = toReturn + ">";
                }
            }
            if (i == size()-1){
                toReturn = toReturn + getContents().getElementAtIndex(i);
            }
            else{
                toReturn = toReturn + getContents().getElementAtIndex(i) + ", ";
            }
        }
        toReturn = toReturn + "}" + " (capacity = " + getCapacity() +")";
        return toReturn;
    }
    
    /**
     * Checks whether another sequence is equal to this one.  To be
     * considered equal, the other sequence must have the same size
     * as this sequence, have the same elements, in the same
     * order, and with the same element marked
     * current.  The capacity can differ.
     * 
     * Postcondition: NO SIDE EFFECTS!  this sequence and the
     * other sequence should remain unchanged, including the
     * current element.
     * 
     * @param other the other Sequence with which to compare
     * @return true iff the other sequence is equal to this one.
     */
    public boolean equals(Sequence other) // reuse size, isCurrent, getCurrentIndex
    {
        return ((this.size() == other.size()) && (this.isCurrent() == other.isCurrent()) &&
                (this.getCurrentIndex() == other.getCurrentIndex()) && (this.contents.equals(other.contents)));
    }
    
    
    /**
     * 
     * @return true if Sequence empty, else false
     */
    public boolean isEmpty()
    {
        return (size() == 0);
    }
    
    
    /**
     *  empty the sequence.  There should be no current element.
     */
    public void clear()
    {
        getContents().clear();
        deleteCurrentIndex();
    }


// ---------------------------------------------------------------------------------------------------------------------
// private methods

    /**
     * Getter of currentIndex
     * @return integer currentIndex
     */
    private int getCurrentIndex(){
        return currentIndex;
    }

    /**
     * Setter of currentIndex
     */
    private void setCurrentIndex(int newCurrentIndex){
        currentIndex = newCurrentIndex;
    }

    /**
     * Getter for contents
     * @return LinkedList contents
     */
    private LinkedList getContents(){
        return contents;
    }

    /**
     * remove the currentIndex, set it equals to size()
     */
    private void deleteCurrentIndex(){
        setCurrentIndex(size());
    }

    /**
     * Setter for capacity
     * @param newCapacity the update capacity
     */
    private void setCapacity(int newCapacity){
        capacity = newCapacity;
    }

    /**
     * helper method for addBefore and addAfter, inserting item at the given index of the sequence, moving
     * all items after that index to the right. The given item becomes the current item. Do nothing if the
     * index is not valid
     *
     * Pre-condition: 0<=index<=last item's index + 1
     *
     * expand the sequence twice and plus 1 when the capacity is reached
     *
     * @param data the string to add.
     */
    private void insertValueToGivenIndex(int index, String data){
        if ((0 <= index) && (index <= size())) {
            if (size() == getCapacity()) {
                ensureCapacity(getCapacity() * 2 + 1);
            }
            getContents().insertElementAtIndex(index, data);
            setCurrentIndex(index);
        }
    }
}