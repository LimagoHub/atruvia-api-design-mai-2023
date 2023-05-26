package de.atruvia.generator;

public interface GeneratorFactory<T> {
    Generator<T> create();
}
