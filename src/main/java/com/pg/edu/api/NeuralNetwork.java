package com.pg.edu.api;


import com.pg.edu.api.data.ResultData;
import com.pg.edu.api.data.TrainingData;
import com.pg.edu.api.dataset.ErrorDataSet;
import com.pg.edu.api.dataset.TrainingDataSet;

public interface NeuralNetwork {


    //put results on Queue and monitor it ?
    void train(TrainingDataSet dataSet);


    ErrorDataSet validate(TrainingDataSet dataSet);


    ResultData compute(TrainingData dataSet);


}
