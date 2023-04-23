package com.start.io.repository;

import com.start.io.Filter.DataFilter;
import com.start.io.entity.Data;

import java.util.List;

public interface DataRepository {

    List<Data> findDataByFilter(DataFilter dataFilter) ;

}
