package comm.netcracker.homework4.MyCollection;

public interface ILinkedList<E> extends Iterable<E> {
    public void add(E element);
    public void add(int index, E element);
    public void clear();
    public E get(int index);
    public int indexOf(E element);
    public E remove(int index);
    public E set(int index, E element);
    public int size();
    public Object[] toArray();
    public <T> T[] toArray(T[] a);
    public String toString();
}
