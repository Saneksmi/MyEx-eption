package com.company;

/**
 * Класс исключения, при дублировании контактов в книжке.
 * */
public class DoubleContactException extends Exception {

    public DoubleContactException(final String message) {
        super(message);
    }
}
