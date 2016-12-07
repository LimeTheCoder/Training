package com.limethecoder.model.source;


import com.limethecoder.view.View;

import java.io.*;

/**
 * Class that describes file as source of information
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class FileSource implements Source {
    private File file;
    private FileReader reader;
    private int nextChar;

    public FileSource(String fileName) {
        try {
            file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        } catch (NullPointerException e) {
            file = new File(fileName);
        }
    }

    @Override
    public int readNextCharacter() throws SourceException {
        if(!hasNext()) {
            throw new SourceException(View.EMPTY_STREAM);
        }

        int res = nextChar;

        if(reader == null) {
            throw new SourceException(View.CONNECTION_FAIL);
        }

        try {
            nextChar = reader.read();
        } catch (IOException e) {
            throw new SourceException(e);
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return nextChar != -1;
    }

    @Override
    public void save(String information) throws SourceException {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(information);
        } catch (IOException e) {
            throw new SourceException(e);
        }
    }

    @Override
    public void connect() throws SourceException {
        if(reader != null) {
            return;
        }

        try {
            reader = new FileReader(file);
            nextChar = reader.read();
        } catch (Exception e) {
            throw new SourceException(e);
        }
    }

    @Override
    public void close() throws SourceException {
        if(reader == null) {
            return;
        }
        try {
            reader.close();
            nextChar = -1;
            reader = null;
        } catch (IOException e) {
            throw new SourceException(e);
        }
    }
}
