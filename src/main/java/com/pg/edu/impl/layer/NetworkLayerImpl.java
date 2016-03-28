package com.pg.edu.impl.layer;

import com.pg.edu.api.layer.NetworkLayer;
import com.pg.edu.api.node.Node;
import com.pg.edu.impl.node.NodeImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class NetworkLayerImpl implements NetworkLayer {

    private final int size;
    private final List<Node> nodes;

    public NetworkLayerImpl(int size) {
        this.size = size;
        this.nodes = new LinkedList<>();
        initNodes();
    }

    private void initNodes() {

        IntStream.range(0, size).mapToObj(value -> new NodeImpl()).forEach(nodes::add);
    }

    @Override
    public List<Node> getNodes() {
        return nodes;
    }
}
