package com.pg.edu.impl.layer;

import com.pg.edu.api.data.ErrorData;
import com.pg.edu.api.data.TrainingData;
import com.pg.edu.api.layer.InputLayer;
import com.pg.edu.api.node.Node;
import com.pg.edu.impl.node.NodeImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class InputLayerImpl implements InputLayer {

    private final int size;
    private List<Node> nodes;

    public InputLayerImpl(int size) {
        this.size = size;
        this.nodes = new LinkedList<>();
        initNodes();

    }

    private void initNodes() {

        IntStream.range(0, size).mapToObj(value -> new NodeImpl()).forEach(node -> nodes.add(node));
    }

    @Override
    public void updateWeights(ErrorData errorData) {

    }

    @Override
    public void setInputs(TrainingData trainingData) {

        IntStream.range(0, size).forEach(index -> nodes.get(index).setValue(trainingData.getInputs().get(index)));
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
