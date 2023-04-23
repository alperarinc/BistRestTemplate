package com.example.bistresttemplate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockResponse {

    @JsonProperty("Meta Data")
    private Map<String, Object> metaData;

    @JsonProperty("Time Series (5min)")
    private Map<String, Object> timeSeries;
}
