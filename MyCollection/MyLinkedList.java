package comm.netcracker.homework4.MyCollection;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {
    private int size = 0;
    Node<E> first;
    Node<E> last;

    public MyLinkedList() {

    }

    public MyLinkedList(Collection<? extends E> collection) {
        this();
        addCollection(collection);
    }

    public E get(int index) {
        checkExistIndex(index);
        return getNode(index).value;
    }

    public E set(int index, E value) {
        checkExistIndex(index);

        Node<E> tmp = getNode(index);
        E valueTmp = tmp.value;
        tmp.value = value;

        return valueTmp;
    }

    public int indexOf(E value) {
        int index = 0;

        if (value == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.value == null) { return index; }
                ++index;
            }
        }
        else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.value.equals(value)) { return index; }
                ++index;
            }
        }
        return -1;
    }

    public int size() { return size; }

    public void clear() {
        Node<E> x = first;
        Node<E> nextX;

        while (x != null) {
            nextX = x.next;
            x.value = null;
            x.next = null;
            x.previous = null;
            x = nextX;
        }

        first = last = null;
        size = 0;
    }

    public E remove(int index) {
        checkExistIndex(index);

        return pop(getNode(index));
    }

    public Object[] toArray() {
        Object[] res = new Object[size];
        int i = 0;

        for (Node<E> x = first; x != null; x = x.next, ++i) { res[i] = x.value; }
        return res;
    }

    public <T> T[] toArray(T[] a) {
        if (a.length < size) { a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size); }

        Object[] res = a;
        int i = 0;

        for (Node<E> x = first; x != null; x = x.next, ++i) { res[i] = x.value; }

        if (a.length > size) { a[size] = null; }

        return a;
    }

    public Iterator<E> iterator() { return new MyIterator(this); }

    public void addFirst(E value) { putFirst(value); }

    public void addLast(E value) { putLast(value); }

    public void add(E value) { putLast(value); }

    public void add(int index, E value) {
        checkExistIndex(index);

        if (index == size) { putLast(value); }
        else { putBefore(value, getNode(index)); }
    }

    public boolean addCollection(Collection<? extends E> collection) { return addCollection(size, collection); }

    public boolean addCollection(int index, Collection<? extends E> collection) {
        checkExistIndex(index);

        Object[] arrayCollection = collection.toArray();
        int collectionSize = arrayCollection.length;
        if (collectionSize == 0) { return false; }

        Node<E> prev, current, tmpNode;
        E value;

        if (index == size) {
            prev = last;
            current = null;
        }
        else {
            current = getNode(index);
            prev = current.previous;
        }

        for (Object tmp: arrayCollection) {
            tmpNode = new Node<>(prev, (E) tmp, null);

            if (prev == null) { first = tmpNode; }
            else { prev.next = tmpNode; }
            prev = tmpNode;
        }

        if (current == null) { last = prev; }
        else {
            prev.next = current;
            current.previous = prev;
        }

        size += collectionSize;
        return true;
    }

    private void checkExistIndex(int index) {
        if (!isExistIndex(index)) {
            throw new IndexOutOfBoundsException("Index " + index + " out of MyLinkedList");
        }
    }
    private boolean isExistIndex(int index) { return index >= 0 && index <= size; }

    Node<E> getNode(int index) {
        Node<E> x;

        if (index < (size / 2)) {
            x = first;
            for (int i = 0; i < index; ++i) { x = x.next; }
        }
        else {
            x = last;
            for(int i = size - 1; i > index; --i) { x = x.previous; }
        }
        return x;
    }

    private void putFirst(E value) {
        Node<E> x = new Node<>(null, value, first);
        Node<E> f = first;
        first = x;
        if (f == null) { last = x; }
        else { f.previous = x; }
        ++size;
    }

    private void putLast(E value) {
        Node<E> l = last;
        Node<E> x = new Node<>(l, value, null);
        last = x;
        if (l == null) { first = x; }
        else { l.next = x; }
        ++size;
    }

    private void putBefore(E value, Node<E> current) {
        Node<E> x = new Node<>(current.previous, value, current);
        if (current.previous == null) { first = x; }
        else { current.previous.next = x; }
        current.previous = x;
        ++size;
    }

    private E pop(Node<E> x) {

        E value = x.value;
        Node<E> prev = x.previous;
        Node<E> next = x.next;


        if (prev == null) { first = next; }
        else {
            prev.next = next;
            x.previous = null;
        }

        if (next == null) {last = prev; }
        else {
            next.previous = prev;
            x.next = null;
        }

        x.value = null;
        --size;
        return value;
    }

    private class MyIterator implements Iterator<E> {
        Node<E> current;

        MyIterator(MyLinkedList<E> collection) { current = collection.first; }

        public boolean hasNext() { return current != null; }

        public E next() {
            E value = current.value;
            current = current.next;
            return value;
        }

    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;
        Node(Node<E> previous, E val, Node<E> next) {
            this.value = val;
            this.next = next;
            this.previous = previous;
        }
    }
}
