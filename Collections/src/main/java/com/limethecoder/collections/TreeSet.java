package com.limethecoder.collections;

import java.util.*;

/**
 * My own implementation of tree set
 *
 * @param <E> type of elements, that collection stores
 * @author Taras Sakharchuk
 * @version 1.0 28 Nov 2016
 */
public class TreeSet<E extends Comparable<E>> implements Set<E> {
    private Node<E> root;
    private int size = 0;
    private Comparator<E> comp;
    private int modCount;

    public TreeSet() {
        comp = (o1, o2) -> o1.compareTo(o2);
    }

    public TreeSet(Comparator<E> comp) {
        this.comp = comp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Objects.requireNonNull(o);

        for (E e : this) {
            if (o.equals(e))
                return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        int count = 0;

        for (E e : this) {
            a[count++] = e;
        }

        return a;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Objects.requireNonNull(a);

        if (a.length < size) {
            a = (T[]) new Object[size];
        }

        int count = 0;
        for (E e : this) {
            a[count++] = (T) e;
        }

        return a;
    }

    @Override
    public boolean add(E e) {
        Objects.requireNonNull(e);

        if (root == null)
            root = new Node<>(e);
        else {
            Node<E> parent = null;
            Node<E> current = root;
            while (current != null)
                if (comp.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (comp.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false;

            if (e.compareTo(parent.element) < 0)
                parent.left = new Node<>(e);
            else
                parent.right = new Node<>(e);
        }

        size++;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Objects.requireNonNull(o);

        Node<E> parent = null;
        Node<E> current = root;

        while (current != null) {
            if (comp.compare(((E) o), current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (comp.compare(((E) o), current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else {
                break;
            }
        }

        if (current == null) {
            return false;
        }

        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (comp.compare(((E) o), parent.element) < 0) {
                    parent.left = current.right;
                }
                else {
                    parent.right = current.right;
                }
            }
        } else {
            Node<E> parentOfRightMost = current;
            Node<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            }
            else {
                parentOfRightMost.left = rightMost.left;
            }
        }

        size--;
        modCount++;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Objects.requireNonNull(c);

        for (E e: c) {
            if (!add(e))
                return false;
        }
        modCount++;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Objects.requireNonNull(c);

        for (Object o: c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);

        boolean isChanged = false;
        for (Object o: c) {
            if (o != null && remove(o))
                isChanged = true;
        }

        if (isChanged)
            modCount++;

        return isChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);

        boolean isChanged = false;
        for (Iterator<E> itr = iterator(); itr. hasNext();) {
            E e = itr.next();
            if (!c.contains(e)) {
                itr.remove();
                isChanged = true;
            }
        }

        if (isChanged)
            modCount++;

        return isChanged;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
        modCount++;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyInorderIterator();
    }

    private class MyInorderIterator implements Iterator<E> {
        private List inorderList = new ArrayList<E>();

        private int cursor = 0;
        private int lastRet = -1;
        private int expectedModCount = modCount;

        public MyInorderIterator() {
            inorder();
        }

        private void inorder() {
            inorder(root);
        }

        private void inorder(Node<E> root) {
            if (root == null)
                return;
            inorder(root.left);
            inorderList.add(root.element);
            inorder(root.right);
        }

        @Override
        public boolean hasNext() {
            return cursor < inorderList.size();
        }

        @Override
        public E next() {
            checkForComodification();

            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();

            cursor = i + 1;
            return (E) inorderList.get(lastRet = i);
        }

        @Override
        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            checkForComodification();

            try {
                TreeSet.this.remove(inorderList.get(lastRet));
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;

                inorderList.clear();
                inorder();
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;

        Node(E element) {
            this.element = element;
        }

        Node(E element, Node<E> left, Node<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
