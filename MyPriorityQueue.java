import java.util.NoSuchElementException;

/**
 * The MyPriorityQueue class implements a data structure where the elements of
 * the priority queue are ordered according to their natural ordering
 * 
 * @author Yifan He
 * @version 1.0
 * @since 02-14-2016
 */

public class MyPriorityQueue<T extends Comparable<? super T>> {

    private dHeap<T> priorityQueue;

    /**
     * MyPriorityQueue constructs a MyPriorityQueue object
     * 
     * @param size
     *            the size of the queue
     */
    public MyPriorityQueue(int size) {
        priorityQueue = new dHeap<T>(size);
    }

    /**
     * add adds data to MyPriority Queue
     * 
     * @param data
     *            the data to be added
     * 
     * @throw NullPointerException if the data is null
     */
    
    public void add(T data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        }
        priorityQueue.add(data);
    }

    /**
     * poll removes the first element of MyPriorityQueue
     * 
     * @return the data being removed
     */
    public T poll() {
        try {
            return priorityQueue.removeSmallest();
        } catch (NoSuchElementException e) {
            return null;
        }

    }
}
