package de.atruvia.collections.internal;

import de.atruvia.collections.ArrayFiller;
import de.atruvia.collections.ArrayFillerException;
import de.atruvia.generator.Generator;
import de.atruvia.generator.GeneratorFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelArrayFiller<T> implements ArrayFiller<T> {

    private final GeneratorFactory<T> generatorFactory;
    private final int runningThreads;
    private T[] arrayToFill;

    private ExecutorService service;

    public ParallelArrayFiller(final GeneratorFactory generatorFactory, final int runningThreads) {
        this.generatorFactory = generatorFactory;
        this.runningThreads = runningThreads;
    }

    @Override
    public void populateArray(final T[] arrayToFill) {
        this.arrayToFill = arrayToFill;
        fillArrayParallelWithThreadPool();
    }

    private void fillArrayParallelWithThreadPool() {
        try {
            fillArrayParallelWithThreadPoolImpl();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ArrayFillerException("Ein Fehler ist aufgetreten",e);
        }
    }

    private void fillArrayParallelWithThreadPoolImpl() throws InterruptedException {
        service = Executors.newFixedThreadPool(runningThreads);
        startWorker();
        service.shutdown();

        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }

    private void startWorker() {
        for (int aktThread = 0; aktThread < runningThreads; aktThread++) {
            startSingleWorker(aktThread);
        }
    }

    private void startSingleWorker(final int aktThread) {
        final int segmentSize = arrayToFill.length / runningThreads;
        final int start = segmentSize * aktThread;
        final int ende = start + segmentSize;
        service.execute(new FillArraySegmentWorker<T>(start, ende));
    }

    private class FillArraySegmentWorker<T> implements Runnable {
        private final int start;
        private final int ende;

        public FillArraySegmentWorker(final int start, final int ende) {
            this.start = start;
            this.ende = ende;
        }

        @Override
        public void run() {
            var generator = generatorFactory.create();
            for (int i = start; i < ende; i++) {
                arrayToFill[i] = generator.next();
            }
        }
    }
}
