package com.limethecoder.model.source;


import java.io.*;

/**
 * Class that describes file as source of information
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class FileSource implements Source {
    private String fileName;
    private FileReader reader;
    private int nextChar;

    public FileSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int readNextCharacter() throws SourceException {
        int res = nextChar;
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
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(
                    new File(fileName)));

            writer.write(information);
        } catch (IOException e) {
            throw new SourceException(e);
        }
    }

    @Override
    public void connect() throws SourceException {
        if(reader != null) {
            throw new SourceException("Already connected");
        }

        try {
            reader = new FileReader(fileName);
            nextChar = reader.read();
        } catch (Exception e) {
            throw new SourceException(e);
        }
    }

    @Override
    public void close() throws SourceException {
        try {
            reader.close();
            nextChar = -1;
        } catch (IOException e) {
            throw new SourceException(e);
        }
    }
}
