package com.pg.edu.impl.data;

import com.pg.edu.api.data.TrainingData;

import java.util.List;

public class TrainingDataImpl implements TrainingData {

    private final List<Double> inputs;
    private final List<Double> outputs;

    public TrainingDataImpl(List<Double> inputs, List<Double> outputs) {
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public List<Double> getInputs() {
        return inputs;
    }

    @Override
    public List<Double> getOutputs() {
        return outputs;
    }
}
