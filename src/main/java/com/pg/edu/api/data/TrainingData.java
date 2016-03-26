package com.pg.edu.api.data;

import java.util.List;

public interface TrainingData extends Data{

    //TODO should be configurable
    List<Integer> getInputs();

    //TODO change to appropriate type
    List<Integer> getOutputs();
}
