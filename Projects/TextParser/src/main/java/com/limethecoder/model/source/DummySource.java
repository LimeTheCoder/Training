package com.limethecoder.model.source;


import java.io.IOException;

public class DummySource implements Source {

    private char[] data;
    private int nextIndex;

    public DummySource() {}

    public DummySource(String data) {
        this.data = data.toCharArray();
    }

    public String getData() {
        return new String(data);
    }

    public void updateData(String data) {
        this.data = data.toCharArray();
        nextIndex = 0;
    }

    @Override
    public int readNextCharacter() throws IOException {
        nextIndex++;
        return data[nextIndex - 1];
    }

    @Override
    public boolean hasNext() {
        return nextIndex != data.length;
    }

    @Override
    public void save(String information) throws IOException {
        System.out.println(information);
    }

    @Override
    public void connect() throws IOException {
    }

    @Override
    public void close() throws IOException {

    }
}
