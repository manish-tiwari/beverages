package com.manish.beverages.exceptions;


/**
 *
 * @author Manish Tiwari
 *
 */

public class BeverageOrderException extends RuntimeException {
    public BeverageOrderException(String exception) {
        super(exception);
    }
}
