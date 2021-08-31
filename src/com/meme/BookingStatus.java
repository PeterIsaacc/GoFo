/**
 * @author Peter Essam Maguid Isaac
 */
package com.meme;

/**

 * {@link #Accepted}
 * {@link #Canceled}
 * {@link #Pending}
 * {@link #Denied}
 */

/**
 * Booking Status that can be used
 *  {@link #Accepted}
 *  {@link #Canceled}
 *  {@link #Pending}
 *  {@link #Denied}
 *
 */
public enum BookingStatus {
    /**
     * booking is accepted
     */
    Accepted,

    /**
     * booking is still Pending
     */
    Pending,

    /**
     * booking is Denied
     */
    Denied,

    /**
     * booking is Canceled
     */
    Canceled
}
