package de.atruvia.generator.internal;

import de.atruvia.generator.Generator;
import de.atruvia.generator.GeneratorFactory;

public class RandomGeneratorFactory implements GeneratorFactory<Integer> {
    @Override
    public Generator<Integer> create() {
        return new RandomGenerator();
    }
}
