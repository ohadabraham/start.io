package com.start.io.service;

import com.start.io.Filter.DataFilter;
import com.start.io.entity.Data;
import com.start.io.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    public List<Data> findDataByFilter(DataFilter dataFilter) {

        List <Data> dataList =dataRepository.findDataByFilter(dataFilter);
        return dataList;
    }
}
