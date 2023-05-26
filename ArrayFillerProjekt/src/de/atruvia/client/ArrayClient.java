package de.atruvia.client;

import de.atruvia.collections.ArrayFiller;

public class ArrayClient {
    private Integer [] feld = new Integer[100_000_000];

    private final ArrayFiller<Integer> utils;

    public ArrayClient(final ArrayFiller utils) {
        this.utils = utils;
    }

    public void go() {
        utils.populateArray(feld);
        // do something with large Array...
    }
}
