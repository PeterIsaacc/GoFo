
/**
 * @author shehab eldin khaled mohamed
 *
 */
package com.meme;

/**
 * this class represents the size of a certain Playground it has only two attribuites the length and width of the playground
 */
public class Size {
    public double width;
    public double length;

    /**
     * constructor to set the width and length
     * @param width the value to be set in the width attribute
     * @param length the value to be set in the length attribute
     */
    public Size(double width , double length)
    {
        this.width = width;
        this.length = length;
    }

    /**
     * default constructor that sets the width and length of a certain playground to 0
     */
    public Size()
    {
        width = 0;
        length = 0;
    }
}
