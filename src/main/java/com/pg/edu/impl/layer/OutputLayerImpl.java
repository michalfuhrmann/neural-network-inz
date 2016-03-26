package com.pg.edu.impl.layer;

import java.util.LinkedList;
import java.util.List;

import com.pg.edu.api.data.ErrorData;
import com.pg.edu.api.data.ResultData;
import com.pg.edu.api.data.TrainingData;
import com.pg.edu.api.layer.OutputLayer;
import com.pg.edu.api.node.Node;

public class OutputLayerImpl implements OutputLayer {

    private final int size;
    private final List<Node> nodes;

    public OutputLayerImpl(int size) {
        this.size = size;
        nodes = new LinkedList<>();
    }

    @Override
    public ErrorData calculateError(TrainingData trainingData) {

        return null;
    }

    @Override
    public ResultData getResult() {
        return null;
    }

    @Override
    public void feedForward(TrainingData trainingData) {


    }
}
