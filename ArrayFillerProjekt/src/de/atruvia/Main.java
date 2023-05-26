package de.atruvia;

import de.atruvia.client.ArrayClient;
import de.atruvia.collections.ArrayFiller;
import de.atruvia.collections.internal.ParallelArrayFiller;
import de.atruvia.generator.GeneratorFactory;
import de.atruvia.generator.internal.RandomGeneratorFactory;
import de.atruvia.time.BenchmarkProxy;

public class Main {



    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int runningThreads = 1; runningThreads <= availableProcessors +1 ; runningThreads++) {


            final GeneratorFactory<Integer> factory = new RandomGeneratorFactory();
            ArrayFiller<Integer> utils = new ParallelArrayFiller<Integer>(factory, runningThreads);
            utils = (ArrayFiller<Integer>) BenchmarkProxy.newInstance(utils);
            final ArrayClient client = new ArrayClient(utils);
            client.go();
        }



    }
}