package com.limethecoder.model.source;


import java.io.*;

public class FileSource implements Source {
    private String fileName;
    private FileReader reader;
    private int nextChar;

    public FileSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int readNextCharacter() throws IOException{
        int res = nextChar;
        nextChar = reader.read();
        return res;
    }

    @Override
    public boolean hasNext() {
        return nextChar != -1;
    }

    @Override
    public void save(String information) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(
                new File(fileName)));

        writer.write(information);
    }

    @Override
    public void connect() throws IOException{
        if(reader != null) {
            throw new IOException("Already connected");
        }

        reader = new FileReader(fileName);
    }

    @Override
    public void close() throws IOException{
        reader.close();
    }
}
