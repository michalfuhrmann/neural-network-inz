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
import com.pg.edu.impl.layer.InputLayerImpl;
import com.pg.edu.impl.layer.NetworkLayerImpl;
import com.pg.edu.impl.layer.OutputLayerImpl;

public class NeuralNetworkImpl implements NeuralNetwork {

    private final InputLayer inputLayer;
    private final List<NetworkLayer> hiddenLayers;
    private final OutputLayer outputLayer;

    private final LearningAlgorithm learningAlgorithm;

    private NeuralNetworkImpl(LearningAlgorithm learningAlgorithm, int inputSize, int outputSize, int hiddenLayerSize, int hiddenLayers) {
        this.learningAlgorithm = learningAlgorithm;

        this.inputLayer=new InputLayerImpl(inputSize);
        this.hiddenLayers = new ArrayList<>();
        IntStream.range(0, hiddenLayers).mapToObj(value -> new NetworkLayerImpl(hiddenLayerSize)).forEach(this.hiddenLayers::add);
        this.outputLayer=new OutputLayerImpl(outputSize);
    }

    @Override
    public void train(TrainingDataSet dataSet) {

        dataSet.getData().forEach(this::trainOneData);
    }

    private void trainOneData(TrainingData trainingData) {

        //TODO split trainingData arguments into input/otuput and pass it
        feedForward(trainingData);
        ErrorData errorData = calculateError(trainingData);
        updateWeights(errorData);
    }

    //delegate these methods to algorithm
    private void feedForward(TrainingData trainingData) {
        outputLayer.feedForward(trainingData);

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
        for(TrainingData trainingData : dataSet.getData()) {

            feedForward(trainingData);
            ErrorData errorData = calculateError(trainingData, outputLayer.getResult());
            errorDatas.add(errorData);

        }
        //TODO temp solution  ;)
        return new ErrorDataSet() {
            @Override
            public List<ErrorData> getData() {
                return errorDatas;
            }
        };

    }

    ErrorData calculateError(TrainingData trainingData,ResultData resultData) {
        throw new IllegalStateException("not yet implemento");
    }


    @Override
    public ResultData compute(TrainingData trainingData) {

        feedForward(trainingData);
        return outputLayer.getResult();
    }


    class NeuralNetworkBuilder{
        private LearningAlgorithm learningAlgorithm;
        private int inputSize;
        private int outputSize;
        private int hiddenLayerSize;
        private int hiddenLayers;

        public void setHiddenLayers(int hiddenLayers) {
            this.hiddenLayers = hiddenLayers;
        }

        public LearningAlgorithm getLearningAlgorithm() {
            return learningAlgorithm;
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
