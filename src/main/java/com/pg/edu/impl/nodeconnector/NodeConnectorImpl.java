package com.pg.edu.impl.nodeconnector;

import com.pg.edu.api.node.Node;
import com.pg.edu.api.nodeconnector.NodeConnector;

public class NodeConnectorImpl implements NodeConnector {


    private final Node parentNode;
    private final Node childrenNode;
    private Double weight;

    public NodeConnectorImpl(Node parentNode, Node childrenNode) {
        this.parentNode = parentNode;
        this.childrenNode = childrenNode;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public Node getParentNode() {
        return parentNode;
    }

    @Override
    public Node getChildrenNode() {
        return childrenNode;
    }

    @Override
    public Double getWeight() {
        return weight;
    }
}
