package com.study.decorator;

import java.util.*;

public class HistorySet<E> implements Set<E> {

    List<E> removeList = new ArrayList<>();
    private Set<E> hashSet = new HashSet<>();


    @Override
    public int size() {
        return hashSet.size();
    }

    @Override
    public boolean isEmpty() {
        return hashSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return hashSet.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return hashSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return hashSet.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (hashSet.remove(o)) {
            removeList.add((E) o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String toString() {
        return hashSet.toString() + "remove list: " + removeList;
    }
}
