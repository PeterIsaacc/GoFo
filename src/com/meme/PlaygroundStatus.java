package com.meme;

/**
 * @author shehab eldin khaled mohamed
 */

/**
 *  Playground status that can be used
 *  {@link #Suspended}
 *  {@link #Active}
 *  {@link #Waiting}
 */
public enum PlaygroundStatus {
    /**
     * Administrator suspended the Playground
     */
    Suspended,

    /**
     * Administrator activated the Playground
     */
    Active,

    /**
     * Playground registration request is made and it is waiting for a response from the administrator
     */
    Waiting
}
