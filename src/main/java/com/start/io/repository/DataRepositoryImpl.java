package com.start.io.repository;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.start.io.Filter.DataFilter;
import com.start.io.entity.Data;
import com.start.io.util.CsvReader;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DataRepositoryImpl implements DataRepository {

    private Cache<String,Data> cache ;
    private final CsvReader csvReader;
    @PostConstruct
    public void init() {

        cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS)
                .maximumSize(10000)
                .build();
        String s = "src/main/resources/files/listing-details.csv";
        HashMap <String,Data > dataMap = CsvReader.readFromCsv(s);

        cache.putAll(dataMap);
    }

    public List<Data> findDataByFilter(DataFilter filter) {

        List <Data> dataList = cache.asMap().values().stream().toList();

        return dataList.stream()
                .filter(data -> data.getPrice() >= filter.getMinPrice())
                .filter(data -> data.getPrice() <= filter.getMaxPrice())
                .filter(data -> data.getMinCpm() >= filter.getMinMinCPM())
                .filter(data -> data.getMinCpm() <= filter.getMaxMinCPM())
                .collect(Collectors.toList());
    }
}
