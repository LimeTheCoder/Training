package com.limethecoder.model.source;


import com.limethecoder.view.View;

/**
 * Class that describes dummy source of information
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
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

    @Override
    public int readNextCharacter() throws SourceException {
        if(!hasNext()) {
            throw new SourceException(View.EMPTY_STREAM);
        }

        nextIndex++;
        return data[nextIndex - 1];
    }

    @Override
    public boolean hasNext() {
        return nextIndex != data.length;
    }

    @Override
    public void save(String information) throws SourceException {
        System.out.println(information);
    }

    @Override
    public void connect() throws SourceException {
    }

    @Override
    public void close() throws SourceException {

    }
}
