package com.pg.edu.api.layer;

import com.pg.edu.api.data.ErrorData;
import com.pg.edu.api.data.TrainingData;

public interface InputLayer extends NetworkLayer {

    void updateWeights(ErrorData errorData);

    void setInputs(TrainingData trainingData);

}
