package com.limethecoder.collections;


import java.util.*;

/**
 * My own implementation of linked list
 *
 * @param <E> type of elements, that collection stores
 * @author Taras Sakharchuk
 * @version 1.0 23 Nov 2016
 */
public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;

    private int size;

    private long modCount;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<E> curr = head;
        int idx = 0;

        while(curr != null) {
            arr[idx] = curr.value;
            curr = curr.next;
            idx++;
        }

        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            throw new IllegalArgumentException();

        int idx = 0;
        Object[] result = a;
        for (Node<E> x = head; x != null; x = x.next)
            result[idx++] = x.value;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, tail, null);

        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
        modCount++;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, null, head);

        if(head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }

        head = newNode;
        size++;
        modCount++;
    }

    private void addBefore(Node<E> succ, E e) {
        Objects.requireNonNull(succ);

        Node<E> newNode = new Node<>(e, succ.prev, succ);
        succ.prev = newNode;

        if(newNode.prev == null) {
            head = newNode;
        } else {
            newNode.prev.next = newNode;
        }

        size++;
        modCount++;
    }

    private Node<E> findNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> x;

        if (index < size / 2) {
            x = head;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
        }

        return x;
    }


    private E removeFirst(Node<E> node) {
        Objects.requireNonNull(node);
        if(node != head) {
            throw new IllegalArgumentException();
        }

        E old = node.value;

        head = head.next;
        if (head == null)
            tail = null;
        else
            head.prev = null;
        size--;

        modCount++;

        return old;
    }


    private E removeLast(Node<E> node) {
        Objects.requireNonNull(node);
        if(node != tail) {
            throw new IllegalArgumentException();
        }

        E old = node.value;

        tail = tail.prev;
        if (tail == null) {
            head = null;
        }
        else {
            tail.next = null;
        }

        size--;
        modCount++;

        return old;
    }

    private E remove(Node<E> x) {
        Objects.requireNonNull(x);

        E old = x.value;

        if(head == x) {
            removeFirst(x);
        } else if(tail == x) {
            removeLast(x);
        } else {
            x.prev.next = x.next;
            x.next.prev = x.prev;

            size--;
            modCount++;
        }

        return old;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = head; x != null; x = x.next) {
                if (x.value == null) {
                    remove(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = head; x != null; x = x.next) {
                if (o.equals(x.value)) {
                    remove(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Node<E> curr = head;
        for(Object o : c) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Objects.requireNonNull(c);
        if(c.isEmpty()) {
            return true;
        }
        if(index < 0 || index > size) {
            throw new IllegalArgumentException();
        }

        Node<E> first = null;
        Node<E> last = null;

        for(E e : c) {
            Node<E> newNode = new Node<>(e);

            if(first == null) {
                first = newNode;
            } else {
                last.next = newNode;
                newNode.prev = last;
            }

            last = newNode;
        }

        if(index == 0) {
            head = first;
            tail = last;
        } else if(index == size) {
            tail.next = first;
            first.prev = tail;
            tail = last;
        } else {
            Node<E> succ = findNode(index);
            succ.prev.next = first;
            first.prev = succ.prev;
            last.next = succ;
            succ.prev = last;
        }

        size += c.size();
        modCount++;

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);

        for(Object o : c) {
            while (contains(o)) {
                remove(remove(o));
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);

        Node<E> curr = head;

        while (curr != null) {
            if (!c.contains(curr.value)) {
                Node<E> tmp = curr.next;
                remove(curr);
                curr = tmp;
            } else {
                curr = curr.next;
            }
        }

        return true;
    }

    @Override
    public void clear() {
        for (Node<E> x = head; x != null; ) {
            Node<E> next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return findNode(index).value;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = findNode(index);
        E old = node.value;
        node.value = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == size) {
            addLast(element);
        } else if(index == 0) {
            addFirst(element);
        } else {
            addBefore(findNode(index), element);
        }
    }

    @Override
    public E remove(int index) {
        return remove(findNode(index));
    }

    @Override
    public int indexOf(Object o) {
        Node<E> curr = head;
        int cnt = 0;

        if(o == null) {
            while(curr != null) {
                if(curr.value == null) {
                    return cnt;
                }
                curr = curr.next;
                cnt++;
            }

            return -1;
        }

        while(curr != null) {
            if(o.equals(curr.value)) {
                return cnt;
            }

            cnt++;
            curr = curr.next;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> curr = tail;
        int cnt = size - 1;

        if(o == null) {
            while(curr != null) {
                if(curr.value == null) {
                    return cnt;
                }
                cnt--;
                curr = curr.next;
            }
        }

        while(curr != null) {
            if(o.equals(curr.value)) {
                return cnt;
            }

            cnt--;
            curr = curr.prev;
        }

        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            LinkedList<E> lst = new LinkedList<E>();
            int idx = 0;
            Node<E> last = findNode(toIndex);
            for (Node<E> i = findNode(fromIndex); i != last; i = i.next) {
                lst.add(i.value);
            }
            return lst;
        } else {
            return new LinkedList<>();
        }
    }

    private class MyIterator implements Iterator<E> {
        private MyListIterator iterator = new MyListIterator(size);

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }

    private class MyListIterator implements ListIterator<E> {

        private long expectedCount = modCount;
        private int index;
        private Node<E> current;
        private Node<E> lastReturned;

        public MyListIterator(int index) {
            if(index < 0 || index > size) {
                throw new IllegalArgumentException();
            }

            if(index != size) {
                this.current = findNode(index);
            }

            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            checkForModification();
            lastReturned = current;
            current = current.next;
            index++;
            return lastReturned.value;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public E previous() {
            checkForModification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (current == null){
                current = tail;
            } else {
                current=current.prev;
            }
            lastReturned = current;
            index--;
            return lastReturned.value;

        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            checkForModification();
            LinkedList.this.remove(current);
            expectedCount++;
            current = current.next;
            lastReturned = null;
        }

        @Override
        public void set(E e) {
            checkForModification();
            current.value = e;
        }

        @Override
        public void add(E element) {
            checkForModification();
            addBefore(current, element);
            lastReturned = null;
            expectedCount++;
        }

        void checkForModification() {
            if (modCount != expectedCount)
                throw new ConcurrentModificationException();
        }
    }

    private class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        Node(E value) {
            this.value = value;
        }
    }
}
