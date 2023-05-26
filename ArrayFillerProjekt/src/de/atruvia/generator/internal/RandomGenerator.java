package de.atruvia.generator.internal;

import de.atruvia.generator.Generator;

import java.util.Random;

public class RandomGenerator implements Generator<Integer> {

    private final Random random = new Random();
    @Override
    public Integer next() {
        return random.nextInt();
    }
}
