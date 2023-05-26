package de.atruvia.collections.internal;

import de.atruvia.collections.ArrayFiller;
import de.atruvia.generator.Generator;

public class SequenziellArrayFiller<T> implements ArrayFiller<T> {

    private final Generator<T> generator;

    public SequenziellArrayFiller(final Generator<T> generator) {
        this.generator = generator;
    }


    @Override
    public void populateArray(final T[] arrayToFill) {
        for (int i = 0; i < arrayToFill.length; i++) {
            arrayToFill[i] = generator.next();
        }
    }
}
