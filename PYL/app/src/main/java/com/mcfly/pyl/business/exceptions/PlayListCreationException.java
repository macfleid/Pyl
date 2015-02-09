package com.mcfly.pyl.business.exceptions;

/**
 * Created by mcfly on 09/02/2015.
 */
public class PlayListCreationException extends Exception {
    /**
     */
    private static final long serialVersionUID = 1L;

    public PlayListCreationException(Throwable t) {
        super(t);
    }

    public PlayListCreationException(String t) {
        super(t);
    }

    public PlayListCreationException(String t, Throwable T) {
        super(t,T);
    }

}
