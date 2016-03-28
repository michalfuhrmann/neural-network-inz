package com.pg.edu.api.node;

import com.pg.edu.api.nodeconnector.NodeConnector;

public interface Node {

    void setValue(double value);

    Double getValue();

    NodeConnector connect(Node otherNode);

}
