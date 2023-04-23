package com.start.io.service;

import com.start.io.Filter.DataFilter;
import com.start.io.entity.Data;

import java.util.List;

public interface DataService {

    public List<Data> findDataByFilter(DataFilter dataFilter) ;
}
