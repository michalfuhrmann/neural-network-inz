package com.pg.edu.impl.dataset;

import com.pg.edu.api.data.LearningData;
import com.pg.edu.api.dataset.LearningDataSet;

import java.util.List;

public class LearningDataSetImpl implements LearningDataSet {

    private final List<LearningData> learningDatas;

    public LearningDataSetImpl(List<LearningData> learningDatas) {
        this.learningDatas = learningDatas;
    }


    @Override
    public List<LearningData> getData() {
        return learningDatas;
    }
}
