package com.pg.edu.impl.dataset;

import com.pg.edu.api.data.TrainingData;
import com.pg.edu.api.dataset.TrainingDataSet;

import java.util.List;

public class TrainingDataSetImpl implements TrainingDataSet {

    private final List<TrainingData> trainingDatas;

    public TrainingDataSetImpl(List<TrainingData> trainingDatas) {
        this.trainingDatas = trainingDatas;
    }


    @Override
    public List<TrainingData> getData() {
        return trainingDatas;
    }
}
