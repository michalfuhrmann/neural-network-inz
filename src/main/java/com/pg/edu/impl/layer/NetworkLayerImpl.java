package com.pg.edu.impl.layer;

import com.pg.edu.api.data.TrainingData;
import com.pg.edu.api.layer.NetworkLayer;

public class NetworkLayerImpl implements NetworkLayer{

    private final int size;

    public NetworkLayerImpl(int size) {
        this.size = size;
    }

    @Override
    public void feedForward(TrainingData trainingData) {

    }
}
