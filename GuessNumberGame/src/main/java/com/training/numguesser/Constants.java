package com.training.numguesser;

/**
 * Interface, that store global game constants
 *
 * @version 1.0 31 Oct 2016
 * @author Taras Sakharchuk
 */
public interface Constants {
    /**
     * Default left boundary of secret game value.
     * Game secret value always greater than that number.
     */
    int DEFAULT_MIN_BOUNDARY = 0;

    /**
     * Default right boundary of secret game value.
     * Game secret value always smaller than that number.
     */
    int DEFAULT_MAX_BOUNDARY = 100;
}
