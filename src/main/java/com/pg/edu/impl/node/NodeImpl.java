package com.pg.edu.impl.node;

import com.pg.edu.api.node.Node;
import com.pg.edu.api.nodeconnector.NodeConnector;
import com.pg.edu.impl.nodeconnector.NodeConnectorImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static java.lang.Math.exp;

public class NodeImpl implements Node {

    public static final double BIAS = 0.01;

    private final List<NodeConnector> parentNodeConnectors;
    private final List<NodeConnector> childrenNodeConnectors;
    private Optional<Double> value = Optional.empty();

    public NodeImpl(List<NodeConnector> parentNodeConnectors, List<NodeConnector> childrenNodeConnectors) {
        this.parentNodeConnectors = parentNodeConnectors;
        this.childrenNodeConnectors = childrenNodeConnectors;
    }

    public NodeImpl() {
        this.parentNodeConnectors = new LinkedList<>();
        this.childrenNodeConnectors = new LinkedList<>();
    }


//    public List<NodeConnector> getParentNodeConnectors() {
//        return parentNodeConnectors;
//    }
//
//    public List<NodeConnector> getChildrenNodeConnectors() {
//        return childrenNodeConnectors;
//    }

    @Override
    public void setValue(double value) {
        this.value = Optional.of(value);
    }

    @Override
    public Double getValue() {

        if (parentNodeConnectors.isEmpty()) {
            return value.orElseThrow(() -> new IllegalStateException("No value was set for the node"));
        }

        return parentNodeConnectors.stream().map(nodeConnector ->
                BIAS + (nodeConnector.getWeight() * nodeConnector.getParentNode().getValue())).mapToDouble(this::sigmoidFunction).sum();

    }

    @Override
    public NodeConnector connect(Node otherNode) {
        NodeConnector nodeConnector = new NodeConnectorImpl(this, otherNode);
        childrenNodeConnectors.add(nodeConnector);

    }

    private Double sigmoidFunction(double z) {
        return 1.0 / (1.0 + exp(-z));
    }
}
