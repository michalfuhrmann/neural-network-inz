package com.pg.edu.impl.layer;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import com.pg.edu.api.data.ErrorData;
import com.pg.edu.api.data.TrainingData;
import com.pg.edu.api.layer.InputLayer;
import com.pg.edu.api.node.Node;

public class InputLayerImpl implements InputLayer {

    private final int size;
    private List<Node> nodes;

    public InputLayerImpl(int size) {
        this.size = size;
        this.nodes = new LinkedList<>();

    }

    @Override
    public void updateWeights(ErrorData errorData) {

    }

    @Override
    public void setInputs(TrainingData trainingData) {

        IntStream.range(0, size).forEach(index -> nodes.get(index).setValue(trainingData.getInputs().get(index)));


    }
}
