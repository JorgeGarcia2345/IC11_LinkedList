/*
Linked list, train
mHead
[] - [] - [] - [] - []
-->  -->  -->  -->  -->
DOES NOT GO BACKWARDS
Locomotive - [] - [] - [] - Caboose
Nodes
Jorge - Haylee - Zynthia - Tressah - Caboose

mData  = "Jorge"
Stops at a null
mNext - just the arrow / reference to the next Node

Randomly stored in RAM

Not as fast - CON

Uses max RAM available - PRO


 */

public class LinkedList <E> {

    private Node<E> mHead;
    private int mSize;

    public LinkedList() {
        mHead = null;
        mSize = 0;
    }

    public int size() {return mSize;}

    public boolean add(int index, E element)
    {

        if (index < 0 || index > mSize)
            throw new IndexOutOfBoundsException("Index must be >= 0 & <= " + mSize);

        //insert at the beginning
        if (index == 0) {
            mHead = new Node(element, mHead);
        }

        else {
            // Create a loco variable temp
            // Assign temp to the node "before" the index

            Node<E> temp = mHead;
            // move the temp to index - 1 times
            for (int i = 0; i < index - 1; i++) {
                temp = temp.mNext;
            }
            temp.mNext = new Node<>(element, temp.mNext);
        }
        mSize++;
        return true;
    }

    public boolean add(E element) {
        return this.add(mSize, element);
    }


    public String toString() {

        String output = "[";
        Node<E> temp = mHead;

        // Keep looping as long as temp is not null
        while(temp!=null) {
            output += temp.mData + ((temp.mNext != null) ? ", " : "]");
            temp = temp.mNext;
        }
        return output;
    }








    private class Node <E> {

        private E mData;
        private Node <E> mNext;

        private Node(E data, Node<E> next) {
            mData = data;
            mNext = next;
        }

        private Node(E data) {
            this(data, null);
        }

    }

    /*
    private class TrainCar<E>
    {
        private E mPassenger;
        private TrainCar <E> mNext;

    }
     */
}
