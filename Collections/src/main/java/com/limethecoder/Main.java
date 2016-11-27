package com.limethecoder;


import com.limethecoder.collections.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(5);
        lst.add(6);
        lst.remove(0);
        lst.add(4);
    }
}
