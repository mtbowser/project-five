package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * This provides implementation for some of the LList methods. object the class
 * will store
 */
public class DLList<E> implements ListInterface<E>
{

    /**
     * This represents a node in a doubly linked list. This node stores data, a
     * pointer to the node before it in the list, and a pointer to the node
     * after it in the list
     *
     * @param <E>
     *            This is the type of object that this class will store
     * @author Mark Wiggans (mmw125)
     * @version 4/14/2015
     */
    private static class Node<E>
    {
        private Node<E> next;
        private Node<E> previous;
        private E       data;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d)
        {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n)
        {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<E> n)
        {
            previous = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next()
        {
            return next;
        }


        /**
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous()
        {
            return previous;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData()
        {
            return data;
        }
    }

    /**
     * How many nodes are in the list
     */
    private int     size;

    /**
     * The first node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> head;

    /**
     * The last node in the list. THIS IS A SENTINEL NODE AND AS SUCH DOES NOT
     * HOLD ANY DATA. REFER TO init()
     */
    private Node<E> tail;


    /**
     * Create a new DLList object.
     */
    public DLList()
    {
        init();
    }


    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init()
    {
        head = new DLList.Node<E>(null);
        tail = new DLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return size;
    }


    /**
     * Removes all of the elements from the list
     */
    public void clear()
    {
        init();
    }

    @Override
    public E getEntry(int index)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("outta bounds");
            
        }
        Node<E> curr = head.next();
        int currentIndex = 0;
        E data = null;
        while (curr != tail)
        {
            if (currentIndex == index ) 
            {
               data = curr.getData();
               break;
            }
            currentIndex++;
            curr = curr.next;
            if (data == null) 
            {
                throw new IndexOutOfBoundsException("outtabounds");
            }
            return data;
        }
    }
    /***
     * 
     * returns node at specified index. 
     * 
     * 
     */
    private Node<E> getNodeAt(int index)
    {
        if (index < 0 || size <= index)
        {
            throw new IndexOutOfBoundsException("index out of bounds");
            
        }
        Node<E> current = head.next();
        for (int i = 0; i < index; i++) 
        {
            current = current.next();
        }
        return current;
    }

    @Override
    public int getLength()
    {
        return size;
    }


    @Override
    public E remove(int index)
    {
        Node<E> gonnaLeave = getNodeAtIndex(index);
        gonnaLeave.previous().setNext(gonnaLeave.next);
        gonnaLeave.next().setPrevious(gonnaLeave.previous);
        
        return gonnaLeave.getData();
       
    }


    @Override
    public E replace(int arg0, E arg1)
    {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Object[] toArray()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(E obj)
    {
        if (isEmpty())
        {
            return false;

        }
        Node<E> current = head.next();
        while (current != tail)
        {
            if (obj.equals(current.getData()))
            {
                return true;
            }
            current = current.next();
        }
        return false;

    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there no node at the given index
     */
    public E get(int index)
    {
        return getNodeAtIndex(index).getData();
    }


    /**
     * Adds a element to the end of the list
     *
     * @param newEntry
     *            the element to add to the end
     */
    public void add(E newEntry)
    {
        add(size(), newEntry);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj)
    {
        if (index < 0 || size < index)
        {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null)
        {
            throw new IllegalArgumentException(
                "Cannot add null " + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size)
        {
            nodeAfter = tail;
        }
        else
        {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    /**
     * gets the node at that index
     * 
     * @param index
     * @return node at index
     */
    private Node<E> getNodeAtIndex(int index)
    {
        if (index < 0 || size() <= index)
        {
            throw new IndexOutOfBoundsException(
                "No element exists at " + index);
        }
        Node<E> current = head.next(); // as we have a sentinel node
        for (int i = 0; i < index; i++)
        {
            current = current.next();
        }
        return current;
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public int lastIndexOf(E obj)
    {
        /*
         * We should go from the end of the list as then we an stop once we find
         * the first one
         */
        Node<E> current = tail.previous();
        for (int i = size() - 1; i >= 0; i--)
        {
            if (current.getData().equals(obj))
            {
                return i;
            }
            current = current.previous();
        }
        return -1;  // if we do not find it
    }


  


    /**
     * Removes the first object in the list that .equals(obj)
     *
     * @param obj
     *            the object to remove
     * @return true if the object was found and removed
     */

    public boolean remove(E obj)
    {
        Node<E> current = head.next();
        while (!current.equals(tail))
        {
            if (current.getData().equals(obj))
            {
                current.previous().setNext(current.next());
                current.next().setPrevious(current.previous());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty())
        {
            Node<E> currNode = head.next();
            while (currNode != tail)
            {
                E element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != tail)
                {
                    builder.append(", ");
                }
                currNode = currNode.next();
            }
        }

        builder.append("}");
        return builder.toString();
    }
    
    
    /*
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * BE  RIGHT  BACK  
     * 
     * 
     * 
     * 
     * 
     * private inner DLinkedListIterator class///////////////////////////////
     */
    @SuppressWarnings("hiding")
    private class DLListIterator<E>
        implements Iterator<E>
    {
        /**
         * Creates a new DLListIterator
         */
        private Node<E> currentNode;


        public DLListIterator()
        {
            currentNode = (Node<E>)head;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext()
        {
            return currentNode != tail; 
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next()
        {
            if (hasNext()) {
            return currentNode.next.getData();
            }
            else{
                throw new NoSuchElementException("no more");
            }
        }


        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet and if the element has
         *             already been removed
         */
        @Override
        public void remove()
        {
        }
        
        public void sort(Comparator<Obj> comp)
        {
            // perfoems an insetrion sort
            
        }
    }


   
}




