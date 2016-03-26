package com.pg.edu.api.layer;

import com.pg.edu.api.data.ErrorData;
import com.pg.edu.api.data.ResultData;
import com.pg.edu.api.data.TrainingData;

public interface OutputLayer extends NetworkLayer{

    ErrorData calculateError(TrainingData trainingData);


    ResultData getResult();

    void feedForward(TrainingData trainingData);
}
