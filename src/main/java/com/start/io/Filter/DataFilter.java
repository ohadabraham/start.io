package com.start.io.Filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DataFilter {

    private double minPrice;
    private double maxPrice;
    private int minMinCPM;
    private int maxMinCPM;
}
