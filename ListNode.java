package proj3;

/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object.
 * 
 */
public class ListNode
{
    public String data;
    public ListNode next;

    /**
     * Non default constructor
     * @param new_data the String data added to the ListNode
     */
    public ListNode(String new_data)
    {
        data = new_data;
        next = null;
    }

    /**
     * Returns the data of ListNode as a String
     * @return String, representing data in this ListNode
     */
    public String toString(){
    	return data;
    }

}
