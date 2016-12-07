package com.limethecoder.model.source;

/**
 * Class that describes source of information
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public interface Source extends AutoCloseable {
    /**
     * Read from source next character.
     *
     * @return code of character, that fetched from source
     * @throws SourceException
     */
    int readNextCharacter() throws SourceException;

    /**
     * Performs check is source has more elements.
     *
     * @return {@code true} if source has next element
     */
    boolean hasNext();

    /**
     * Store information back the source.
     *
     * @param information that need to be saved
     * @throws SourceException
     */
    void save(String information) throws SourceException;

    /**
     * Establish connection to the source.
     * Need to be called, before use of any methods.
     *
     * @throws SourceException
     */
    void connect() throws SourceException;

    /**
     * Close connection from source.
     * Need to be closed after end of using source object.
     *
     * @throws SourceException
     */
    void close() throws SourceException;

    /**
     * Factory method. Instantiate appropriated source object.
     *
     * @param type {@link SourceType} of the source
     * @param source name of source
     * @return created source object
     */
    static Source getInstance(SourceType type, String source) {
        switch (type) {
            case FILE:
                return new FileSource(source);

            case DUMMY:
            default:
                return new DummySource(source);
        }
    }
}
