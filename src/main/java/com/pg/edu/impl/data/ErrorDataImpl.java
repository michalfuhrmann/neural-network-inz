package com.pg.edu.impl.data;

import com.pg.edu.api.data.ErrorData;

import java.util.List;

public class ErrorDataImpl implements ErrorData{

    private List<Double> values;

    public ErrorDataImpl(List<Double> values){
        this.values = values;
    }

    @Override
    public List<Double> getErrorValues() {
        return values;
    }

    @Override
    public int getNumberOfCorrectAnwsers() {
        return 0;
    }
}
