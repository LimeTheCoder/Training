package com.limethecoder.model.source;


import java.io.IOException;

public interface Source {
    int readNextCharacter() throws IOException;
    boolean hasNext();
    void save(String information) throws IOException;
    void connect() throws IOException;
    void close() throws IOException;
}
