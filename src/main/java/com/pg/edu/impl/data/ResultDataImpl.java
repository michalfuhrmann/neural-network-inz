package com.pg.edu.impl.data;

import com.pg.edu.api.data.ResultData;

import java.util.List;

public class ResultDataImpl implements ResultData {


    public final List<Double> data;


    public ResultDataImpl(List<Double> data) {
        this.data = data;
    }

    public List<Double> getResults() {
        return data;
    }
}
