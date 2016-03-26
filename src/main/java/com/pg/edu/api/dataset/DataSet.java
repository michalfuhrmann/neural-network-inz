package com.pg.edu.api.dataset;

import com.pg.edu.api.data.Data;

import java.util.List;

public interface DataSet<T extends Data> {

    List<T> getData();
}
