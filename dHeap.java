import java.util.*;

/**
 * The dHeap class implements a tree-based data structure that satisfies the
 * heap property
 * 
 * @author Yifan He
 * @version 1.0
 * @since 02-14-2016
 */

class dHeap<T extends Comparable<? super T>> implements dHeapInterface<T> {
    
    
    private T[] array;
    private int capacity = 0;
    private int size = 0;
    // the number of branches of the tree
    private int d = 0;

    /**
     * dHeap constructs a default dHeap object with 2 branch
     * 
     * @param heapSize
     *            the size of dHeap
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        this.array = (T[]) new Comparable[heapSize];
        capacity = heapSize;
        d = 2;
    }

    /**
     * dHeap constructs a dHeap object
     * 
     * @param d
     *            the number of branching
     * @param heapSize
     *            the size of dHeap
     * @throws IllegalArgumentException
     *             if number of branch is less than 1
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize) throws IllegalArgumentException {
        if (d < 1) {
            throw new IllegalArgumentException();
        }
        this.array = (T[]) new Comparable[heapSize];
        this.d = d;
        capacity = heapSize;
    }

    /**
     * dHeap gets the size of dHeap
     * 
     * @return the size of dHeap
     */
    public int size() {
        return size;
    }

    /**
     * add adds new element to dHeap
     * 
     * @param data
     *            the data to add
     * @throws NullPointerException
     *             if the data is null
     */
    @SuppressWarnings("unchecked")
    public void add(T data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        }

        // resize if array is full
        if (size == capacity) {
            capacity *= 2;
            T[] tmpArray = (T[]) new Comparable[capacity];
            // copy to the new array
            for (int i = 0; i < size; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
        }

        // add the data
        array[size] = data;
        bubbleUp(size);
        size++;
    }

    /**
     * removeSmallest removes the smallest element from dHeap
     * 
     * @return the element being removed
     * @throws NoSuchElementException
     *             if dHeap is empty
     */
    public T removeSmallest() throws NoSuchElementException {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // substitute the smallest element by the last element
        T tmp = array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        // trickle down the first element
        trickleDown(0);
        return tmp;
    }

    /**
     * helper method for removeSmallest that trickles down a large element
     * 
     * @param indx
     *            the index of the element to be trickled down
     */
    private void trickleDown(int indx) {
        int parent = indx;
        // find the child of the element to be trickled down
        int child = indx * d + 1;

        // when the element to be trickled down is not the last element yet
        while (child < size) {

            int first = child;
            // find the index of the smallest child;
            for (int i = 1; i < d; i++) {
                if (first + i <= size - 1 
                        && array[first + i].compareTo(array[child]) < 0) {
                    child = first + i;
                }
            }

            // trickle down if the element is larger than its child
            if (array[child].compareTo(array[parent]) < 0) {
                swap(child, parent);
            }

            parent = child;
            child = parent * d + 1;
        }

    }

    /**
     * helper method for add that bubbles up a small element
     * 
     * @param indx
     *            the index of the element to be bubbled up
     */
    private void bubbleUp(int indx) {
        int child = indx;
        // find the parent of the element to be bubbled up
        int parent = (child - 1) / d;

        // while the parent is not the first element yet
        // bubble up if the element is smaller than its parent
        while (parent >= 0 && array[child].compareTo(array[parent]) < 0) {
            swap(child, parent);
            child = parent;
            parent = child / d;
        }
    }

    /**
     * swap swaps the location of two elements in an array
     * 
     * @param i
     *            the index of the first element
     * @param j
     *            the index of the second element
     */
    private void swap(int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
