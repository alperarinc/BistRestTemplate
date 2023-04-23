package com.example.bistresttemplate.client;

import com.example.bistresttemplate.model.StockResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AlphaVantageClient {

    private static final String API_KEY = "MW3EX8F87UOU3E3A";
    private static final String BASE_URL = "https://www.alphavantage.co/query";

    @Autowired
    private final RestTemplate restTemplate;

    public AlphaVantageClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public StockResponse getStockData(String symbol)  {
        ObjectMapper objectMapper = new ObjectMapper();
       try {
           String url = BASE_URL + "?function=TIME_SERIES_INTRADAY&symbol="+symbol+"&interval=5min&apikey=" + API_KEY;
           String response = restTemplate.getForObject(url, String.class);
           StockResponse stockResponse = objectMapper.readValue(response, StockResponse.class);
           return stockResponse;
       }catch (JsonProcessingException ex){
           System.out.printf("Exception: " + ex.getMessage());
           throw new RuntimeException(ex.getMessage());
       }
    }
}


