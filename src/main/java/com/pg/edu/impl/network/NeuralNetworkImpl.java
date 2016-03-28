package com.pg.edu.impl.network;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.pg.edu.api.LearningAlgorithm;
import com.pg.edu.api.NeuralNetwork;
import com.pg.edu.api.data.ErrorData;
import com.pg.edu.api.data.ResultData;
import com.pg.edu.api.data.TrainingData;
import com.pg.edu.api.dataset.ErrorDataSet;
import com.pg.edu.api.dataset.TrainingDataSet;
import com.pg.edu.api.layer.InputLayer;
import com.pg.edu.api.layer.NetworkLayer;
import com.pg.edu.api.layer.OutputLayer;
import com.pg.edu.api.node.Node;
import com.pg.edu.impl.layer.InputLayerImpl;
import com.pg.edu.impl.layer.NetworkLayerImpl;
import com.pg.edu.impl.layer.OutputLayerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NeuralNetworkImpl implements NeuralNetwork {

    private static Logger LOG = LoggerFactory.getLogger(NeuralNetworkImpl.class);

    private final InputLayer inputLayer;
    private final List<NetworkLayer> hiddenLayers;
    private final OutputLayer outputLayer;

    private final LearningAlgorithm learningAlgorithm;

    private NeuralNetworkImpl(LearningAlgorithm learningAlgorithm, int inputSize, int outputSize, int hiddenLayerSize, int hiddenLayers) {
        this.learningAlgorithm = learningAlgorithm;

        this.inputLayer = new InputLayerImpl(inputSize);
        this.hiddenLayers = new ArrayList<>();
        IntStream.range(0, hiddenLayers).mapToObj(value -> new NetworkLayerImpl(hiddenLayerSize)).forEach(this.hiddenLayers::add);
        this.outputLayer = new OutputLayerImpl(outputSize);

        this.hiddenLayers.forEach(hiddenLayer -> connectNodes(inputLayer.getNodes(), hiddenLayer.getNodes()));
        this.hiddenLayers.forEach(hiddenLayer -> connectNodes(hiddenLayer.getNodes(), outputLayer.getNodes()));
    }


    private void connectNodes(List<Node> firstLayer, List<Node> secondLayer) {

        secondLayer.forEach(secondLayerNode -> firstLayer.forEach(secondLayerNode::connect));
    }

    @Override
    public void train(TrainingDataSet dataSet) {

        dataSet.getData().forEach(this::trainSingleData);
    }

    private void trainSingleData(TrainingData trainingData) {

        //TODO split trainingData arguments into input/otuput and pass it
        feedForward(trainingData);
        ErrorData errorData = calculateError(trainingData);
        updateWeights(errorData);
    }

    //delegate these methods to algorithm
    private ResultData feedForward(TrainingData trainingData) {

        inputLayer.setInputs(trainingData);
        ResultData resultData = outputLayer.feedForward();

        return resultData;
    }

    private ErrorData calculateError(TrainingData trainingData) {
        return outputLayer.calculateError(trainingData);

    }

    private void updateWeights(ErrorData errorData) {
        inputLayer.updateWeights(errorData);
    }

    @Override
    public ErrorDataSet validate(TrainingDataSet dataSet) {

        List<ErrorData> errorDatas = new ArrayList<>();
        for (TrainingData trainingData : dataSet.getData()) {
            ResultData output = feedForward(trainingData);

            ErrorData errorData = calculateError(trainingData, output);
            errorDatas.add(errorData);

        }
        //TODO temp solution  ;)
        return () -> errorDatas;

    }

    ErrorData calculateError(TrainingData trainingData, ResultData resultData) {
        throw new IllegalStateException("not yet implemento");
    }


    @Override
    public ResultData compute(TrainingData trainingData) {
        ResultData resultData = feedForward(trainingData);
        return resultData;
    }


    public static NeuralNetworkBuilder builder() {
        return new NeuralNetworkBuilder();
    }

    public static class NeuralNetworkBuilder {
        private LearningAlgorithm learningAlgorithm;
        private int inputSize;
        private int outputSize;
        private int hiddenLayerSize;
        private int hiddenLayers;


        public LearningAlgorithm getLearningAlgorithm() {
            return learningAlgorithm;
        }

        public NeuralNetworkBuilder setHiddenLayers(int hiddenLayers) {
            this.hiddenLayers = hiddenLayers;
            return this;
        }

        public NeuralNetworkBuilder setLearningAlgorithm(LearningAlgorithm learningAlgorithm) {
            this.learningAlgorithm = learningAlgorithm;
            return this;
        }

        public NeuralNetworkBuilder setInputSize(int inputSize) {
            this.inputSize = inputSize;
            return this;
        }

        public NeuralNetworkBuilder setOutputSize(int outputSize) {
            this.outputSize = outputSize;
            return this;
        }

        public NeuralNetworkBuilder setHiddenLayerSize(int hiddenLayerSize) {
            this.hiddenLayerSize = hiddenLayerSize;
            return this;
        }


        public NeuralNetworkImpl build() {
            return new NeuralNetworkImpl(learningAlgorithm, inputSize, outputSize, hiddenLayerSize, hiddenLayers);
        }

    }
}
