package com.start.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

@Getter
@Setter
@Builder
@Cacheable
@AllArgsConstructor
public class Data {
    public Data() {
    }
    @JsonIgnore
    private String sessionId;
    private String advertiserId;
    private String country;
    private double price;
    private int eventTypeId;
    private double gdpr;
    private double minCpm;
    private double priority;
    private double bidPrice;

}
