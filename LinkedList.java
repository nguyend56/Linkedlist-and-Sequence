package proj3;

/**
 * The linked list class gives you access to the beginning of a linked
 * list through a private instance variable called firstNode. This class
 * should contain all of the methods for general manipulation of linked lists:
 * traversal, insertion, deletion, etc.
 */              
public class LinkedList
{
    private int length;
    private ListNode firstNode;

    /**
     * Default-constructor
     */
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /**
     * return number of elements in LinkedList
     * @return length as an integer
     */
    public int getLength()
    {
        return length;
    }


    /**
     * insert data at the beginning of the LinkedList
     * @param data the String data inserted
     */
    public void insertAtHead(String data)
    {
    	ListNode newnode = new ListNode(data);
        if (getLength() == 0)
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }


    /**
     * Returns LL as a printable String
     * @return String toReturn as a String represent the LinkedList
     */
	public String toString(){ 
		String toReturn = "(";
		ListNode runner = firstNode;
		while(runner != null){
			toReturn = toReturn + runner;
			runner = runner.next;
			if(runner != null){
				toReturn = toReturn + ", ";
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}


    /**
     * @return true if LL empty or false if not
     */
    public boolean isEmpty() {return getLength()==0;}


    /**
     * return the String data of element at the given index
     * @param index the given integer index
     * @return return the String value at given index.return null if index is invalid
     */
    public String getElementAtIndex(int index){
        if (index < 0 || index >= getLength()) {
            return null;
        } else {
            return getIthNode(index).data;
        }
    }


    /**
     * clear the LinkedList. The new LinkedList has no elements
     */
    public void clear(){
        firstNode = null;
        length = 0;
    }


    /**
     * delete the element at given index, return the element if index is valid
     * @param index given integer index
     * @return String value at index deleted. return null if index is invalid
     */
    public String deleteElementAtIndex(int index){
        if (index < 0 || index >= getLength()) {
            return null;
        }
        else{
            String theString;
            if (index == 0){
                theString = firstNode.data;
                firstNode = firstNode.next;
            }
            else{
                ListNode nodeBefore = getIthNode(index-1);
                theString = nodeBefore.next.data;
                nodeBefore.next = nodeBefore.next.next;
            }
            length--;
            return theString;
        }
    }


    /**
     * insert given element at the given index in the LinkedList if the index is valid
     * @param index given integer index
     * @param data String value inserted at given index
     */
    public void insertElementAtIndex(int index, String data){
        if((0 <= index) && (index <= getLength())){
            ListNode theNode = new ListNode(data);
            if(index == 0){
                theNode.next = firstNode;
                firstNode = theNode;
            }
            else{
                ListNode previousNode = getIthNode(index-1);
                theNode.next = previousNode.next;
                previousNode.next = theNode;
            }
            length++;
        }
    }


    /**
     * return the ListNode at given index
     * @param index given integer index
     * @return the ListNode at given index. return null if index is invalid
     */
    private ListNode getIthNode(int index){
        if (index < 0 || index >= getLength()) {
            return null;
        }
        else{
            ListNode runner = firstNode;
            for (int i=0; i<index; i++){
                runner = runner.next;
            }
            return runner;
        }
    }


    /**
     * insert all elements in given LinkedList at the end of the original one
     * @param other the LinkedList to be inserted
     */
    public void insertLinkedListToEnd(LinkedList other){
        if (!other.isEmpty()){
            if (this.isEmpty()){
                this.firstNode = other.cloneLinkedList().firstNode;
            }
            else{
                getIthNode(this.getLength()-1).next = other.cloneLinkedList().firstNode;
            }
        }
        this.length += other.getLength();
    }


    /**
     * Check whether the original LinkedList is equal to another LinkedList with same elements and order
     * @param other the other LinkedList
     * @return true if they are equal, false otherwise
     */
    public boolean equals(LinkedList other){
        if (this.getLength()!=other.getLength()){
            return false;
        }
        else{
            LinkedList thisClone = this.cloneLinkedList();
            LinkedList otherClone = other.cloneLinkedList();

            while (thisClone.getLength()>0){
                if(!thisClone.deleteElementAtIndex(0).equals(otherClone.deleteElementAtIndex(0))){
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * return the clone LinkedList. Changes in the clone LinkedList does not affect the original
     * @return the clone LinkedList
     */
    public LinkedList cloneLinkedList(){
        LinkedList newLinkedList = new LinkedList();
        if (!this.isEmpty()){
            newLinkedList.firstNode = new ListNode(this.firstNode.data);
            ListNode thisRunner = this.firstNode;
            ListNode otherRunner = newLinkedList.firstNode;
            while(thisRunner.next!=null){
                thisRunner = thisRunner.next;
                otherRunner.next = new ListNode(thisRunner.data);
                otherRunner = otherRunner.next;
            }
        }
        newLinkedList.length = this.getLength();
        return newLinkedList;
    }
}


