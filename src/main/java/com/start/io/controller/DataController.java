package com.start.io.controller;


import com.start.io.Filter.DataFilter;
import com.start.io.entity.Data;
import com.start.io.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/start/io/listings")
public class DataController {

    private final DataService dataService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Data> getAllPlayers(
            @RequestParam (value = "min_price")BigDecimal minPrice,
            @RequestParam (value = "max_price")BigDecimal maxPrice,
            @RequestParam (value = "min_min_cpm")Integer minMinCpm,
            @RequestParam (value = "max_min_cpm")Integer maxMinCpm) {
        DataFilter filter = DataFilter.builder().minPrice(minPrice.doubleValue()).maxPrice(maxPrice.doubleValue()).minMinCPM(minMinCpm).maxMinCPM(maxMinCpm).build();
        return dataService.findDataByFilter(filter);

    }
}
