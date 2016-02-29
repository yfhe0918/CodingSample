
/**
 * The dHeap Interface specifies the methods that dHeap class should implement
 * 
 * @version 1.0
 * @since 02-14-2016
 */

public interface dHeapInterface<T extends java.lang.Comparable<? super T>> {
    public void add(T o);

    public T removeSmallest();

    public int size();
}
