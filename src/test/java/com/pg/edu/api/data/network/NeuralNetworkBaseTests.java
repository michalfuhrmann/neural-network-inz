package com.pg.edu.api.data.network;


import com.pg.edu.api.NeuralNetwork;
import com.pg.edu.api.data.TrainingData;
import com.pg.edu.impl.data.TrainingDataImpl;
import com.pg.edu.impl.dataset.TrainingDataSetImpl;
import com.pg.edu.impl.network.NeuralNetworkImpl;
import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;

public class NeuralNetworkBaseTests {


    @Test
    public void test() {


        NeuralNetwork neuralNetwork = NeuralNetworkImpl.builder().setInputSize(1).setHiddenLayers(1).setHiddenLayerSize(3).setOutputSize(1).build();


        List<Double> input = singletonList(1d);
        List<Double> output = singletonList(2d);

        TrainingData trainingData = new TrainingDataImpl(input, output);


        neuralNetwork.train(new TrainingDataSetImpl(singletonList(trainingData)));


    }


}
